package com.learn.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	
	/**
	 * Given a string s, find the length of the longest substring without repeating characters.
	 *
	 * Result:
	 * Runtime: 6 ms, faster than 70.05% of Java online submissions for Longest Substring Without Repeating Characters.
	 * Memory Usage: 40 MB, less than 37.12% of Java online submissions for Longest Substring Without Repeating Characters.
	 */
	public static int apply1(String s){
			if(s.length() < 2)return s.length();
			int maxLen = 0;
			Map<String,LinkedList<Integer>> counter = new HashMap<>();
			int start = 0;
			LinkedList<Integer> locList;
			for(int i=0; i<s.length(); i++){
					String c = s.substring(i,i+1);
					locList = counter.get(c);
					if(locList!= null){
							int lastloc = locList.getLast();
							if( lastloc >= start){
									maxLen = i - start > maxLen ? i - start : maxLen;
									start = lastloc + 1;
							}
							locList.add(i);
							if(maxLen > s.length() - start)break;
					}else{
							LinkedList<Integer> newList = new LinkedList<>();
							newList.add(i);
							counter.put(c,newList);
					}
					if(i == s.length() -1 ) {
							int tmp = i - start + 1;
							maxLen = tmp > maxLen ? tmp : maxLen;
					}
			}
			return maxLen;
	}
}
