package com.learn.algorithms;

import static org.junit.Assert.assertEquals;

import com.learn.algorithms.leetcode.hard.UniquePaths;

import org.junit.Before;
import org.junit.Test;

public class TestCodeUniquePaths {
	UniquePaths code;

	@Before
	public void init(){
		code = new UniquePaths();
	}
	
	@Test
	public void test(){
		assertEquals("m=3 n=7 -> 28", 28, code.uniquePaths(3,7));
		assertEquals("m=7 n=3 -> 28", 28, code.uniquePaths(7,3));
		assertEquals("m=3,n=2", 3, code.uniquePaths(3, 2));
		assertEquals("m=3,n=3", 6, code.uniquePaths(3, 3));
	}
}
