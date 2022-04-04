package com.learn.algorithms.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class MinDeletion {
	public int minDeletion(int[] nums) {
		int remainLen = 0;
		int len = nums.length;
		int last = 0;
		for(int i=0; i<len; ++i){
			if(remainLen % 2 == 0){
				remainLen++;
				last = i;
			}else{
				int val = nums[last];
				if(val != nums[i]){
					remainLen++;
					last = i;
				}
			}
		}
		return len - (remainLen % 2 == 0 ? remainLen : remainLen - 1);
	}

	public int old(int[] nums) {
		List<Integer> store = new LinkedList<>();
		int size;
		for(int el : nums){
			size = store.size();
			if(size % 2 == 0)
				store.add(el);
			else {
				int peek = store.get(size - 1);
				if(peek != el) store.add(el);
			}
		}
		if((size = store.size()) % 2 != 0) store.remove(size - 1);
		return nums.length - store.size();
	}
}
