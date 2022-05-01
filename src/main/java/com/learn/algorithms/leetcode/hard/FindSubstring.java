package com.learn.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubstring {

	public List<Integer> findSubstring(String s, String[] words) {
		int sum = 0;
		for(String str : words)sum += str.length();
		if(s.length() < sum) return List.of();
		int len = s.length();
		List<Integer> res = new ArrayList<>();
		Set<Integer> excludes = new HashSet<>();
		for (int index = 0; index < len; index++) {
			if (traceback(words, s, index, 0, excludes))
				res.add(index);
		}
		return res;
	}

	private boolean traceback(String[] source, String s, int start, int index, Set<Integer> excludes) {
		if (index == source.length)
			return true;
		Set<String> store = new HashSet<>();
		for (int i = 0; i < source.length; i++) {
			String compareString = source[i];
			if (!excludes.contains(Integer.valueOf(i)) && !store.contains(compareString) && start + compareString.length() <= s.length()) {
				store.add(compareString);
				int cIndex;
				for (cIndex = 0; cIndex < compareString.length(); cIndex++) {
					if (!Objects.equals(s.charAt(start + cIndex), compareString.charAt(cIndex)))
						break;
				}
				if(cIndex == compareString.length()){
					excludes.add(i);
					if(traceback(source, s, start + compareString.length(), index + 1, excludes)){
						excludes.remove(Integer.valueOf(i));
						return true;
					}else{
						excludes.remove(Integer.valueOf(i));
					}
				}
			}
		}
		return false;
	}

}
