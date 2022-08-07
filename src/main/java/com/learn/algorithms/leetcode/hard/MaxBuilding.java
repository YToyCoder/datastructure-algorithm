package com.learn.algorithms.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MaxBuilding {
 

  public int maxBuilding(int n, int[][] restrictions) {
    Map<Integer, Integer> restrictionsMap = new HashMap<>();
    for(int[] restriction : restrictions){
      restrictionsMap.put(restriction[0], restriction[1]);
    }

    final int[] maxHeights = new int[n];
    final int[] heights = new int[n];
    maxHeights[0] = 0;
    heights[0] = 0;
    for(int i=1; i<n; i++){
      final Integer restriction = restrictionsMap.get(i);
      if(Objects.isNull(restriction)) {
      } 
    }
    return maxHeights[n - 1];
  } 
}
