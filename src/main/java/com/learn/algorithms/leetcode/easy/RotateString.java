package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

public class RotateString {
	public boolean rotateString(String s, String goal) {
		int len;
		if((len = s.length()) != goal.length()) return false;
		for(int i=0; i<len; i++){
			int j;
			for(j=0; j<len; j++){
				if(!Objects.equals(s.charAt(j + i), goal.charAt(j)))
					break;
			}
			if(j == len) return true;
		}
		return false;
	}
}
