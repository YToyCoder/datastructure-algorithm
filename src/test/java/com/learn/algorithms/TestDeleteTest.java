package com.learn.algorithms;

import static org.junit.Assert.assertEquals;

import com.learn.algorithms.leetcode.easy.DeleteText;

import org.junit.Test;

public class TestDeleteTest {
	DeleteText code = new DeleteText();
	
	@Test
	public void test1(){
		assertEquals("Singing in the rain", code.deleteText("Singing dancing in the rain", 10));
	}
	
	@Test
	public void test2(){
		assertEquals("World", code.deleteText("Hello World", 2));
	}

	@Test
	public void test3(){
		assertEquals("Hello World", code.deleteText("Hello World", 5));
	}
	
	@Test
	public void test4(){
		assertEquals("", code.deleteText("Hello", 0));
	}
	

	@Test
	public void test5(){
		assertEquals("e RSg c R", code.deleteText("e RSg c R cf", 10));
	}
}
