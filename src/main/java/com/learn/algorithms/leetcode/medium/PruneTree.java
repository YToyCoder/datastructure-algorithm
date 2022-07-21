package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

import com.learn.utils.TreeNode;

public class PruneTree {
  
  public TreeNode pruneTree(TreeNode root) {
    return !traveral(root) ? null : root;
  }

  boolean traveral(TreeNode root){
    if(Objects.isNull(root)) return false;
    boolean leftJ, rightJ;
    if(!(leftJ = traveral(root.left)) && Objects.nonNull(root.left)){
        root.left = null;
    }
    if(!(rightJ = traveral(root.right)) && Objects.nonNull(root.right)){
      root.right = null;
    }
    return root.val == 1 || leftJ || rightJ;
  }
}
