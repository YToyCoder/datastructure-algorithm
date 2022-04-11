package com.learn.algorithms.leetcode.hard;

public class Trap {
	
	public int trap(int[] height) {
		int len = height.length;
		int[] lefts = new int[len];
		int[] rights = new int[len];
		int max = 0;
		for(int i=0; i<len; i++){
			lefts[i] = max > height[i] ? max : height[i]; 
			if(height[i] > max){
				max = height[i];
			} 
		}
		
		max = 0;
		for(int i=len - 1; i>=0; i--){
			rights[i] = max > height[i] ? max : height[i];
			if(rights[i] > max) max = rights[i];
		}
		int res = 0;
		for(int i=0; i<len; i++){
			res += Math.min(rights[i], lefts[i]) - height[i];
		}
		return res;
	}
}
