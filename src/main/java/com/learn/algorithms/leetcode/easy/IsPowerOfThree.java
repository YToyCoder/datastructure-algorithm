package com.learn.algorithms.leetcode.easy;

public class IsPowerOfThree {

  // int 能表示的3的幂的最大值为1162261467
  
  public boolean isPowerOfThree(int n) {
    return n > 0 && 1162261467 % n == 0;
  }

}
