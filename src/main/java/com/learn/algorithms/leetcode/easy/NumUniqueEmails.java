package com.learn.algorithms.leetcode.easy;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class NumUniqueEmails {

  public int numUniqueEmails(String[] emails) {
    Set<String> emls = new HashSet<String>();
    for(final String email : emails){
      emls.add(resolve(email));
    }
    return emls.size();
  }

  String resolve(String source){
    StringBuilder builder = new StringBuilder();
    final char[] chars = source.toCharArray();
    boolean ignore = false;
    int i=0;
    for(; i < chars.length && !Objects.equals(chars[i], '@'); i++){
      if(!ignore && Objects.equals(chars[i], '+')){
        ignore = true;
      }
      if(!ignore && !Objects.equals(chars[i], '.')){
        builder.append(chars[i]);
      }
    }
    builder.append(source.substring(i, source.length()));
    return builder.toString();
  }

}
