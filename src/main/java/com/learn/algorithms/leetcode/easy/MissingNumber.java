package com.learn.algorithms.leetcode.easy;

public class MissingNumber {
  
  public int missingNumber(int[] nums) {
    final int n = nums.length;
    int sum = (n * (n + 1)) / 2;
    for(int el : nums){
      sum -= el;
    }
    return sum;
  }
}
