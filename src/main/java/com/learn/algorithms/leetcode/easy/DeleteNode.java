package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

import com.learn.utils.ListNode;

public class DeleteNode {
  
  public void deleteNode(ListNode node) {
    ListNode todelete = node.next;
    node.val = todelete.val;
    node.next = todelete.next;
    todelete.next = null;
  }


  public ListNode deleteNode(ListNode head, int val) {
    while(Objects.nonNull(head) && head.val == val) 
      head = head.next;
    ListNode ans = head;
    while(Objects.nonNull(head) && Objects.nonNull(head.next)){
      if(head.next.val == val){
        head.next = head.next.next;
      }
      head = head.next;
    }
    return ans;
  }
}
