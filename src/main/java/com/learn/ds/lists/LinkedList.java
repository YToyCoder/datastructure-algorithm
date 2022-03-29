package com.learn.ds.lists;

import java.util.Objects;
import java.util.function.Consumer;

public class LinkedList<T> {
	// head
	private Node<T> head;

	// tail
	private Node<T> tail;

	private int size = 0;

	public LinkedList(){
		head = tail = null;
	}

	@SafeVarargs
	public LinkedList(T... vals){
		for(T val : vals)
			add(val);
	}

	public int size(){
		return size;
	}

	public void add(T val){
		Node<T> node;
		if(Objects.isNull(tail)){
			node = Node.newInstance(null, val, null);
			head = tail = node;
		}else {
			node = Node.newInstance(tail, val, null);
			tail.next(node);
			tail = node;
		}
		++size;
	}

	public void prepend(T val){
		Node<T> node;
		if(Objects.isNull(head)){
			node = Node.newInstance(null, val, null);
			head = tail = node;
		}else{
			node = Node.newInstance(null, val, head);
			head.prev(node);
			head = node;
		}
		++size;
	}

	protected Node<T> find(T val){
		return find(head,val);
	}

	public void traverse(Consumer<T> consumer){
		Iterator<T> iterator = iterator();
		while(iterator.hasNext())
			consumer.accept(iterator.next());
	}

	/**
	 * 尾递归 : scala 效率高, java不知道
	 * tail recursive
	 * @param node
	 * @param val
	 * @return
	 */
	protected Node<T> find(Node<T> node, T val){
		if(Objects.isNull(node)) return null;
		else if(Objects.equals(node.value(),val)) return node;
		else return find(node.next(),val);
	}

	/**
	 * find val by index
	 * @param loc
	 * @return if exists val else null
	 */
	public T find(int loc){
		if(Objects.isNull(head))
			throw new IndexOutOfBoundsException();
		Node<T> node = find(loc, head);
		return node.value();
	}

	protected Node<T> find(int index, Node<T> node){
		if(index >= size)
			throw new IndexOutOfBoundsException();
		else if(index == 0) return node;
		else return find(--index, node.next());
	}

	public boolean contains(T val){
		return Objects.nonNull(find(val));
	}

	public boolean remove(T val){
		Node<T> node;
		if(Objects.nonNull(node = find(val))){
			remove(node);
			return true;
		}
		--size;
		return false;
	}


	protected T remove(Node<T> node){
		if(Objects.isNull(node))
			throw new NullPointerException();
		T val = node.value();
		if(node == head){
			Node<T> prev = tail.prev();
			if(Objects.nonNull(prev))
				prev.next(null);
			tail = prev;
		}
		else if(node == tail){
			Node<T> next = head.next();
			if(Objects.nonNull(next))
				next.prev(null);
			head = next;
		}
		else {
			Node<T> prev = node.prev();
			Node<T> next = node.next();
			prev.next(next);
			next.prev(prev);
		}
		--size;
		return val;
	}

	public boolean empty(){
		return size <= 0;
	}

	public String toString(){
		Iterator<T> iterator = iterator();
		StringBuilder sb = new StringBuilder("[");
		if(iterator.hasNext()) sb.append(iterator.next());
		while(iterator.hasNext())
			sb.append(",").append(iterator.next());
		int len = sb.length();
		sb.append("]");
		return sb.toString();
	}

	protected T removeTail(){
		return remove(tail);
	}
	protected T removeHead(){
		return remove(head);
	}

	public Iterator<T> iterator(){
		return new DefaultIterator();
	}

	public class DefaultIterator implements Iterator<T>{
		private Node<T> cursor;

		public DefaultIterator(){
			cursor = head;
		}

		@Override
		public T next() {
			if(!hasNext())
				throw new IteratorException();
			T val = cursor.value();
			cursor = cursor.next();
			return val;
		}

		@Override
		public T remove() {
			if(!hasNext())
				throw new IteratorException();
			return LinkedList.this.remove(cursor);
		}

		@Override
		public boolean hasNext() {
			return Objects.nonNull(cursor);
		}
	}
}
