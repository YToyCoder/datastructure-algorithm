package com.learn.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class MergeSimilarItems {
  
  public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
    Map<Integer, List<Integer> > ans = new TreeMap<>();
    for(int[] el : items1){
      List<Integer> one = ans.computeIfAbsent(el[0], key -> new ArrayList<>(List.of(key, 0)));
      one.set(1, one.get(1) + el[1]);
    }
    for(int[] el : items2){
      List<Integer> one = ans.computeIfAbsent(el[0], key -> new ArrayList<>(List.of(key, 0)));
      one.set(1, one.get(1) + el[1]);
    }
    return new ArrayList<>(ans.values());
  }
}
