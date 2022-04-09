package com.learn.algorithms.leetcode.easy;

public class PalindromeNumber {
	
    /**
     * Given an integer x, return true if x is palindrome integer.
     * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
     *
     *
     * Runtime: 7 ms, faster than 74.54% of Java online submissions for Palindrome Number.
     * Memory Usage: 38.5 MB, less than 55.08% of Java online submissions for Palindrome Number.
     * Next challenges:
     */
    public static boolean isPalindrome(int x) {
			String v= String.valueOf(x);
			int len = v.length();
			for(int i=0; i< len/2; i++){
					if(v.charAt(i) != v.charAt(len-i-1))
							return false;
			}
			return true;
	}

	public static boolean isPalindome1(int x) {
			if(x< 0) return false;
			if(x< 10) return true;
			int remain = x;
			int drop = 0;
			int tmp = 0;
			double count = 0.1;
			while(remain > count && remain != drop) {
					tmp = remain%10;
					remain = remain/10;
					drop = drop * 10 + tmp;
					count *= 10;
			}
			if(remain != drop){
					remain = remain * 10 + tmp;
					return drop == remain;
			}
			return true;
	}

	/**
	 * Runtime: 6 ms, faster than 99.97% of Java online submissions for Palindrome Number.
	 * Memory Usage: 38.4 MB, less than 75.97% of Java online submissions for Palindrome Number.
	 */
	public static boolean isPalindome2(int x){
			if(x< 0) return false;
			if(x< 10) return true;
			if(x%10 == 0) return false;
			int remain = x;
			int drop = 0;
			int tmp = 0;
			while(remain > drop) {
					tmp = remain%10;
					remain = remain/10;
					drop = drop * 10 + tmp;
			}
			if(remain != drop){
					remain = remain * 10 + tmp;
					return drop == remain;
			}
			return true;
	}
}
