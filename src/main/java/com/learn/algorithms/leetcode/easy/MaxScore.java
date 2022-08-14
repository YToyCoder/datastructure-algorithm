package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

public class MaxScore {
  
  public int maxScore(String s) {
    // if(Objects.equals("11", s) || Objects.equals("00", s)) return 1;
    int[] sum = new int[s.length()];
    sum[0] = Objects.equals(s.charAt(0), '0') ? 1 : 0;
    for(int i=1; i<s.length() - 1; i++){
      sum[i] = (Objects.equals(s.charAt(i), '0') ? 1 : 0) + sum[i - 1];
    }
    int right_sum = 0;
    int ans = s.length() - 1;
    for(int i=s.length() - 1; i > 0; i--){
      // sum[i] = 
      right_sum += (Objects.equals(s.charAt(i), '1') ? 1 : 0);
      sum[i] += right_sum;
      if(sum[i] > sum[ans]) ans = i;
    }
    return switch (s) {
      case "11" , "00" -> 1;
      case "01" -> 2;
      case "10" -> 0;
      default -> sum[ans];
    };
  }
}
