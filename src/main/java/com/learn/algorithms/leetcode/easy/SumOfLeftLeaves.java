package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

import com.learn.utils.TreeNode;

public class SumOfLeftLeaves {
  
  public int sumOfLeftLeaves(TreeNode root) {
    return sumOfLeftLeaves(root, false);
  }

  int sumOfLeftLeaves(TreeNode root, boolean left){
    if(
      Objects.isNull(root.left) && 
      Objects.isNull(root.right)
    ) return left ? root.val : 0;
    return 
    (Objects.nonNull(root.left) ? sumOfLeftLeaves(root.left, true) : 0) + 
    ( Objects.nonNull(root.right) ? sumOfLeftLeaves(root.right, false) : 0);
  }

}
