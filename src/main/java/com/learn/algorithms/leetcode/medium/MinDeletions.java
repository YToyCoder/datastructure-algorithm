package com.learn.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class MinDeletions {
  
  public int minDeletions(String s) {
    Map<Character, List<Integer>> charWithIndex = new HashMap<>();
    TreeMap<Integer, List<Character>> countMap = new TreeMap<>();
    final char[] chars = s.toCharArray();
    for(int i=0; i<chars.length; i++){
      char c = chars[i];
      List<Integer> indexs = charWithIndex.computeIfAbsent(c, key -> new LinkedList<>());
      indexs.add(i);
      if(indexs.size() > 1)
        countMap.get(indexs.size() - 1).remove(Character.valueOf(c));
      countMap.computeIfAbsent(indexs.size(), key -> new LinkedList<>()).add(c);
    }

    int ans = 0;
    TreeSet<Integer> nocounts = new TreeSet<>();
    for(Map.Entry<Integer, List<Character>> el : countMap.entrySet()){
      if(el.getValue().size() == 0) 
        nocounts.add(el.getKey());
      if(el.getValue().size() > 1){
        ans += el.getKey() * (el.getValue().size() - 1);
        int reduceTime = el.getValue().size() - 1;
        while(!nocounts.isEmpty() && reduceTime-- > 0){
          ans -= nocounts.pollLast();
        }
      } 
    }
    return ans;
  }

  public static void main(String[] args) {
    new MinDeletions().minDeletions("aaabbbcc");
  }
}
