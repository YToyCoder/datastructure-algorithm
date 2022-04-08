package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

public class MaxArea {
	public int maxArea(int[] height) {
		if(Objects.isNull(height) || height.length < 2)
			return 0;
		int left = 0;
		int right = height.length - 1;
		int res = 0;
		int temp;
		while(left < right){
			temp = Math.min(height[left], height[right]) * (right - left);
			if(temp > res) res = temp;
			if(height[left] > height[right]) right--;
			else left++;
		}
		return res;
	}
}
