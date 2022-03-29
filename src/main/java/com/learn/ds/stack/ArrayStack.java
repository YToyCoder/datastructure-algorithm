package com.learn.ds.stack;

import com.learn.utils.Lists;
import java.util.ArrayList;

public class ArrayStack<T> implements Stack<T> {
	private final ArrayList<T> arr = new ArrayList<>();
	@Override
	public int size() {
		return arr.size();
	}

	@Override
	public void push(T val) {
		arr.add(val);
	}

	@Override
	public T peek() {
		return arr.get(size() - 1);
	}

	@Override
	public T pop() {
		return arr.remove(size() - 1);
	}

	public String toString(){
		return Lists.listToString(arr);
	}
}
