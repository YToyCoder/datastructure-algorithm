package com.learn.algorithms.leetcode.medium;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ExclusiveTime {
  
  public int[] exclusiveTime(int n, List<String> logs) {
    final int[] ans = new int[n];
    final Stack<Integer> ps = new Stack<>();
    Iterator<String> iter = logs.iterator();
    String[] log = iter.next().split(":"); 
    int running = Integer.valueOf(log[0]);
    int start = Integer.valueOf(log[2]) - 1;
    while(iter.hasNext()){
      log = iter.next().split(":");
      int newone = Integer.valueOf(log[0]);
      int newone_start = Integer.valueOf(log[2]);
      if(Objects.equals(log[1], "start")){
        // stop old
        ps.add(running);
        newone_start -= 1;
        ans[running] += newone_start - start;
        running = newone;
      }else{
        // finish --> start one from ps
        ans[running] += newone_start - start;
        if(!ps.isEmpty())
          running = ps.pop();
      }
      start = newone_start ;
    }
    return ans;
  }
}
