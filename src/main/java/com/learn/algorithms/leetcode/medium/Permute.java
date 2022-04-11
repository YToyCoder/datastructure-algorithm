package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute {

	/**
	 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
	 * 回溯
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> store = new ArrayList<>();
		for(int num : nums){
			store.add(num);
		}
		backtrace(nums.length, store, res, 0);
		return res;
	}
	
	void backtrace(int n, List<Integer> store, List<List<Integer>> res, int first){
		if(first == n){
			res.add(new ArrayList<>(store));
		}
		for(int i=first; i<n; i++){
			Collections.swap(store, first, i);
			backtrace(n, store, res, first + 1);
			Collections.swap(store, first, i);
		}
	}
}
