package com.learn.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IsIsomorphic {
  
  public boolean isIsomorphic(String s, String t) {
    if(s.length() != t.length()) return false;
    Map<Character, Character> smap = new HashMap<>();
    Map<Character, Character> tmap = new HashMap<>();
    for(int i = 0; i < s.length(); i++){
      Character s2t = smap.get(s.charAt(i));
      Character t2s = tmap.get(t.charAt(i));
      if(Objects.isNull(s2t) && Objects.isNull(t2s)){
        smap.put(s.charAt(i), t.charAt(i));
        tmap.put(t.charAt(i), s.charAt(i));
      }else if(
        Objects.isNull(s2t) || 
        Objects.isNull(t2s) ||
        !Objects.equals(s2t, t.charAt(i)) ||
        !Objects.equals(t2s, s.charAt(i))
      ) return false;
    }
    return true;
  }
}
