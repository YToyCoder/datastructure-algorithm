package com.learn.algorithms;

import static org.junit.Assert.assertEquals;

import com.learn.algorithms.leetcode.medium.CountNumbersWithUniqueDigits;

import org.junit.Test;

public class TestCountNumbersWithUniqueDigits {
	CountNumbersWithUniqueDigits code = new CountNumbersWithUniqueDigits();
	
	@Test
	public void testZeroShuldBeOne(){
		assertEquals("0", 1, code.countNumbersWithUniqueDigits(0)); 
	}
	
	@Test
	public void testTwoShouldBeNintyOne(){
		assertEquals("2", 91, code.countNumbersWithUniqueDigits(2));
	}
	
	@Test
	public void test7(){
		assertEquals("7", 712891, code.countNumbersWithUniqueDigits(7));
	}

	@Test
	public void test5(){
		assertEquals("5", 32491, code.countNumbersWithUniqueDigits(5));
	}
}
