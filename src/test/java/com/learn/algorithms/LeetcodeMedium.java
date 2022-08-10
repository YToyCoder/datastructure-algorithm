package com.learn.algorithms;

import com.learn.algorithms.leetcode.medium.Medium;
import org.junit.Test;

public class LeetcodeMedium {
  static Medium code = new Medium();

  @Test
  public void solveEquation(){
    code.solveEquation("x+5-3+x=6+x-2");
  }
}
