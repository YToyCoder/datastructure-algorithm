package com.learn.algorithms.leetcode.medium;

public class ArrayNesting {

  public int arrayNesting(int[] nums) {
    int ans = -1;
    boolean[] visit = new boolean[nums.length];
    for(int i=0; i < nums.length; i++){
      int walk = i;
      int pathlen= 0;
      while(!visit[walk]) {
        pathlen++;
        visit[walk] = true;
        walk = nums[walk];
      }
      ans = Math.max(ans, pathlen);
    }
    return ans;
  }
}
