package com.learn.algorithms.leetcode.easy;

public class MoveZeroes {
  
  public void moveZeroes(int[] nums) {
    if(nums.length <= 1) return;
    int zero = -1;
    for(int i=0; i < nums.length; i++){
      if(zero != -1 && nums[i] != 0){
        nums[zero++] = nums[i];
        nums[i] = 0;
      }else if(zero == -1 && nums[i] == 0) 
        zero = i;
    }
  }
}
