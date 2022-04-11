package com.learn.algorithms;

import static org.junit.Assert.assertEquals;

import com.learn.algorithms.leetcode.hard.Trap;

import org.junit.Before;
import org.junit.Test;

public class TestTrap {
	Trap code;

	@Before
	public void init(){
		code = new Trap();
	}
	
	@Test
	public void test1(){
		assertEquals("0,1,0,2,1,0,1,3,2,1,2,1",6, code.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}
	
	public void test2(){
		assertEquals("4,2,0,3,2,5",9, code.trap(new int[]{4,2,0,3,2,5}));
	}
}
