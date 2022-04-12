package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

public class NumberOfLines {
	
	public int[] numberOfLines(int[] widths, String s) {
		if(Objects.isNull(s) || s.length() == 0) return new int[]{0,0};
		int len = s.length();
		int lineCount = 1;
		int lastwidth = 0;
		for(int i=0; i<len; i++){
			char c = s.charAt(i);
			int loc = c - 'a';
			if(lastwidth + widths[loc] > 100){
				lineCount++;
				lastwidth = widths[loc];
			}else if(lastwidth + widths[loc] == 100){
				lastwidth = i + 1 < len ? 0 : lastwidth + widths[loc]; 
				if(i + 1 < len) lineCount++;
			}else{
				lastwidth += widths[loc];
			}
		}
		return new int[]{lineCount, lastwidth};
	} 
}
