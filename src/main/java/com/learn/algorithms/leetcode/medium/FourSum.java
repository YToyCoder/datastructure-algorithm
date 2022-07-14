package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
  
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/4sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class FourSum {
  
  public List<List<Integer>> fourSum(int[] nums, int target) {
    if(Objects.isNull(nums) || nums.length == 0) return null;
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> group = new ArrayList<>(4);
    for(int i=0; i < nums.length; i++){
      if(i == 0 || nums[i] != nums[i - 1]){
        group.add(nums[i]);
        traceback(nums, i + 1 , target, ans, group, nums[i]);
        group.remove(0);
      }
    }
    return ans;
  }


  void traceback(int[] nums, int start, int target, List<List<Integer>> store, List<Integer> group, long sum){
    if(group.size() == 4){
      if(sum == target)
        store.add(new ArrayList<>(group));
      return; 
    } 
    // 剪枝
    if(start >= nums.length || (nums.length - start + group.size() < 4)) return;
    if(sum >= target && nums[start] > 0) return;
    for(int i=start; i < nums.length; i++){
      if(i == start || nums[i] != nums[i - 1]){
        group.add(nums[i]);
        traceback(nums, i + 1, target, store, group, sum + nums[i]);
        group.remove((int)(group.size() - 1));
      }
    }
  }
  
  // 排序和双指针
  public List<List<Integer>> fourSum2(int[] nums, int target) {
    if(Objects.isNull(nums) || nums.length == 0) return null;
    Arrays.sort(nums);
    int rl, rr; // right left - right right
    List<List<Integer>> ans = new ArrayList<>();
    for(int ll=0; ll < nums.length - 2; ll++){
      if(ll == 0 || nums[ll] != nums[ll - 1]) // rm repeat
      for(int lr = ll + 1; lr < nums.length - 1; lr++){
        if(lr == ll + 1 || nums[lr] != nums[lr - 1]) { // rm repeat
          long sum = 0;
          rl = lr + 1;
          rr = nums.length - 1;
          while(rl != rr){
            sum = (long)nums[ll] + (long)nums[lr] + (long)nums[rl] + (long)nums[rr];
            if((rl == lr + 1 || nums[rl] != nums[rl - 1]) && sum == target){
              ans.add(List.of(nums[ll], nums[lr], nums[rl], nums[rr]));
            }
            if(sum > target) rr--;
            else rl++;
          }
        }
      }
    }
    return ans;
  }

}
