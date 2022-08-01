package com.learn.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MaxEqualRowsAfterFlips {
  
  public int maxEqualRowsAfterFlips(int[][] matrix) {
    Map<String,IntHolder> counts = new HashMap<>();
    int max = Integer.MIN_VALUE;
    for(int[] row : matrix){
      StringBuilder builder = new StringBuilder(0);
      for(int i=1; i<row.length; i++){
        builder.append(row[0] ^ row[i]);
      }
      final String key = builder.toString();
      final IntHolder count = counts.computeIfAbsent(key, k -> new IntHolder());
      count.val++;
      if(max < count.val) max = count.val;
    }
    return max;
  }

  static class IntHolder {
    int val = 0;
  }
}
