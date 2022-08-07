package com.learn.algorithms.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class MinAreaRect {
 
  public int minAreaRect(int[][] points) {
    final Set<Integer> hashPoints = new HashSet<>();
    for(int[] point : points){
      hashPoints.add(doHash(point));
    } 
    int max = 0;
    for(int i=0; i<points.length; i++){
      for(int j=0; j<points.length; j++){
        if(
          points[i][0] != points[j][0] &&
          points[i][1] != points[j][1] &&
          hashPoints.contains(doHash(new int[]{points[i][0], points[j][1]})) &&
          hashPoints.contains(doHash( new int[]{points[j][0], points[i][1]})) 
        ){
          int s = Math.abs(points[i][0] - points[j][0]) * Math.abs(points[j][1] - points[i][1]);
          if(s > max) max = s;
        }
      }
    }
    return max;
  } 

  static int doHash(int[] point){
    return point[0] * 4001 + point[1];
  }
}
