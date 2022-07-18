package com.learn.algorithms.leetcode.easy;

public class TitleToNumber {
  
  int toInt(char c){
    return (int)c - (int)'A' + 1;
  }
  final int Power = 26;

  public int titleToNumber(String columnTitle) {
    int ans = 0;
    for(int i=0; i < columnTitle.length(); i++){
      ans = ans * Power + toInt(columnTitle.charAt(i));
    }
    return ans;
  }
}
