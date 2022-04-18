package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LexicalOrder {

	// 	给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
	// 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
	// 回溯
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>(n);
		for(int i=1; i < 10 && i <= n; i++){
			res.add(i);
			backTrace(res, i * 10, n);
		}
		return res;
	}
	
	private void backTrace(List<Integer> store, int start, int n){
		if(start > n) return;
		for(int i=0; i < 10 && start + i <= n; i++ ){
			store.add(start + i);
			backTrace(store, (start + i) * 10, n);
		}
	}
}
