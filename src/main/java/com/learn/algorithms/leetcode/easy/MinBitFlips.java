package com.learn.algorithms.leetcode.easy;

public class MinBitFlips {
	
	public int minBitFlips(int start, int goal) {
		int smark, gmark;
		int count = 0;
		while(start > 0 || goal > 0){
			smark = start & 1;
			gmark = goal & 1;
			if(smark != gmark) count++;
			start  >>= 1;
			goal >>=  1;
		}
		return count;
	}
}
