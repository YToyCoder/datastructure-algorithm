package com.learn.algorithms.leetcode.easy;

import java.util.Map;
import java.util.TreeMap;

public class ArrayRankTransform {
  
  public int[] arrayRankTransform(int[] arr) {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    for(int el : arr) treeMap.put(el, 1);
    int preSum = 0;
    for(Map.Entry<Integer, Integer> el : treeMap.entrySet()){
      int temp = preSum + el.getValue();
      el.setValue(temp);
      preSum = temp;
    }
    int[] ans = new int[arr.length];
    for(int i=0; i<arr.length; i++){
      ans[i] = treeMap.get(arr[i]);
    }
    return ans;
  }
}
