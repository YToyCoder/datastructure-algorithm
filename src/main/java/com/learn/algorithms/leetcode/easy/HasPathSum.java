package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

import com.learn.utils.TreeNode;

public class HasPathSum {
  
  public boolean hasPathSum(TreeNode root, int targetSum) {
    return has(root, 0, targetSum);
  }

  boolean has(TreeNode root, int preSum , int targetSum){
    if(Objects.isNull(root)) return false;
    if(Objects.isNull(root.left) && Objects.isNull(root.right)) return preSum + root.val == targetSum;
    return has(root.left, preSum + root.val, targetSum) || has(root.right, preSum + root.val, targetSum);
  }
}
