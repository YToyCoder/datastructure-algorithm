package com.learn.algorithms.leetcode.easy;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int len = nums.length;
		int tail = len - 1;
		for(int i=0; i < nums.length; i++){
			if(nums[i] == val){
				while(nums[tail] == val && tail > i){
					tail--; len--;
				}
			}
		}
		return len;
	}
}
