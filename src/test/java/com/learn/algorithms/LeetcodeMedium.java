package com.learn.algorithms;

import com.learn.algorithms.leetcode.medium.Medium;
import org.junit.Assert;
import org.junit.Test;

public class LeetcodeMedium {
  static Medium code = new Medium();

  @Test
  public void solveEquation(){
    code.solveEquation("x+5-3+x=6+x-2");
  }

  @Test
  public void numSubarrayProductLessThanK_test(){
    Assert.assertEquals(8, code.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    Assert.assertEquals(0, code.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 0));
    Assert.assertEquals(18, code.numSubarrayProductLessThanK(new int[] {10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
    Assert.assertEquals(11, code.numSubarrayProductLessThanK(new int[] {100, 2, 3, 4, 100, 5, 6, 7, 100}, 100));
  }
}
