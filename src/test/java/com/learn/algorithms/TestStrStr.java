package com.learn.algorithms;

import static org.junit.Assert.assertEquals;

import com.learn.algorithms.leetcode.easy.StrStr;

import org.junit.Test;

public class TestStrStr {
	StrStr code = new StrStr();
	
	@Test
	public void test(){
		int res1 = code.strStr("hello", "ll");
		assertEquals(2, res1);
		res1 = code.strStr("hello", "bba");
		assertEquals(-1, res1);
	}
}
