package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
public class PermuteUnique {
  private int[] rem;
  
  public List<List<Integer>> permuteUnique(int[] nums) {
    rem = new int[nums.length];
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    traceback(nums, new ArrayList<>(), ans);
    return ans;
  }
  
  private void traceback(int[] nums, List<Integer> ls, List<List<Integer>> ans){
    if(ls.size() == nums.length) {
      ans.add(new ArrayList<>(ls));
    }else{
      for(int i=0; i< nums.length; i++){
        if(!(i>0 && nums[i] == nums[i - 1] && rem[i - 1] == 0) && rem[i] != 1){
          rem[i] = 1;
          ls.add(nums[i]);
          traceback(nums, ls, ans);
          ls.remove(ls.size() - 1);
          rem[i] = 0;
        }
      }
    }
  }
}
