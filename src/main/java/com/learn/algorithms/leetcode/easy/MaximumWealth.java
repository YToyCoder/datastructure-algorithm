package com.learn.algorithms.leetcode.easy;

public class MaximumWealth {
	
	public int maximumWealth(int[][] accounts) {
		int max = 0;
		int sum;
		for(int[] assets : accounts){
			sum = 0;
			for(int i : assets)
				sum += i;
			if(sum > max) max = sum;
		}
		return max;
	}
}
