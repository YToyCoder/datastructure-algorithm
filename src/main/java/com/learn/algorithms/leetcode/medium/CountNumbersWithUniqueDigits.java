package com.learn.algorithms.leetcode.medium;

public class CountNumbersWithUniqueDigits {
	
	public int countNumbersWithUniqueDigits(int n) {
		if(n == 0) return 1;
		// 1 ~ 9
		int count = 1;
		int temp = 1;
		int val;
		for(int i=1; i <= n; i++){
			val = 10;
			temp = 9;
			for(int j=1; j<i; j++){
				temp *= val - j;
			}
			count += temp;
		}
		return count;
	}
}
