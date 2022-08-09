package com.learn.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FindSubstringInWraproundString {
  
  public int findSubstringInWraproundString(String p) {
    Map<Character, IntHolder> mapper = new HashMap<>();
    int left = 0;
    for(int i=0; i<p.length(); i++){

      IntHolder holder = mapper.computeIfAbsent(p.charAt(i), key -> new IntHolder());

      holder.val = Math.max(holder.val, i - left + 1);
      if(
        !(
          i != p.length() - 1 &&
          (
            p.charAt(i + 1) - p.charAt(i) == 1 ||
            (
              Objects.equals(p.charAt(i + 1), 'a')  &&
              Objects.equals(p.charAt(i), 'z')
            )
          )
        )
      ){
        left = i + 1;
      }
    }
    return mapper
    .values()
    .stream()
    .mapToInt(el -> el.val)
    .reduce(0, (a, b) -> a + b);
  }

  static class IntHolder {
    int val = 0;
  }

  public static void main(String[] args) {
    System.out.println( new FindSubstringInWraproundString().findSubstringInWraproundString("abcd"));
  }

}
