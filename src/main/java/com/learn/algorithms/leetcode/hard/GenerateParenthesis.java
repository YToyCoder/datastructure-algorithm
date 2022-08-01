package com.learn.algorithms.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GenerateParenthesis {
  
  public List<String> generateParenthesis(int n) {
    return generate(n, new HashMap<>());
  }

  List<String> generate(int n, Map<Integer, List<String>> cache){
    if(n <= 0) return List.of();
    List<String> mayCached = cache.get(n);
    if(Objects.nonNull(mayCached)) 
      return mayCached;
    if(n == 1) return List.of("()");
    List<String> tocache = new LinkedList<>();
    List<String> subone = generate(n - 1, cache);
    for(String s : subone){
      tocache.add("()" + s);
    }
    for(int i=1; i < n; i++){
      List<String> leftIns = generate(i, cache);
      List<String> rights = generate(n - i - 1, cache);
      for(String leftIn : leftIns){
        for(String right : rights){
          // (leftIn)right
          tocache.add("(" + leftIn + ")" + right);
        }
      }
      if(rights.isEmpty()){
        for(String leftIn : leftIns){
            // (leftIn)right
            tocache.add("(" + leftIn + ")" );
        }
      }
    }
    cache.put(n, tocache);
    return tocache;
  }
}
