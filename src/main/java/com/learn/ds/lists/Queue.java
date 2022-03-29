package com.learn.ds.lists;

public class Queue<T> {
	private final LinkedList<T> container = new LinkedList<>();

	public boolean isEmpty(){
			return container.empty();
	}

	public T peek(){
			return container.find(0);
	}

	public void enqueue(T val){
			container.add(val);
	}

	public T dequeue(){
			return container.removeHead();
	}

	public int size(){
			return container.size();
	}

	public String toString(){
			return container.toString();
	}
}
