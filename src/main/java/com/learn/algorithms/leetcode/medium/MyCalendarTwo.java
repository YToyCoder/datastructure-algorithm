package com.learn.algorithms.leetcode.medium;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MyCalendarTwo {
  private TreeMap<Integer, EndAndTime> calendar = new TreeMap<>();

  public MyCalendarTwo() {
  }
  
  public boolean book(int start, int end) {
    Map.Entry<Integer, EndAndTime> mayinclude = calendar.floorEntry(start);
    if(
      mayinclude.getKey() <= start && 
      start < mayinclude.getValue().end && 
      mayinclude.getValue().times >= 2
    ) return false;
    NavigableMap<Integer,EndAndTime> includes = calendar.subMap(start, false, end, false);
    for(Map.Entry<Integer, EndAndTime> el : includes.entrySet()){
      if(el.getValue().times >= 2) return false;
    }
    // 不存在冲突-将<-- start -- end --> 添加到calendar里面
    // 无法合并
    return true;
  }

  static class EndAndTime{
    int end;
    int times;

    public EndAndTime(int end, int times){
      this.end = end;
      this.times = times;
    }
  }

}
