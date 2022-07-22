package com.learn.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
  
  public boolean containsDuplicate(int[] nums) {
    if(nums.length < 2) return false;
    Map<Integer,Integer> counts = new HashMap<>();
    for(int el : nums){
      int count = counts.computeIfAbsent(el, key -> 0);
      if(count == 1) return true;
      counts.replace(el, count + 1);
    }
    return false;
  }

}
