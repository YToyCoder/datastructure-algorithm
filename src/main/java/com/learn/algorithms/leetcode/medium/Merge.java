package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
  
  public int[][] merge(int[][] intervals) {
    if(intervals.length <= 1) return intervals; 
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> merged = new ArrayList<>(intervals.length);
    for(int i=1; i<intervals.length; i++){
      if(intervals[i - 1][1] >= intervals[i][0] || intervals[i - 1][0] == intervals[i][0]){
        intervals[i][0] = Math.min(intervals[i - 1][0], intervals[i][0]);
        intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
        if(i == intervals.length - 1){
          merged.add(intervals[i]);
        }
      }else{
        merged.add(intervals[i - 1]);
        if(i == intervals.length - 1) merged.add( intervals[i]);
      }
    }
    return merged.toArray(new int[0][0]);
  }

  public static void main(String[] args) {
    new Merge().merge(new int[0][0]);
  }
}
