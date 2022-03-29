package com.learn.utils;

public class Heaps {

	public static int leftChild(int current){
		return 2 * current + 1;
	}

	public static int rightChild(int current){
		return 2 * current + 2;
	}

	public static int parent(int current){
		return (current + 1)/2 - 1;
	}
}
