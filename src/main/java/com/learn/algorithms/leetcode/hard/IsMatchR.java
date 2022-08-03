package com.learn.algorithms.leetcode.hard;

import java.util.Objects;

public class IsMatchR {
    
  public boolean isMatch(String s, String p) {
    if(Objects.equals(p, ".*")) return true;
    final int m = s.length();
    final int n = p.length();
    final boolean[][] matches = new boolean[m + 1][n + 1];
    matches[0][0] = true;
    for(int i=1; i<=n; i++){
      if(Objects.equals(p.charAt(i - 1), '*')){
        matches[0][i] = matches[0][i - 2];
      }
    }
    for(int i=1; i <= m; i++){
      for(int j=1; j <= n; j++){
        if(Objects.equals(p.charAt(j - 1), '*')){
          // 通配符
          matches[i][j] = matches[i][j - 2] ||  
              (
                (Objects.equals(p.charAt(j - 2), '.') || Objects.equals(p.charAt(j - 2), s.charAt(i - 1))) &&
                (
                  matches[i - 1][j  - 2] || 
                  matches[i - 1][j] 
                ) 
              );
        }else if(
          Objects.equals(p.charAt(j - 1), '.') || 
          Objects.equals(p.charAt(j - 1), s.charAt(i - 1)) 
        ){
          matches[i][j] = matches[i - 1][j - 1];
        }
      }
    }
    return matches[m][n];
  }
}
