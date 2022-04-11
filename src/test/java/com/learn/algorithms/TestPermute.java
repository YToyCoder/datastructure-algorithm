package com.learn.algorithms;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.learn.algorithms.leetcode.medium.Permute;
import com.learn.utils.Lists;

import org.junit.Test;

public class TestPermute {
	Permute code = new Permute();
	
	@Test
	public void test1(){
		List<List<Integer>> tar = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		res.add(1);
		res.add(2);
		tar.add(res);
		res = new ArrayList<>();
		res.add(3);
		res.add(0);
		tar.add(res);
		assertTrue(Lists.contains(tar, new int[][]{new int[]{1,2}, new int[]{3,0}}));
	}
	
	@Test
	public void test2(){
		List<List<Integer>> res = code.permute(new int[]{1,2,3});
		assertTrue( Lists.contains(res, new int[][] {
			new int[] {1,2,3},
			new int[] {1,3,2},
			new int[] {2,1,3},
			new int[] {2,3,1},
			new int[] {3,1,2},
			new int[] {3,2,1}
		}));
	}
}
