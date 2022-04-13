package com.learn.algorithms.leetcode.easy;

public class NumWays {

	public int numWays(int n) {
		if(n < 2) return 1;
		int prelast = 1;
		int last = 1;
		int count = 1;
		for(int i=2; i<=n; i++){
			count = (prelast + last) % 1000000007;
			prelast = last;
			last = count;
		}
		return count % 1000000007;
	}
}
