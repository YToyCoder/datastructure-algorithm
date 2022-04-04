package com.learn.algorithms.leetcode.easy;

public class NextGreatestLetter {
	
	public char nextGreatestLetter(char[] letters, char target) {
		// 10**4 >= letters length >= 2
		char res = letters[0];
		int len = letters.length;
		if(target < letters[len - 1] ){
			for(int i=0; i<len; ++i){
				if(target < letters[i]){
					res = letters[i];
					break;
				}
			}
		}
		return res;
	}
}
