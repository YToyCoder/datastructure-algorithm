package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

public class IsInterleave {
  
  public boolean isInterleave(String s1, String s2, String s3) {
    if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;
    if(s1.length() + s2.length() != s3.length()) 
      return false;
    final char[] s1cs = s1.toCharArray();
    final char[] s2cs = s2.toCharArray();
    final char[] s3cs = s3.toCharArray();
    final boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
    dp[0][0] = true;
    for(int i=0; i<=s1cs.length; i++){
      for(int j=0; j<=s2cs.length; j++){
        final int walk = i + j - 1;
        if(i > 0)
          dp[i][j] |= (Objects.equals(s1cs[i - 1], s3cs[walk]) && dp[i - 1][j]);
        if(j > 0)
          dp[i][j] |= (Objects.equals(s2cs[j - 1], s3cs[walk]) && dp[i][j - 1]);
      }
    }
    return dp[s1.length() ][s2.length()];
  }

}
