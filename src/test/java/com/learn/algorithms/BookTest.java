package com.learn.algorithms;

import com.learn.algorithms.leetcode.book.CountingSort;
import com.learn.algorithms.leetcode.book.RadixSort;
import com.learn.utils.Lists;

import junit.framework.TestCase;

public class BookTest extends TestCase {
	
	public BookTest(String name){
		super(name);
	}
	
	public void testCountingSort(){
		int[] source = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		int[] A = CountingSort.countingSort(source);
		assertEquals("( 1 2 3 4 7 8 9 10 14 16 )", Lists.intArrayToString(A));
	}
	
	public void testRadixSort(){
		RadixSort code = new RadixSort();
		int[] source = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		int[] res1 = code.sort(source);
		assertEquals("( 1 2 3 4 7 8 9 10 14 16 )", Lists.intArrayToString(res1));
		int[] s2 = new int[]{62,14,59,88,16};
		int[] res2 = code.sort(s2);
		assertEquals("( 14 16 59 62 88 )", Lists.intArrayToString(res2));
	}
}
