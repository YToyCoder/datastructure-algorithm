package com.learn.algorithms;

import static org.junit.Assert.assertEquals;

import com.learn.algorithms.leetcode.easy.MostCommonWord;

import org.junit.Test;

public class TestMostCommonWord {

	@Test
	public void test(){
		MostCommonWord code = new MostCommonWord();
		String res = code.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"});
		assertEquals("ball", res);
	}
}
