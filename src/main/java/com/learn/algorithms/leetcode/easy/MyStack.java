package com.learn.algorithms.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
  private Queue<Integer> temp = new LinkedList<>();
  private Queue<Integer> tail = new LinkedList<>();
  
  public MyStack() {
  }
  
  public void push(int x) {
    tail.offer(x);
  }
  
  public int pop() {
    return mv(true);
  }

  int mv(boolean remove){
    if(tail.size() > 1){
      while(tail.size() > 1){
        temp.offer(tail.poll());
      }
    }else if(tail.size() == 0){
      // mv temp to tail
      while(temp.size() > 1){
        tail.offer(temp.poll());
      }
      final int tailValue = temp.poll();
      if(!remove) tail.offer(tailValue);
      return tailValue;
    }
    return remove ? tail.poll() : tail.peek();
  }
  
  public int top() {
    return mv(false);
  }
  
  public boolean empty() {
    return temp.isEmpty() && tail.isEmpty();
  }
}
