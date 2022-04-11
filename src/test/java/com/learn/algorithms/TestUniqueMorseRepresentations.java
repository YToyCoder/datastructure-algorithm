package com.learn.algorithms;

import static org.junit.Assert.assertEquals;

import com.learn.algorithms.leetcode.hard.UniqueMorseRepresentations;

import org.junit.Test;

public class TestUniqueMorseRepresentations {
	UniqueMorseRepresentations code = new UniqueMorseRepresentations();
	
	@Test
	public void test1(){
			assertEquals("gin, zen, gig, msg",2, code.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
	}
}
