package com.learn.algorithms.leetcode.easy;

import java.util.*;

public class TwoSum {
	
    /** Description :
     * @date 2021-11-12
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     *
     * Result 1:
     * Runtime: 1 ms, faster than 99.68% of Java online submissions for Two Sum.
     * Memory Usage: 39.4 MB, less than 50.90% of Java online submissions for Two Sum.
     */
    int[] twoSum(int[] nums, int target){

			Map<Integer,Integer> innerValues = new HashMap<>();
			int[] res = new int[2];
			for(int i=0; i<nums.length; i++){
					int v = nums[i];
					Integer loc = innerValues.get(v);
					if(loc==null) // 目前不存在i对应的number
							innerValues.put(target-v,i);
					else{
							res[0] = loc;
							res[1] = i;
							return res;
					}
			}
			// 不存在这样的两个数
			return null;
	}

	public String multiply(String num1, String num2) {
//        (a + b) * (c + d) = a*c + a*d + b *c + b * d
			int res = 0;
			int len1=num1.length();int len2=num2.length();
			int outer = 0;
			int inner = 0;
			int outerWeight = 1;
			int innerWeight = 1;
			for(int i=0; i<len1; i++){
					outer = toInt(num1.charAt(len1 - i - 1)) * outerWeight;
					innerWeight = 1;
					for(int j=0; j<len2; j++){
							inner = toInt(num2.charAt(len2  - j - 1) )* innerWeight;
							res += outer * inner;
							innerWeight *= 10;
					}
					outerWeight *= 10;
			}
			return Integer.toString(res);
	}

	private int toInt(char c) {
			switch (c) {
					case '0':
							return 0;
					case '1':
							return 1;
					case '2':
							return 2;
					case '3':
							return 3;
					case '4':
							return 4;
					case '5':
							return 5;
					case '6':
							return 6;
					case '7':
							return 7;
					case '8':
							return 8;
					case '9':
							return 9;
					default:
							return -1;
			}
	}
}
