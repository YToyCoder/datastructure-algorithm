package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

public class StrStr {

	public int strStr(String haystack, String needle) {
		if(needle.length() <= 0) throw new RuntimeException();
		int len = haystack.length();
		int nlen = needle.length();
		int walk = 0;
		for(int i = 0; i < len; i++){
			walk = 0;
			if(i + nlen > len ) return -1;
			for(;walk < nlen && walk + i < len; walk++){
				if(!Objects.equals(needle.charAt(walk), haystack.charAt(i + walk)))
					break;
			}
			if(walk == nlen) return i;
		}
		return -1;
	}
}
