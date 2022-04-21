package com.learn.algorithms.leetcode.medium;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		int len = nums.length;
		boolean flag = false;
		for (int i = len - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				flag = true;
				int front = nums[i - 1];
				if (i + 1 == len) {
					nums[i - 1] = nums[i];
					nums[i] = front;
				}else{
					int j;
					for (j= i + 1; j < len; j++) {
						if (nums[j] <= front) {
							break;
						}
					}
					nums[i - 1] = nums[j - 1];
					nums[j - 1] = front;
					for (int k = j - 1; k < len - 1; k++) {
						if (nums[k + 1] > nums[k]) {
							front = nums[k + 1];
							nums[k + 1] = nums[k];
							nums[k] = front;
						}
					}
					for (int k = 0; k < (len - i) / 2; k++) {
						front = nums[i + k];
						nums[i + k] = nums[len - k - 1];
						nums[len - k - 1] = front;
					}
				}
				break;
			}
		}
		if(!flag)
			for (int i = 0; i < len / 2; i++) {
				int temp = nums[i];
				nums[i] = nums[len - i - 1];
				nums[len - i - 1] = temp;
			}
	}
	public static void main(String[] args) {
		new NextPermutation().nextPermutation(new int[]{1,5,1});
		System.out.println("");
	}
}
