package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


import org.checkerframework.checker.units.qual.C;

public class Deserialize {

	public NestedInteger deserialize(String s) {
		if (Objects.equals(s, "") || Objects.equals(s, "[]"))
			return new NestedInteger();
		if(Character.isDigit(s.charAt(0)) || Objects.equals(s.charAt(0), '-'))
				return new NestedInteger(Integer.valueOf(s));
		int len = s.length();
		int val = 0;
		int flag = 1;
		LinkedList<NestedInteger> store = new LinkedList<>();
		NestedInteger root = new NestedInteger();
		NestedInteger temp = root;
		store.add(root);
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (Objects.equals(c, '[') && i > 0) {
				NestedInteger created = new NestedInteger();
				store.add(created);
				temp.add(created);
				temp = created;
			} else if (Character.isDigit(c)) {
				val = val * 10 + Character.getNumericValue(c);
				if ((i + 1 == len || !Character.isDigit(s.charAt(i + 1))) || (i + 3 < len && !Character.isDigit(s.charAt(i + 1)) && !Character.isDigit(s.charAt(i + 2)))) {
					temp.add(new NestedInteger(flag * val));
					flag = 1;
					val = 0;
				}
			} else if (Objects.equals(c, ']')) {
				store.removeLast();
				if (i + 1 != len)
					temp = store.getLast();
			} else if(Objects.equals(c, '-')){
				flag = -1;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		new Deserialize().deserialize("[123,[456,[789]]]");
	}

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public class NestedInteger {
		// Constructor initializes an empty nested list.
		public NestedInteger() {

		}

		// Constructor initializes a single integer.
		public NestedInteger(int value) {

		}

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger() {
			return true;
		}

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger() {
			return 1;
		}

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value) {

		}

		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		public void add(NestedInteger ni) {

		}

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return empty list if this NestedInteger holds a single integer
		public List<NestedInteger> getList() {
			return null;
		}
	}
}
