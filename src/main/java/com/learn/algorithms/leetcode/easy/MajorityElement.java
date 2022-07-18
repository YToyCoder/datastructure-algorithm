package com.learn.algorithms.leetcode.easy;

import java.util.Arrays;

public class MajorityElement {
  // 2n+2 -> n+2 n
  // nums.length
  // n n
  // a < n/2 , b < n/2

  // 分治方法
  // 假设el是nums里面的众数，将nums分成两部分，el必定是其中一部分的众数，对该部分进行递归操作，最终汇总分支结果
  public int majorityElement(int[] nums) {
    if(nums.length == 1) return nums[0];
    Arrays.sort(nums);
    int historyMax = 0;
    int el = -1;
    int currentCount = 0;
    for(int i=0; i<nums.length; i++){
      if(i == 0 || nums[i] == nums[i - 1]) {
        currentCount++;
        // usb
        if(
          i == nums.length - 1 && 
          nums[i] == nums[i - 1] && 
          currentCount > historyMax
        ) { 
          historyMax = currentCount;
          el = nums[i];
        }
      }else{ // not equals in i and i - 1
        if(historyMax < currentCount){
          historyMax = currentCount;
          el = nums[i - 1];
        } 
        currentCount = 1;
      }
    }
    return el;
  }

  
}
