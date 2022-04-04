package com.learn.algorithms.leetcode.medium;

import java.util.LinkedList;

public class Jump {
	public int jump(int[] nums) {
		if(nums.length <= 1) return 0;
		int maxlen = -1;
		int depth = 0;
		int end = 0;
		int temp;
		for(int i=0; i<nums.length; ++i){
			if((temp = nums[i] + i) > maxlen) maxlen = temp;
			if(i == end || i == nums.length - 1) {
				depth++;
				end = maxlen;
			}
		}
		return depth - 1;
	}

	public int old(int[] nums) {
		int len = nums.length;
		if(len <= 1) return 0;
		LinkedList<Integer> store  = new LinkedList<>();
		for(int i=1; i<=nums[0]; i++){
			store.add(i);
		}
		int size, cur;
		int step = 0;
		boolean mark = true;
		while(!store.isEmpty() && mark){
			step++;
			size = store.size();
			for(int i=0; i<size; i++){
				cur = store.removeFirst();
				if(cur >= len - 1) {
					mark = false;
					break;
				}else{
					for(int j=1; j<=nums[cur]; ++j)
						store.add(cur + j);
				}
			}
		}
		return step;
	}
}
