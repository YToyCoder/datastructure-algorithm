package com.learn.algorithms.leetcode.medium;

/**
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
例子：
Intput: nums = [1,1,1,2,2,3]
OutPut: 5, nums = [1,1,2,2,3]
*/
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		int len = 0;
		int count = 0;
		for(int move = 0; move < nums.length; move++){
			if(len > 0) {
				if(nums[move] == nums[move - 1] && count + 1 > 2) continue;
				else if(nums[move] != nums[move - 1]) count = 1;
				else	count++;
				nums[len++] = nums[move]; 
			}else{
				nums[0] = nums[move];
				len++;
				count = 1;
			}
		}
		return len;
	}
}
