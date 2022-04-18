package com.learn.algorithms;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import com.learn.algorithms.leetcode.medium.LexicalOrder;

import org.junit.Test;

public class TestLexicalOrder {
	
	@Test
	public void test(){
		LexicalOrder code = new LexicalOrder();
		List<Integer> res1 = code.lexicalOrder(2);
		assertArrayEquals(new Integer[]{1,2}, res1.toArray());
		res1 = code.lexicalOrder(13);
		assertArrayEquals(new Integer[]{1,10,11,12,13,2,3,4,5,6,7,8,9}, res1.toArray());
	}
}
