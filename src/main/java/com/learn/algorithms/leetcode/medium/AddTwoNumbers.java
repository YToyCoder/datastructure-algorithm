package com.learn.algorithms.leetcode.medium;

public class AddTwoNumbers {

	/** Description:
	 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
	 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	 *
	 * Result:
	 * Runtime: 2 ms, faster than 70.60% of Java online submissions for Add Two Numbers.
	 * Memory Usage: 39.6 MB, less than 43.08% of Java online submissions for Add Two Numbers.
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null)
				return l1 == null ? l2 : l1;
		int carryOver = 0;// 进位
		int curV = 0;
		ListNode curL1Node = l1;
		ListNode curL2Node = l2;
		for(; curL1Node != null || curL2Node != null ;){
				curV = (curL1Node == null ? 0 : curL1Node.val) +  (curL2Node == null ? 0 : curL2Node.val) + carryOver;
				int reservedV = curV  - 9 > 0 ? curV%10 : curV;
				carryOver = (curV - reservedV)/10;
				if(curL1Node == null){
						curL2Node.val = reservedV;
						if(curL2Node.next == null){
								if(carryOver > 0)
										curL2Node.next = new ListNode(carryOver,null);
								return l2;
						}
						else
								curL2Node = curL2Node.next;
				}else{
						if(curL2Node == null){
								curL1Node.val = reservedV;
								if(curL1Node.next == null){
										if(carryOver > 0)
												curL1Node.next = new ListNode(carryOver,null);
										return l1;
								}
								else
										curL1Node = curL1Node.next;
						}else{
								curL2Node.val = curL1Node.val = reservedV;
								if(curL2Node.next == null && curL1Node.next == null){
										if(carryOver > 0)
												curL1Node.next = new ListNode(carryOver, null);
										return l1;
								}
								curL1Node = curL1Node.next;
								curL2Node = curL2Node.next;
						}
				}
		}
		return l1;
	}

	/**
	 *Result :
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
	 * Memory Usage: 39.6 MB, less than 48.44% of Java online submissions for Add Two Numbers.
	 */
	public static ListNode func2(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null)
				return l1 ==  null ? l2 : l1;
		int carryOver = 0;
		int curV;
		ListNode l1Node = l1;
		ListNode l2Node = l2;
		while (l1Node != null || l2Node != null) {
				curV =  (l1Node == null ? 0 : l1Node.val) +  (l2Node == null ? 0 : l2Node.val) + carryOver;
				int reservedV = curV%10;
				carryOver = (curV - reservedV)/10;
				// 赋值
				if(l1Node != null)l1Node.val = reservedV;
				if(l2Node != null)l2Node.val = reservedV;
				// 判断是否该跳出或进入下一节点
				if((l1Node == null || l1Node.next == null)  && (l2Node == null || l2Node.next == null) ){
						if(carryOver > 0)
								if(l1Node == null) l2Node.next = new ListNode(carryOver,null);
								else l1Node.next = new ListNode(carryOver,null);
						return l1Node == null ? l2 : l1;
				}
				l1Node = l1Node == null ? null : l1Node.next;
				l2Node = l2Node == null ? null : l2Node.next;
		}
		return l1;
	}

	static class ListNode {
			int val;
			ListNode next;
			ListNode() {}
			ListNode(int val) { this.val = val;}
			ListNode(int val, ListNode next) {
					this.val = val;
					this.next = next;
			}
	}
}
