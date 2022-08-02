package com.learn.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class WordPattern {
  
  public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    if(words.length != pattern.length()) return false;
    Set<Character> hasMapped = new HashSet<>();
    Map<String, Character> mapper = new HashMap<>();
    for(int i=0; i < words.length; i++){
      final Character mapped = mapper.get(words[i]);
      if(Objects.nonNull(mapped) && 
        !Objects.equals(mapped , pattern.charAt(i)) 
      ) return false;
      if(Objects.isNull(mapped)){
        if(hasMapped.contains(pattern.charAt(i))) return false;
        mapper.put(words[i], pattern.charAt(i));
        hasMapped.add(pattern.charAt(i));
      }
    }
    return true;
  }

}
