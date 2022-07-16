package com.learn.algorithms.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
  int size;
  double sum;
  Queue<Integer> queue;

  public MovingAverage(int size) {
    this.size = size;
    queue = new LinkedList<>();
  }
  
  public double next(int val) {
    sum += val;
    queue.add(val);
    if(queue.size() > size){
      int head = queue.poll();
      sum -= head;
    }
    return sum / queue.size();
  }
}
