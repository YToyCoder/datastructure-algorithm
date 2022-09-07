package com.learn.algorithms.leetcode.hard;

import java.util.Arrays;

public class Hards {
  public int uniqueLetterString(String s) {
    final int len = s.length();
    final char[] chars = s.toCharArray();
    int[] l = new int[len];
    int[] recorder = new int[26];
    Arrays.fill(recorder, -1);
    for(int i=0; i<len; i++){
      final int loc = chars[i] - 'A';
      l[i] = recorder[loc];
      recorder[loc] = i;
    }
    Arrays.fill(recorder, len);
    int[] r = new int[len];
    for(int i=len - 1; i >= 0; i--){
      final int loc = chars[i] - 'A';
      r[i] = recorder[loc];
      recorder[loc] = i;
    }
    int sum = 0;
    for(int i=0; i<len; i++){
      sum += (i - l[i]) * (r[i] - i);
    }
    return sum;
  }

}
