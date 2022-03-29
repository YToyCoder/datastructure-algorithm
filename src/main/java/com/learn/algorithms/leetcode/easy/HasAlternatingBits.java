package com.learn.algorithms.leetcode.easy;

public class HasAlternatingBits {

	public boolean hasAlternatingBits(int n) {
		if(n < 2) return false;
		int last = n % 2;
		n = n / 2;
		while(n > 0){
			if(last == n % 2)return false;
			last = n % 2;
			n = n / 2;
		}
		return true;
	}
}
