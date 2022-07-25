package com.learn.algorithms.leetcode.medium;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;


/*

给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。

  */
public class Combine {
  
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> combines = new LinkedList<>();
    for(int i=0; i < n; i++){
      combines.add(i + 1);
      traceback(i + 1, 1, combines, ans, k, n);
      combines.removeLast();
    }
    return ans;
  }

  void traceback(int start, int preSize, LinkedList<Integer> combines, List<List<Integer>> store, int k, int n){
    if(preSize == k){
      store.add(new ArrayList<>(combines));
    }
    if(start < n && preSize < k){
      for(int i=start; i<n; i++){
        combines.add(i + 1);
        traceback(i + 1, preSize + 1, combines, store, k, n);
        combines.removeLast();
      }
    }
  }
}
