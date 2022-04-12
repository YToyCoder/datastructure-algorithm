package com.learn.algorithms.book;

import java.util.Objects;

public class LowerBound {
	public int lowerBound(int[] nums, int target){
		int len;
		if(Objects.isNull(nums) || (len = nums.length) == 0 || nums[0] >= target) return -1;
		int min = 0;
		for(int i=0; i<len && nums[i] < target; ++i){
			if(nums[min] <= nums[i]) min = i; 
		}
		return min;
	} 
}
