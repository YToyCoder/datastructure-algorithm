package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	// 	给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
	// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
	// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
	// 来源：力扣（LeetCode）
	// 链接：https://leetcode-cn.com/problems/combination-sum
	// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> store = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		backtrace(store, candidates, temp, target, 0);
		return store;
	}
	
	private void backtrace(List<List<Integer>> store, int[] candidates, List<Integer> ints, int target, int begin){
		if(begin >= candidates.length)return ;
		int sum = ints.stream().reduce(0, (a, b) -> a + b);
		if(sum == target){
			store.add(new ArrayList<>(ints));
		}else if(sum < target){
			ints.add(0);
			for(int i=begin; i<candidates.length; i++){
				ints.set(ints.size() - 1, candidates[i]);
				backtrace(store, candidates, ints, target, i);
			}
			ints.remove(ints.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		CombinationSum code = new CombinationSum();
		code.combinationSum(new int[]{2,3,6,7}, 7);
	}
}
