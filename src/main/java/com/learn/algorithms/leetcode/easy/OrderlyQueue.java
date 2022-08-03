package com.learn.algorithms.leetcode.easy;

import java.util.Arrays;

public class OrderlyQueue {
  
  public String orderlyQueue(String s, int k) {
    if(k == 0) return s;
    if(k == 1) {
      String smallest = s;
      StringBuilder builder = new StringBuilder(smallest);
      for(int i=1; i<s.length(); i++){
        char del = builder.charAt(0);
        builder.deleteCharAt(0);
        builder.append(del);
        if(smallest.compareTo(builder.toString()) > 0){
          smallest = builder.toString();
        }
      }
      return smallest;
    }else{
      final char[] chars = s.toCharArray();
      Arrays.sort(chars);
      return String.valueOf(chars);
    }
  }

  // bca234561
  // 123456back
  // 1ack23456b
  // ack23456b1

}
