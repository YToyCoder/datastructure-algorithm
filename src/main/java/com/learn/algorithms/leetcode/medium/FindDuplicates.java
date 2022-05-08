package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> duplicates = new ArrayList<>();
		int val;
		for(int i=0; i<nums.length; i++) {
			val = Math.abs(nums[i]);
			if(nums[val - 1] > 0) {
				nums[val - 1] = -nums[val - 1];
			}else {
				duplicates.add(val);
			}
		}
		return duplicates;
	}
}
