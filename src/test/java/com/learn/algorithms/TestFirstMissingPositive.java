package com.learn.algorithms;

import static org.junit.Assert.assertEquals;

import com.learn.algorithms.leetcode.hard.FirstMissingPositive;

import org.junit.Test;

public class TestFirstMissingPositive {
	FirstMissingPositive code = new FirstMissingPositive();

	@Test
	public void test1() {
		assertEquals("缺失的第一个正数 1,2,0", 3, code.firstMissingPositive(new int[] { 1, 2, 0 }));
	}

	@Test
	public void test2() {
		assertEquals("缺失的第一个正数 3,4,-1,1", 2, code.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
	}

	@Test
	public void test3() {
		assertEquals("缺失的第一个正数 7,8,9,11,12", 1, code.firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
	}

	@Test
	public void test4() {
		assertEquals("缺失的第一个正数 1,2,3", 4, code.firstMissingPositive(new int[] { 1, 2, 3 }));
	}
}
