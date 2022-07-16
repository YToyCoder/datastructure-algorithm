package com.learn.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MovingAverage {
  final int size;
  double sum;
  int left;
  int right;
  List<Integer> list;

  public MovingAverage(int size) {
    this.size = size;
    list = new ArrayList<>(1000);
    left = 0;
    right = 0;
  }
  
  public double next(int val) {
    sum += val;
    list.add(val);
    right++;
    // size = 2 left = 0 right = 2
    // to 2 | 0 (+) 1  (+) 2  
    if(right - left > size){
      sum -= list.get(left);
      left++;
    }
    return sum / (right - left);
  }
}
