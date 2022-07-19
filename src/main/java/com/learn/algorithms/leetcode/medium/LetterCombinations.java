package com.learn.algorithms.leetcode.medium;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class LetterCombinations {
	
	public List<String> letterCombinations(String digits) {
		if(Objects.isNull(digits) || digits.isEmpty()) return List.of();
		Queue<String> queue = new LinkedList<>();
		String combine = "";
		int len;
		for(int i=0; i<digits.length(); i++){
			len = queue.size();
			List<String> vals = keys.get(digits.charAt(i));
			if(i == 0){
				for(String val : vals)
					queue.add(val);
			}else{
				for(int j=0; j<len; j++){
					combine = queue.remove();
					for(String val : vals){
						queue.add(combine + val);
					}
				}
			}
			
		}
		return (List<String>) queue;
	}
	
	static Map<Character, List<String>> keys;
	static {
		keys = new HashMap<>();
		keys.put('2', List.of("a","b","c"));
		keys.put('3', List.of("d","e","f"));
		keys.put('4', List.of("g","h","i"));
		keys.put('5', List.of("j","k","l"));
		keys.put('6', List.of("m","n","o"));
		keys.put('7', List.of("p","q","r","s"));
		keys.put('8', List.of("t","u","v"));
		keys.put('9', List.of("w","x","y","z"));
	}
}
