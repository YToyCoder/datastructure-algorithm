package com.learn.algorithms.book;

public class Math {
	public static long gcd(long a, long b){
		return (b == 0) ? a : gcd(b, a % b);
	}
}
