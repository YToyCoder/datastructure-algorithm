package com.learn.algorithms;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.hasItems;

import java.util.List;

import com.learn.algorithms.leetcode.hard.FindSubstring;

import org.junit.Test;

public class TestFindSubstring {

	@Test
	public void test(){
		FindSubstring code = new FindSubstring();
		List<Integer> res = code.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
		assertThat(res, hasItems(0, 9));
	}
	
	public static void main(String[] args) {
		new TestFindSubstring().test();
	}
}
