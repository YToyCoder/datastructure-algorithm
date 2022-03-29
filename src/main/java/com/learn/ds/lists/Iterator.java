package com.learn.ds.lists;

public interface Iterator<T> {
	T next();
	T remove();
	boolean hasNext();
}
