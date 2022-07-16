package com.learn.algorithms.leetcode.easy;

import java.util.ArrayList;

public class MovingAverage {
  int size;
  ArrayList<Integer> elements;
  
    /** Initialize your data structure here. */
  public MovingAverage(int size) {
    this.size = size;
  }
  
  public double next(int val) {
    elements.add(val);
    final int needPlus = Math.min(size, elements.size());
    double sum = 0;
    for(int i=0; i < needPlus; i++){
      sum += elements.get(elements.size() - i - 1);
    }
    return sum / needPlus;
  }
}
