package com.learn.algorithms.leetcode.medium;

public class ReverseInteger {

    /**
     * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     *
     * Runtime: 2 ms, faster than 45.62% of Java online submissions for Reverse Integer.
     * Memory Usage: 36.2 MB, less than 65.22% of Java online submissions for Reverse Integer.
     */
    public static int reverse(int x) {
			int signal = x < 0 ? -1 : 1;
			int v = Math.abs(x);
			String strV = String.valueOf(v);
			char[] chars = strV.toCharArray();
			for(int i=0; i<chars.length/2; i++){
					char tmp = chars[i];
					chars[i] = chars[chars.length-i-1];
					chars[chars.length-i-1] = tmp;
			}
			try{
					int absV = Integer.valueOf(new String(chars));
					return signal * absV ;
			}catch(NumberFormatException e){
					return 0;
			}
	}

	/**
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
	 * Memory Usage: 36.2 MB, less than 65.22% of Java online submissions for Reverse Integer.
	 */
	public static int reverse2(int x) {
			int signal = x < 0 ? -1:1;
			int v= Math.abs(x);
			long reversedV = 0L;
			while (v>0) {
					reversedV = reversedV*10 + v%10;
					v = v/10;
			}
			return reversedV > (long)(Math.pow(2,31)-1) ? 0: (int)reversedV * signal;
	}
}
