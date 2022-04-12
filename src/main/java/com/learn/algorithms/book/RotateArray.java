package com.learn.algorithms.book;

import java.util.Objects;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		int len;
		// 1 2 3 4 5 , 3
		// 3 4 5 1 2
		if(Objects.isNull(nums) || (len = nums.length) == 0 ) return ;
		int move = k % len;
		reverse(nums, 0, len - 1);
		reverse(nums, 0, move - 1);
		reverse(nums, move, len - 1);
	}

	private void reverse(int[] nums, int left, int right){
		int len;
		if(Objects.isNull(nums) || (len = nums.length) == 0 || left >= len || right >= len)
			return ;
		while(left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
}
