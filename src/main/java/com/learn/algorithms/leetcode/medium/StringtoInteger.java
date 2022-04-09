package com.learn.algorithms.leetcode.medium;

public class StringtoInteger {

	static final long bound = (long)Math.pow(2, 31);
	/**
	 * mplement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
	 * The algorithm for myAtoi(string s) is as follows:
	 * Read in and ignore any leading whitespace.
	 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
	 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
	 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
	 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
	 * Return the integer as the final result.
	 *
	 *
	 * Runtime: 2 ms, faster than 71.24% of Java online submissions for String to Integer (atoi).
	 * Memory Usage: 39 MB, less than 66.55% of Java online submissions for String to Integer (atoi).
	 */
	public int myAtoi(String s) {
		long r = 0L;
		char[] cs = s.trim().toCharArray();
		if(cs.length == 0 || type(cs[0]) == -1)return 0;
		int signal = cs[0] == '-' ? -1 : 1;
		if(ctoi(cs[0]) != -1)r = ctoi(cs[0]);
		for(int i=1; i<cs.length;i++ ){
				int v = ctoi(cs[i]);
				if(v == -1)break;
				r = r*10 + v;
				if(r > bound)break;
		}
		long bound = (long)Math.pow(2, 31);
		return (int)(signal > 0 ? Math.min(r, bound - 1) : r > bound ? signal * bound : signal * r);
	}

	/**
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for String to Integer (atoi).
	 * Memory Usage: 38.9 MB, less than 86.35% of Java online submissions for String to Integer (atoi).
	 */
	public int myAtoi2(String s){
			long r = 0L;
			char[] cs = s.toCharArray();
			if(cs.length == 0 )return 0;
			int walk = 0;
			while (walk < cs.length && cs[walk] == ' ' ) walk++; // step out ' '
			if(walk == cs.length || type(cs[walk]) == -1) return 0;
			int signal = cs[walk] == '-' ? -1 : 1;
			if(ctoi(cs[walk]) != -1) r = ctoi(cs[walk]);
			for(int i=walk + 1; i<cs.length;i++ ){
					int v = ctoi(cs[i]);
					if(v == -1)break;
					r = r*10 + v;
					if(r > bound)break;
			}
			return (int)(signal > 0 ? Math.min(r, bound - 1) : r > bound ? signal * bound : signal * r);
	}


	public int ctoi(char c){
			switch(c){
					case '0':
							return 0;
					case '1':
							return 1;
					case '2':
							return 2;
					case '3':
							return 3;
					case '4':
							return 4;
					case '5':
							return 5;
					case '6':
							return 6;
					case '7':
							return 7;
					case '8':
							return 8;
					case '9':
							return 9;
					default:
							return -1;
			}
	}
	public int type(char c){ // 1 digit 0 - + -1 other
			int r = 1;
			switch(c){
					case '-':
					case '+':
							r = 0;
							break;
					default:
							if(ctoi(c) == -1)
									r = -1;
							break;
			}
			return r ;
	}
}
