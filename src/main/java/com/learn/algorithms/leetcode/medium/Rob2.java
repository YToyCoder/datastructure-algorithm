package com.learn.algorithms.leetcode.medium;

public class Rob2 {
  
  public int rob(int[] nums) {
    if(nums.length == 1) return nums[0];
    int[] dp = new int[nums.length];
    int[] dp2 = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    dp2[0] = 0;
    dp2[1] = nums[1];
    for(int i=2; i<nums.length; i++){
      if(i == nums.length - 1) 
        dp[i] = dp[i - 1];
      else
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
      dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
    }
    int max = 0;
    for(int i=0; i<nums.length; i++){
      max = Math.max(max, Math.max(dp[i],dp2[i]));
    }
    return max;
  }

}
