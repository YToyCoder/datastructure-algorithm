package com.learn.algorithms.leetcode.easy;

public class IsPowerOfFour {
  
  public boolean isPowerOfFour(int n) {
    if(n == 4 || n == 1) return true;
    else if(n <= 0 || (n & 0b011) > 0) return false;
    else return isPowerOfFour(n >> 2);
  }
}
