package com.learn.algorithms.leetcode.easy;

public class ReverseString {
  
  public void reverseString(char[] s) {
    final int mid = s.length / 2; // 2 / 2 = 1 0  3 / 2 = 1 
    char temp;
    for(int i = 0; i < mid ; i++ ){
      temp = s[i];
      s[i] = s[s.length - i - 1];
      s[s.length - i - 1] = temp;
    }
  }
}
