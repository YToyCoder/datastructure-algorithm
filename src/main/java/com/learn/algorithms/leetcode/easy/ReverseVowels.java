package com.learn.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * 

给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。

元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。

 */

public class ReverseVowels {
  
  public String reverseVowels(String s) {
    final char[] cs = s.toCharArray();
    List<Integer> records = new ArrayList<>(s.length());
    for(int i=0; i < s.length(); i++){
      final char c = cs[i];
      if(isVowels(c))records.add(i);
    }
    char temp; 
    int rlen = records.size();
    for(int i=0; i<rlen/2; i++){
      temp = cs[records.get(i)];
      cs[records.get(i)] = cs[records.get(rlen - i - 1)];
      cs[records.get(rlen - i - 1)] = temp;
    }
    return String.valueOf(cs);
  }

  boolean isVowels(final char c){
    final char lower = Character.toLowerCase(c);
    return Objects.equals(lower, 'a') ||
          Objects.equals(lower, 'e') || 
          Objects.equals(lower, 'i') || 
          Objects.equals(lower, 'o') || 
          Objects.equals(lower, 'u');
  }
}
