package com.learn.algorithms.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {
	public static final String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
	"....", "..", ".---", "-.-", ".-..", "--", "-.",
	"---", ".--.", "--.-", ".-.", "...", "-", "..-",
	"...-", ".--", "-..-", "-.--", "--.."};

	
	public int uniqueMorseRepresentations(String[] words) {
		Set<String> store = new HashSet<>();
		for(String word : words){
			StringBuilder sb = new StringBuilder();
			for(char c : word.toCharArray())
				sb.append(MORSE[c - 'a']);
			store.add(sb.toString());
		}
		return store.size();
	}

}
