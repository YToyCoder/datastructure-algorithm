package com.learn.ds.lists;

public class Node<T> {
	private Node<T> prev;
	private Node<T> next;
	private T value;

	public static <T> Node<T> newInstance(Node<T> prev, T val, Node<T> next){
		return new Node<>(prev, val, next);
	}

	public Node(Node<T> prev, T value, Node<T> next){
		this.prev = prev;
		this.value = value;
		this.next = next;
	}

	public T value() {
		return value;
	}

	public void value(T val){
		this.value = val;
	}

	public void next(Node<T> next){
		this.next = next;
	}

	public Node<T> next(){
		return next;
	}

	public void prev(Node<T> prev){
		this.prev = prev;
	}

	public Node<T> prev(){
		return prev;
	}
}
