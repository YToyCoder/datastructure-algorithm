package com.learn.algorithms.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

	/**
	 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
	 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
	 */
	
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		int[] smaller = new int[len + 1];
		for(int num : nums){
			if(num <= len && num > 0) smaller[num]=1;
		}
		int res = 0;
		while(res < len && smaller[res + 1] != 0){
			res++;
		}
		return res + 1;
	}

	public int firstMissingPositiveOld(int[] nums) {
		int len = nums.length;
		int[] smaller = new int[len];
		Set<Integer> restore = new HashSet<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<len; i++){
			int val = nums[i];
			if(val > max && val > 0) max = val;
			if(val < min && val > 0) min = val;
			smaller[i] = val + 1;
			restore.add(val);
		}
		if(min > 1) return 1;
		min = -1;
		for(int item : smaller){
			if(!restore.contains(item) && item > 0 && (item < min || min == -1)){
				min = item;
			}
		}
		return min != -1 ? min : max + 1;
	}
}
