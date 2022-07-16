package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

import com.learn.utils.TreeNode;

public class IsBalanced {
  
  public boolean isBalanced(TreeNode root) {
    return checkBalance(root).isBalanced;
  }

  static Result checkBalance(TreeNode root){
    // base case
    if(Objects.isNull(root)) 
      return new Result(true, 0);
    Result leftResult = checkBalance(root.left);
    Result rightResult = checkBalance(root.right);
    if(leftResult.isBalanced && 
       rightResult.isBalanced && 
       Math.abs(rightResult.height - leftResult.height) <= 1
    ) return new Result(true, Math.max(rightResult.height, leftResult.height) + 1);
    return new Result(false, -1);
  }

  static class Result {
    boolean isBalanced;
    int height;

    public Result(boolean isBalanced, int h){
      this.isBalanced = isBalanced;
      this.height = h;
    }
  }
 
}
