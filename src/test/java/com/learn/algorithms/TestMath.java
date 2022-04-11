package com.learn.algorithms;

import static org.junit.Assert.assertEquals;

import com.learn.algorithms.leetcode.book.Math;

import org.junit.Test;

public class TestMath {
	
	@Test
	public void testGCB(){
		assertEquals(2, Math.gcd(2, 2));
		assertEquals(1, Math.gcd(4, 5));
		assertEquals(12, Math.gcd(12, 12 * 11));
	}
}
