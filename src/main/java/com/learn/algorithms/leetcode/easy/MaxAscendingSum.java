package com.learn.algorithms.leetcode.easy;

public class MaxAscendingSum {
  
  public int maxAscendingSum(int[] nums) {
    int maxSum = 0;
    int subsum = 0;
    for(int i=0; i<nums.length; i++){
      subsum += nums[i];
      if(i == nums.length - 1 || nums[i] >= nums[i + 1]){
        if(subsum > maxSum) maxSum = subsum;
        subsum = 0;
      }
    }
    return maxSum;
  }
}
