package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

public class ReorderList {
	
	public void reorderList(ListNode head) {

		if(Objects.isNull(head)) return;
		int count = 1;
		ListNode move = head;
		Node back = new Node(head, null);
		while(Objects.nonNull(move.next)){
			back = new Node(move.next, back);
			move = move.next;
			count++;
		}

		ListNode next = null, backNode;
		for(int i=0; i<count/2; i++) {
			next = head.next;
			backNode = back.val;
			head.next = backNode;
			backNode.next = next;
			if(i + 1 == count/2){
				if(count % 2 == 0){
					backNode.next = null;
				}else {
					next.next = null;
				}
			}
			head = next;
			back = back.prev;
		}

	}
	
	public class Node {
		Node prev;
		ListNode val;

		public Node(ListNode v, Node p) {
			prev = p;
			val = v;
		}

	}

	public class ListNode {
			int val;
			ListNode next;
			ListNode() {}
			ListNode(int val) { this.val = val; }
			ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		}
}
