package com.learn.algorithms.book;

import java.util.Arrays;

// Given an array of size n, find the majority element. The majority element is the
// element that appears more than b n/2 c times. You may assume that the array is
// non-empty and the majority element always exist in the array.
public class MajorityElement {
	public int majorityElement(int[] nums) {
		if(nums.length == 1) return nums[0];
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
}