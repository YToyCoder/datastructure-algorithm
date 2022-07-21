package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

import com.learn.utils.ListNode;

public class SortList {
  
  public ListNode sortList(ListNode head) {
    return mergeSort(head, null);
  }

  ListNode mergeSort(ListNode head, ListNode tail){
    if(Objects.isNull(head)) return head;
    if(Objects.equals(head.next, tail)){
      head.next = null;
      return head;
    }

    ListNode fast = head, slow = head;
    while(!Objects.equals(fast, tail)){
      slow = slow.next;
      fast = fast.next;
      if(!Objects.equals(fast, tail))
        fast = fast.next;
    }

    ListNode left = mergeSort(head, slow);
    ListNode right = mergeSort(slow, tail);
    // do sort --- insert
    ListNode temp = new ListNode();
    ListNode walk = temp;
    while(Objects.nonNull(left) && Objects.nonNull(right)){
      if(left.val < right.val){
        walk.next = left;
        left = left.next;
      }else{
        walk.next = right;
        right = right.next;
      }
      walk = walk.next;
    }
    if(Objects.nonNull(left)) walk.next = left;
    if(Objects.nonNull(right)) walk.next = right;
    return temp.next;
  }

}
