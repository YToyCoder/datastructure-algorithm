package com.learn.algorithms.leetcode.easy;

import com.learn.utils.ListNode;

public class DeleteNode {
  
  public void deleteNode(ListNode node) {
    ListNode todelete = node.next;
    node.val = todelete.val;
    node.next = todelete.next;
    todelete.next = null;
  }
}
