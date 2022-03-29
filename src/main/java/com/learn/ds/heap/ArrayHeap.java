package com.learn.ds.heap;

import com.learn.utils.Heaps;
import com.learn.utils.Lists;

import java.util.ArrayList;
import java.util.Objects;

public abstract class ArrayHeap<T> extends AbstractHeap<T> {
	protected ArrayList<T> arr = new ArrayList<>();
	@Override
	public void buildHeap() {
			int len = arr.size();
			for(int start=len/2 - 1; start >= 0; start--){
					heapifyDown(start);
			}
	}

	@Override
	public T peek() {
			return arr.get(0);
	}

	@Override
	public T poll() {
			T t = arr.get(0);
			swap(0,size() - 1);
			arr.remove(size() - 1);
			heapifyDown(0);
			return t;
	}

	@Override
	public void add(T value) {
			arr.add(value);
			heapifyUp(arr.size() - 1);
	}

	@Override
	public void swap(int first, int second) {
			T tmp = arr.get(first);
			arr.set(first,arr.get(second));
			arr.set(second,tmp);
	}

	@Override
	public boolean hasLeftChild(int current) {
			return Heaps.leftChild(current) < arr.size();
	}

	@Override
	public boolean hasRightChild(int current){
			return Heaps.rightChild(current) < arr.size();
	}

	@Override
	public boolean hasParent(int current){
			return Heaps.parent(current) >= 0;
	}

	@Override
	public int size(){
			return arr.size();
	}

	public String toString(){
			return Lists.listToString(arr);
	}
	
	public static class MinArrayHeap<T extends Comparable<? super T>> extends ArrayHeap<T> {

    public MinArrayHeap(ArrayList<T> arr){
			this.arr = arr;
			buildHeap();
		}

		@Override
		public boolean correctOrder(int first, int second) {
			T fV , sV;
			return first < arr.size() &&
							Objects.nonNull(fV = arr.get(first)) &&
							Objects.nonNull(sV = arr.get(second)) &&
							fV.compareTo(sV) < 0;
		}
	}

	public static class MaxArrayHeap<T extends Comparable<? super T>> extends ArrayHeap<T> {

    public MaxArrayHeap(ArrayList<T> arrs){
			this.arr = arrs;
			buildHeap();
		}

		@Override
		public boolean correctOrder(int first, int second) {
			T fV , sV ;
			return  first < arr.size() &&
							Objects.nonNull(fV = arr.get(first)) &&
							Objects.nonNull(sV = arr.get(second)) &&
							fV.compareTo(sV) > 0;
		}
	}
	
	public static <T extends Comparable<? super T>> Heap<T> maxHeap(T[] source){
		ArrayList<T> list = new ArrayList<>(source.length * 2);
		for(T i : source)
			list.add(i);
		return new MaxArrayHeap<T>(list);
	}
	
	public static <T extends Comparable<? super T>> Heap<T> minHeap(T[] source){
		ArrayList<T> list = new ArrayList<>(source.length * 2);
		for(T i : source)
			list.add(i);
		return new MinArrayHeap<>(list);
	}
}
