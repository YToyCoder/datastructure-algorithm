package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*

给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用 一次 。

注意：解集不能包含重复的组合。 

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class CombinationSum2 {
 
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> combination = new LinkedList<>();
    Arrays.sort(candidates);
    for(int i=0; i<candidates.length; i++){
      if(i == 0 || candidates[i] != candidates[i - 1]){
        combination.add(candidates[i]);
        traceback(candidates, i + 1, target, combination, candidates[i], ans);
        combination.removeLast();
      }
    }
    return ans;
  } 

  void traceback(int[] candidates, int start, int target, LinkedList<Integer> comb, int preSum, List<List<Integer>> store){
    
    if(preSum == target){
      store.add(new ArrayList<>(comb));
    }else if(preSum < target && start < candidates.length){
      for(int i=start; i < candidates.length; i++){
        if(i == start || candidates[i] != candidates[i - 1]){
          comb.add(candidates[i]);
          traceback(candidates, i + 1, target, comb, preSum + candidates[i], store);
          comb.removeLast();
        }
      }
    }
  }
}
