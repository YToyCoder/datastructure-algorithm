package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

import com.learn.utils.ListNode;

public class ReverseList {

  public ListNode reverseList(ListNode head) {
    ListNode walk = head;
    ListNode temp = new ListNode();
    while(Objects.nonNull(walk)){
      ListNode next = temp.next;
      temp.next = walk;
      walk = walk.next;
      temp.next.next = next;
    }
    return temp.next;
  }
}
