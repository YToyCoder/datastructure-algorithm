package com.learn.algorithms.leetcode.book;

public class CountingSort {
	public static int[] countingSort(int[] A) {
		int[] res = new int[A.length];
		// 假设A中的数据a'有，0<=a' && a' < k并且k=100
		int k = 100;
		countingSort(A, res, k);
		return res;
}

private static void countingSort(int[] source, int[] target, int k) {
		int[] count = new int[k];
		// 计数
		for (int j = 0; j < source.length; j++) {
				int a = source[j];
				count[a] += 1;
		}
		// 求计数和
		for (int i = 1; i < k; i++) {
				count[i] = count[i] + count[i - 1];
		}
		// 整理
		for (int j = source.length - 1; j >= 0; j--) {
				int a = source[j];
				target[count[a] - 1] = a;
				count[a] -= 1;
		}
}
}
