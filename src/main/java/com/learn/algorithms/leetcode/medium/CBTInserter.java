package com.learn.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import com.learn.utils.TreeNode;

public class CBTInserter {
  private TreeNode root;
  
  public CBTInserter(TreeNode root) {
    this.root = root;
  }
  
  public int insert(int val) {
    if(Objects.isNull(root)){
      root = new TreeNode(val);
      return -1;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while(!nodes.isEmpty()){
      TreeNode node = nodes.poll();
      if(Objects.isNull(node.left)){
        node.left = new TreeNode(val);
        return node.val;
      }else{
        nodes.offer(node.left);
      }
      if(Objects.isNull(node.right)){
        node.right = new TreeNode(val);
        return node.val;
      }else{
        nodes.offer(node.right);
      }
    }
    return -1;
  }
  
  public TreeNode get_root() {
    return root;
  }

}
