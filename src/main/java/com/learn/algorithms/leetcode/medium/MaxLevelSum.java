package com.learn.algorithms.leetcode.medium;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import com.learn.utils.TreeNode;

public class MaxLevelSum {
  
  public int maxLevelSum(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    int level = 1;
    int sum = 0;
    int size = 1;
    int maxLevel = 0;
    int max = Integer.MIN_VALUE;
    queue.offer(root);
    TreeNode mvNode;
    while(!queue.isEmpty()){
      mvNode = queue.poll();
      sum += mvNode.val;
      if(Objects.nonNull(mvNode.left)) queue.offer(mvNode.left);
      if(Objects.nonNull(mvNode.right)) queue.offer(mvNode.right);
      if(size == 1){
        size = queue.size();
        if(max < sum){
          maxLevel = level;
          max = sum;
        } 
        level++;
        sum = 0;
      }else{
        size--;
      }
    }
    return maxLevel;
  }
}
