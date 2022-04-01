package com.learn.algorithms;

import java.util.List;

import com.learn.algorithms.leetcode.book.RotateArray;
import com.learn.utils.Lists;

import junit.framework.TestCase;

public class RotateArrayTest extends TestCase {
	public RotateArrayTest(String name) {
		super(name);
	}
	
	public void testRun(){
		int[] benckmark = new int[]{1,2,3,4};
		String old = Lists.intArrayToString(benckmark);
		RotateArray rotate = new RotateArray();
		rotate.rotate(benckmark, 1);
		String ne = Lists.intArrayToString(benckmark);
		assertEquals("( 4 1 2 3 )", ne);
		int[] test2 = new int[]{1,2,3,4};
		rotate.rotate(test2, 4);
		String res2 = Lists.intArrayToString(test2);
		assertEquals("( 1 2 3 4 )", res2);
	}
}
