package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		/**
		 * 动态规划
		 * 状态转移方程 dp = int[s.length]
		 * case s[i] == '('  then dp[i] = 0
		 * case s[i] == ')' then 
		 * 	if s[i - 1] == '(' -> dp[i] = dp[i - 2] + 2
		 * 	else if s[i - 1] == ')'  ->  dp[i] = dp[i - 1]  + dp[i - dp[i - 1] - 2] + 2
		 */
		int[] dp = new int[s.length()];
		int move = 0;
		int max = 0;
		for(int i=0; i<s.length(); i++){
			// s[i] == ')' -> <1>. s[i-1] == '(' then + 2 <2>. else s[i - dp[i-1] - 1] ? 
			if(Objects.equals(s.charAt(i), ')') && i > 0){
				if(Objects.equals(s.charAt(i -1), '(')){
					dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
				}else if((move = i - dp[ i - 1] - 1) >= 0 && Objects.equals(s.charAt(move), '(')){
					dp[i] = dp[i - 1] + (move - 1 >= 0 ? dp[move - 1] : 0) + 2;
				}
				if(dp[i] > max) max = dp[i];
			}
		}
		return max;
	}
}
