package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

import com.learn.utils.TreeNode;

public class ConvertBST {
  
  int sum = 0;
  public TreeNode convertBST(TreeNode root) {
    doSumGreeter(root);
    return root;
  }

  public void doSumGreeter(TreeNode root){
    if(Objects.isNull(root)) return;
    doSumGreeter(root.right);
    sum += root.val;
    root.val = sum;
    doSumGreeter(root.left);
  }
}
