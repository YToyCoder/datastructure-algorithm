package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

public class MaxConsecutiveAnswers {
	public static void main(String[] args) {
		int r = new MaxConsecutiveAnswers().maxConsecutiveAnswers("TFFT", 1);
		r = new MaxConsecutiveAnswers().maxConsecutiveAnswers("TTFTTFTT", 1);
		System.out.println(r);
	}

	public int maxConsecutiveAnswers(String answerKey, int k) {
		return Math.max(common(answerKey, k, 'F'), common(answerKey, k, 'T'));
	}
	
	private int common(String answerKey, int k, char c){
		if(answerKey.length() < 2) return answerKey.length();
		int left = -1;
		int right = 0;
		int op = 0;
		int len = 0;
		int max = 0;
		while(right < answerKey.length() && left <= right){
			if(op <= k) {
				if(Objects.equals(answerKey.charAt(right), c)){
					++op;
				}
				len++;
				if(op <= k && max < len) max = len;
				right++;
			}else {
				left++;
				if(Objects.equals(answerKey.charAt(left), c)){
					--op;
				}
				len--;
			}
		}
		return max;
	}
}
