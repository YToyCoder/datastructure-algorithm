package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

public class ShortestToChar {
	
	public int[] shortestToChar(String s, char c) {
		int len = s.length();
		char val;
		int pre = -1, count;
		int[] res = new int[len];
		for(int i=0; i<len; i++){
			val = s.charAt(i);
			if(Objects.equals(c, val)){
				res[i] = 0;
				if(pre == -1){
					count = 1;
					for(int j=i - 1; j >= 0; j--){
						res[j] = count++;
					}
				}else {
					for(int j=0; j < (i - pre)/2; j++){
						res[pre + j + 1] = j + 1;
						res[i - j - 1] = j + 1;
					}
				}
				pre = i;
			}else if(i + 1 == len){
					count = i - pre;
					for(int j=i; j > pre; j--){
						res[j] = count--;
					}
				}
		}
		return res;
	}
}
