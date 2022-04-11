package com.learn.algorithms.leetcode.book;

public class Math {
	public static long gcd(long a, long b){
		return (b == 0) ? a : gcd(b, a % b);
	}
}
