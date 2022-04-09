package com.learn.algorithms.leetcode.easy;

import java.util.Objects;

public class MergeTwoLists {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public static ListNode resolve(ListNode list1, ListNode list2) {
	if (isEmpty(list1)) return list2;
	if (isEmpty(list2)) return list1;
	ListNode res;
	if (list1.val > list2.val) {
		res = list2;
		list2 = list2.next;
	} else {
		res = list1;
		list1 = list1.next;
	}
	ListNode iter = res;
	while (Objects.nonNull(list1) || Objects.nonNull(list2)) {
		if (Objects.isNull(list1)) {
			iter.next = list2;
			list2 = list2.next;
		} else if (Objects.isNull(list2)) {
			iter.next = list1;
			list1 = list1.next;
		} else {
			if (list1.val > list2.val) {
				iter.next = list2;
				list2 = list2.next;
			} else {
				iter.next = list1;
				list1 = list1.next;
			}
		}
		iter = iter.next;
	}
	return res;
}

	public static boolean isEmpty(ListNode list){
		return Objects.isNull(list);
	}
}
