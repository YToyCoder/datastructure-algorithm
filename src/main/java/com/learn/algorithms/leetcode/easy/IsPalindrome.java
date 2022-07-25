package com.learn.algorithms.leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.learn.utils.ListNode;

/*

给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

2 2 2 2
1 0 1

java.lang.NullPointerException: Cannot read field "val" because "<local3>" is null
  at line 30, Solution.isPalindrome
  at line 54, __DriverSolution__.__helper__
  at line 84, __Driver__.main

 */

public class IsPalindrome {
  
  public boolean isPalindrome(ListNode head) {
    if(Objects.isNull(head) || Objects.isNull(head.next) ) return true;
    ListNode fast = head, slow = head;
    int count = 0;
    List<ListNode> preNode = new LinkedList<>();
    // fast.next
    while(Objects.nonNull(fast) && Objects.nonNull(fast.next)){
      preNode.add(slow);
      slow = slow.next;
      fast = fast.next;
      count++;
      if(Objects.nonNull(fast) && Objects.nonNull(fast.next)){
        count++;
        fast = fast.next;
      } 
    }
    if(count % 2 == 0) slow = slow.next;
    for(int i=0; i < count/2; i++){
      if(preNode.get(preNode.size() - 1 - i).val != slow.val) return false;
      slow = slow.next;
    }
    return true;
  }

}
