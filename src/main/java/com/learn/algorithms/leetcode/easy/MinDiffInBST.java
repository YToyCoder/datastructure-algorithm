package com.learn.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.learn.utils.TreeNode;

public class MinDiffInBST {
  
  int min = Integer.MAX_VALUE;
  public int minDiffInBST(TreeNode root) {
    interthemTrav(root, new ArrayList<>());
    return min;
  }

  void interthemTrav(TreeNode root, List<Integer> arr){
    if(Objects.isNull(root)) return;
    interthemTrav(root.left, arr);
    //
    if(!arr.isEmpty()){
      int temp ;
      if((temp = Math.abs( arr.get(arr.size() - 1)  - root.val)) < min)min = temp; 
    }
    arr.add(root.val);
    interthemTrav(root.right, arr);
  }
}
