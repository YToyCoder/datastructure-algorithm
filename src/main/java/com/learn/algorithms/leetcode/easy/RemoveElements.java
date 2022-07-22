package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

import com.learn.utils.ListNode;

public class RemoveElements {
  
  public ListNode removeElements(ListNode head, int val) {
    ListNode holder = new ListNode();
    ListNode walk = holder;
    while(Objects.nonNull(head)){
      if(head.val != val) {
        walk.next = head;
        head = head.next;
        walk = walk.next;
        walk.next = null;
      }else head = head.next;
    }
    return holder.next;
  }
}
