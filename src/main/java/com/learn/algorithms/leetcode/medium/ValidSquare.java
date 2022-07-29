package com.learn.algorithms.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSquare {
  
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    int[][] ps = new int[][]{ p1, p2, p3, p4};
    Set<Double> lens = new HashSet<>();
    for(int i=0; i<ps.length - 1; i++){
      // lens[i] = Math.pow(p1[0] - ps[i][0], 2) + Math.pow(p1[1] - ps[i][1], 2);
      int[] p = ps[i];
      for(int j=i + 1; j < ps.length ; j++){
      lens.add(Math.pow(p[0] - ps[j][0], 2) + Math.pow(p[1] - ps[j][1], 2));
      }
    }
    if(lens.size() != 2) return false;
    Double[] ans = lens.toArray(new Double[0]);
    return ans[0] > ans[1]  ? ans[0] == ans[1] * 2 : ans[0] * 2 == ans[1];
  }
}
