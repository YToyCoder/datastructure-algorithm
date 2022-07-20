package com.learn.algorithms.leetcode.medium;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {
  private TreeMap<Integer, Integer> calendar = new TreeMap<>();

  public MyCalendarTwo() {
  }
  
  public boolean book(int start, int end) {
    calendar.put(start, calendar.getOrDefault(start, 0) + 1);
    calendar.put(end, calendar.getOrDefault(end, 0) - 1);
    int count = 0;
    for(Map.Entry<Integer,Integer> el : calendar.entrySet()){
      count += el.getValue();
      if(count > 2){
        calendar.put(start, calendar.get(start) - 1);
        calendar.put(end, calendar.getOrDefault(end, 0) + 1);
        return false;
      }
    }
    return true;
  }
}
