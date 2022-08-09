package com.learn.algorithms.leetcode.easy;

public class MinStartValue {
  
  public int minStartValue(int[] nums) {

    int min_sum = 0;
    int sum = 0;
    for(int el : nums){
      sum += el;
      if(min_sum > sum ) min_sum = sum;
    }
    return 1 - min_sum;
  }

}
