package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomIndex {
	private Random random = new Random();
	private Map<Integer, List<Integer>> store = new HashMap<>();
	public RandomIndex(int[] nums) {
		List<Integer> list;
		for(int i=0; i<nums.length; i++){
			list = store.computeIfAbsent(nums[i], val -> new ArrayList<>());
			list.add(i);
		}
	}

	public int pick(int target){
		List<Integer> ls = store.get(target);
		return ls.get(random.nextInt(ls.size()));
	}
}
