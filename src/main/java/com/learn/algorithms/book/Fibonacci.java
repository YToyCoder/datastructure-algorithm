package com.learn.algorithms.leetcode.book;

public class Fibonacci {
	public long fibonacci(int n){
		long result = 0;
		if(n < 2) return n == 0 ? 0 : 1;
		long preOne = 1;
		long preTwo = 0;
		for(int i=2; i<=n; i++){
			result = preOne + preTwo;
			preTwo = preOne;
			preOne = result;
		}
		return result;
	}
}
