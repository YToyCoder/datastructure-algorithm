package com.learn.algorithms.leetcode.hard;

import java.util.PriorityQueue;

public class MaxSlidingWindow {
  
  public int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for(int i=0; i<k; i++)
      queue.add(new int[]{i, nums[i]});
    final int[] ans = new int[nums.length - k + 1];
    ans[0] = queue.peek()[1];
    for(int i=k; i<nums.length; i++){
      while(!queue.isEmpty() && queue.peek()[0] <= i - k) queue.poll();
      queue.offer(new int[]{i, nums[i]});
      ans[i - k + 1] = queue.peek()[1];
    }
    return ans;
  }
}
