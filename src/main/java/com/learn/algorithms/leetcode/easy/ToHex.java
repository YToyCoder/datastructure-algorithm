package com.learn.algorithms.leetcode.easy;

public class ToHex {
  
  public String toHex(int num) {
    if(num == 0) return "0";
    StringBuilder builder = new StringBuilder();
    for(int i=7; i >=0; i--){
      int val = (num >> i * 4) & 0xf;
      if(val > 0 || builder.length() > 0){
        char digit = (char)(val < 10 ? '0' + val : val - 10 + 'a');
        builder.append(digit);
      }
    }
    return builder.toString();
  }
}
