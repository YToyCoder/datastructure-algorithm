package com.learn.algorithms.leetcode.easy;

public class InvertTree {

  public TreeNode invertTree(TreeNode root) {
    doInvert(root);
    return root;
  }

  void doInvert(TreeNode root){
    if(Objects.isNull(root)) return;
    TreeNode left  = root.left;
    TreeNode right = root.right;
    root.left = right;
    root.right = left;
    doInvert(root.left);
    doInvert(root.right);
  }

}
