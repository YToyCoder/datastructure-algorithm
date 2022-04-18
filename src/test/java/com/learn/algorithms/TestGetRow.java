package com.learn.algorithms;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import com.learn.algorithms.leetcode.easy.GetRow;

import org.junit.Test;

public class TestGetRow {
	
	@Test
	public void test(){
		GetRow code = new GetRow();
		List<Integer> res1 = code.getRow(3);
		assertArrayEquals(new Integer[]{1,3,3,1}, res1.toArray());
		res1 = code.getRow(4);
		assertArrayEquals(new Integer[]{1, 4, 6, 4,1}, res1.toArray());
	}
}
