package com.learn.algorithms.leetcode.easy;

public class CountGoodNumbers {
  

  final long mod = (long)1e9 + 7;
	public int countGoodNumbers(long n) {
		// 0 2 4 6 8
		// 2 3 5 7
		long n1 = (n >> 1);
		long n2 = n1;
		if ((n & 1) == 1) {
			n2++;
		}
		return (int) (this.pow(4, n1) * this.pow(5, n2) % mod);

	}

	private long pow(long basic, long n) {
		if (n == 0) {
			return 1;
		}
		long b = pow(basic, n >> 1) % mod;
		long bb = b * b % mod;
		return (n & 1) == 0 ? bb : bb * basic % mod;
	}

}
