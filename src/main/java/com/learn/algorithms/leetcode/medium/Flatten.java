package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

import com.learn.utils.TreeNode;

public class Flatten {

  public void flatten(TreeNode root) {
    f(root);
  }

  // return tail
  TreeNode f(TreeNode root){
    if(Objects.isNull(root)) return null;
    if(Objects.isNull(root.right) && Objects.isNull(root.left)) return root;

    TreeNode leftTail = f(root.left);
    TreeNode rightTail = f(root.right);
    if(Objects.isNull(root.left)){
      return rightTail;
    }else{
      TreeNode left = root.left;
      TreeNode right = root.right;
      root.left = null;
      root.right = left;
      leftTail.right = right;
    }

    return Objects.isNull(rightTail) ? leftTail : rightTail;
  }
  
}
