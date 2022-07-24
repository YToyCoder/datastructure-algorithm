package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

import com.learn.utils.ListNode;

public class Partition {
  
  public ListNode partition(ListNode head, int x) {
    ListNode lt = new ListNode();
    ListNode ge = new ListNode();
    ListNode ltWalk = lt, geWalk = ge;
    ListNode temp;
    while(Objects.nonNull(head)){
      if(head.val < x){
        ltWalk.next = head;
        ltWalk = ltWalk.next;
      }else{
        geWalk.next = head;
        geWalk = geWalk.next;
      }
      temp = head;
      head = head.next;
      temp.next = null;
    }
    if(!Objects.equals(geWalk, ge)){
      ltWalk.next = ge.next;
    }
    return lt.next;
  }

}
