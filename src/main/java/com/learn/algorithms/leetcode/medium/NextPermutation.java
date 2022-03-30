package com.learn.algorithms.leetcode.medium;

import java.util.Arrays;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		int len = nums.length;
		if(len > 1){
			boolean has = false;
			int i=0;
			for(; i < len - 1; i++){
				int min = -1;
				for(int j=i+1; j < len; j++){
					if(nums[j] > nums[i] && 
						((min != -1 && nums[j] < nums[min]) || min == -1)
						){
						min = j;
					}
					if(nums[j - 1] < nums[j])
						has = true;
				}
				if(!has) break;
				if(min != -1){
					int tmp = nums[i];
					nums[i] = nums[min];
					nums[min] = tmp;
					break;
				}
			}
			if(!has){
				int tmp;
				for(i=0; i<len/2; i++){
					tmp = nums[i];
					nums[i] = nums[len - i - 1];
					nums[len - i - 1] = tmp;
				}
			}else{
				Arrays.sort(nums, i + 1, len);
			}
		}
	}
}
