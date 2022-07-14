package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String,List<String>> ans = new HashMap<>();
    for(String str : strs) {
      char[] bytes = str.toCharArray();
      Arrays.sort(bytes);
      List<String> ls = ans.computeIfAbsent(String.valueOf(bytes), k -> new ArrayList<>());
      ls.add(str);
    }
    return new ArrayList<>(ans.values());
  }

}
