package com.learn.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class CanBeEqual {
  
  public boolean canBeEqual(int[] target, int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<target.length; i++){
      if(target[i] != arr[i]){
        map.put(target[i], map.getOrDefault(target[i], 0) + 1);
        map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
      }
    }
    for(Map.Entry<Integer, Integer> el : map.entrySet()){
      if(el.getValue() != 0) return false;
    }
    return true;
  }
}
