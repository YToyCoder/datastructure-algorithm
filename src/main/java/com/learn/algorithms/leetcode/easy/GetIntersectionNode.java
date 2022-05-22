package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

// 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
// 图示两个链表在节点 c1 开始相交：
// 题目数据 保证 整个链式结构中不存在环。

// 注意，函数返回结果后，链表必须 保持其原始结构 。
// 来源：力扣（LeetCode）
// 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class GetIntersectionNode {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA;
		ListNode b = headB;

		while(Objects.nonNull(headA) || Objects.nonNull(headB)){
			if(Objects.isNull(headA)){
				headA = b;
				headB = headB.next;
			}else if(Objects.isNull(headB)){
				headB = a;
				headA = headA.next;
			}else{
				if(Objects.equals(headA, headB)) break;
				headA = headA.next;
				headB = headB.next;
			}
		}
    return headA != null ? headA : null;
	}
	
	public class ListNode {
			int val;
			ListNode next;
			ListNode(int x) {
					val = x;
					next = null;
			}
		}
}
