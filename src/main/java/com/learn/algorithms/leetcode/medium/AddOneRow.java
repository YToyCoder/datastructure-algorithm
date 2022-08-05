package com.learn.algorithms.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

import com.learn.utils.TreeNode;

public class AddOneRow {
  
  public TreeNode addOneRow(TreeNode root, int val, int depth) {
    int depthCount = 0;
    Deque<TreeNode> levelQueue = new LinkedList<>();
    levelQueue.add(root);
    TreeNode[] nodes2keep = null;
    // find nodes
    while(!levelQueue.isEmpty() && depthCount + 1  != depth){
      depthCount++;
      int size2rm = levelQueue.size();
      nodes2keep = new TreeNode[size2rm];
      while(size2rm > 0){
        nodes2keep[size2rm - 1] = levelQueue.poll();
        if(Objects.nonNull(nodes2keep[size2rm - 1].left))
          levelQueue.add(nodes2keep[size2rm - 1].left);
        if(Objects.nonNull(nodes2keep[size2rm - 1].right))
          levelQueue.add(nodes2keep[size2rm - 1].right);
        size2rm--;
      }
    }

    // depth is 1
    if(Objects.isNull(nodes2keep)){
      return new TreeNode(val, root, null);
    }else if(levelQueue.isEmpty()){
      // no child
      for(TreeNode sameLevelNode : nodes2keep){
        sameLevelNode.left  = new TreeNode(val);
        sameLevelNode.right = new TreeNode(val);
      }
    }else{
      for(TreeNode sameLevelNode : nodes2keep){
        TreeNode asLeft  = new TreeNode(val);
        TreeNode asRight = new TreeNode(val);
        if(Objects.nonNull(sameLevelNode.left)){
          asLeft.left = sameLevelNode.left;
        }
        if(Objects.nonNull(sameLevelNode.right)){
          asRight.right = sameLevelNode.right;
        }
        sameLevelNode.left = asLeft;
        sameLevelNode.right =asRight;
      }
    }
    // 
    return root;
  }
}
