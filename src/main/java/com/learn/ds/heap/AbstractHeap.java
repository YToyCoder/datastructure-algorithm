package com.learn.ds.heap;

import com.learn.utils.Heaps;

public abstract class AbstractHeap<T> implements Heap<T> {

	public void heapifyDown(int start){
		int current = start;
		int next = -1;
		int left,right;
		while(hasLeftChild(current)) {
				left = Heaps.leftChild(current);
				right = Heaps.rightChild(current);
				next = hasRightChild(current) && correctOrder(right,left) ? right : left;
				if(correctOrder(current, next)) break;
				swap(next, current);
				current = next;
		}
}

/**
 * 上滤
 * @param start
 */
public void heapifyUp(int start) {
		int current = start;
		while(hasParent(current) && !correctOrder(Heaps.parent(current), current)){
				swap(current,Heaps.parent(current));
				current = Heaps.parent(current);
		}
}

public abstract void buildHeap();
}
