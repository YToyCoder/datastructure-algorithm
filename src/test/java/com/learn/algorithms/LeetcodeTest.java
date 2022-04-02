package com.learn.algorithms;

import com.learn.algorithms.leetcode.book.CountAndSay;
import com.learn.algorithms.leetcode.book.RemoveElement;

import junit.framework.TestCase;

public class LeetcodeTest extends TestCase {
	
	public LeetcodeTest(String name){
		super(name);
	}
	
	public void testCountAndSay(){
		CountAndSay code = new CountAndSay();
		String res1 = code.countAndSay(1);
		assertEquals("1", res1);
		String res2 = code.countAndSay(2);
		assertEquals("11", res2);
		String res3 = code.countAndSay(3);
		assertEquals("21", res3);
		String res4 = code.countAndSay(4);
		assertEquals("1211", res4);
		String res5 = code.countAndSay(6);
		assertEquals("312211", res5);
	}
	
	public void testRemoveElement(){
		RemoveElement code = new RemoveElement();
		int res1 = code.removeElement(new int[]{3,2,2,3}, 3);
		assertEquals(2, res1);
	}
}
