package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

public class MinAddToMakeValid {
 
  public int minAddToMakeValid(String s) {
    int crash = 0;
    int rightPlus = 0;
    for(char el : s.toCharArray()){
      if(Objects.equals(el, '('))
        rightPlus++;
      else {
        if(rightPlus > 0) rightPlus--;
        else crash++;
      }
    }
    return crash + rightPlus;
  } 

}
