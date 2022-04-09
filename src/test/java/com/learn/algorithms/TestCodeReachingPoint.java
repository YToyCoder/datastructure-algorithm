package com.learn.algorithms;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.learn.algorithms.leetcode.hard.ReachingPoint;

import org.junit.Before;
import org.junit.Test;

public class TestCodeReachingPoint {
	private ReachingPoint code ;
	@Before
	public void createCode(){
		code = new ReachingPoint();
	}
	
	@Test
	public void test1(){
		boolean res1 = code.reachingPoints(1, 1, 1, 1);
		assertTrue(res1);
		assertFalse("tx == ty (6,6) -> false", code.reachingPoints(2, 3, 8, 8));
		assertTrue("1 1 3 5", code.reachingPoints(1, 1, 3, 5));
		assertFalse("1 2 10 5", code.reachingPoints(1, 2, 10, 5));
		assertFalse("1 2 10 5", code.reachingPoints(1, 3, 10, 5));
		assertTrue("1 3 1000000000 3", code.reachingPoints(1, 3, 1000000000, 3));
	}
}
