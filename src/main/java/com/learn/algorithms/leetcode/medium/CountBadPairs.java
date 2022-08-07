package com.learn.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CountBadPairs {
  
  public long countBadPairs(int[] nums) {
    long count = 0;
    Map<Integer, IntHolder>  records = new HashMap<>();
    for(int i=0; i < nums.length; i++){
      IntHolder holder = records.computeIfAbsent(nums[i] - i, key -> new IntHolder());
      count += holder.val;
      holder.val += 1;
    }
    final long n = nums.length;
    return n * (n - 1) / 2 - count;
  }

  static class IntHolder {
    int val = 0;
  }
}
