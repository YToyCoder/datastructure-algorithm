package com.learn.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence {
  
  public List<Integer> minSubsequence(int[] nums) {
    int sum = 0;
    final IndexAndVal[] indexAndVals = new IndexAndVal[nums.length];
    for(int i=0; i<nums.length; i++){
      sum += nums[i];
      indexAndVals[i] = new IndexAndVal(i, nums[i]);
    }

    Arrays.sort(indexAndVals, (a, b) -> b.value - a.value);

    int subsum = 0;
    List<Integer> ans = new ArrayList<>();
    for(int i=0; i<indexAndVals.length && subsum  * 2 <= sum; i++){
      subsum += indexAndVals[i].value;
      ans.add(indexAndVals[i].value);
    }

    return ans;
  }

  static class IndexAndVal{
    final int index;
    final int value;

    public IndexAndVal(final int _index, final int _value){
      index = _index;
      value = _value;
    }
  }
}
