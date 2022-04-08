package com.learn.algorithms.leetcode.medium;

public class Divide {
	public int divide(int dividend, int divisor) {
		boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
		dividend = dividend > 0 ? -dividend : dividend;
		divisor = divisor > 0 ? -divisor : divisor;
		int res = flag ? todo(dividend, divisor) : -todo(dividend, divisor);
		return flag && res < 0 ? 2147483647 : res;
	}
	
	private int todo(int dividend, int divisor){
		if(dividend > divisor) return 0;
		int count = 1;
		int sum = divisor;
		while(sum + sum > dividend && sum + sum < 0){
			count += count;
			sum += sum;
		}
		return count + todo(dividend - sum, divisor);
	}
}
