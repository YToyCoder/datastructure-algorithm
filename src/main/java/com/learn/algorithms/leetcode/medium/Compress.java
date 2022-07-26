package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

public class Compress {
 
  public int compress(char[] chars) {
    if(chars.length <= 1) return chars.length;
    int walk = -1;
    int record = -1;
    for(int i=0; i<chars.length; i++){
      if(i == chars.length - 1 || !Objects.equals(chars[i + 1], chars[i])) {
        int len = i - record;
        record = i;
        walk++; // move to first
        chars[walk] = chars[i];
        if(len > 1){
          final int start = walk;
          while(len > 0){
            chars[++walk] = (char)((len % 10) + '0');
            len /= 10;
          }
          for(int j=0; j<(walk - start)/2; j++){
            char temp = chars[start + j + 1];
            chars[start + j + 1] = chars[walk - j];
            chars[walk - j] = temp;
          }
        }
      }
    }
    return walk + 1;
  } 
}
