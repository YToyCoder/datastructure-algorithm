package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Insert {

	/**
	 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
	 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
	 */
	public int[][] insert(int[][] intervals, int[] newInterval) {
		if(intervals.length == 0) return new int[][]{newInterval};
		else if(newInterval.length == 0) return intervals;
		int len = intervals.length;
		int[] interval;
		List<int[]> store = new ArrayList<>(len);
		for (int i = 0; i < len; i++) {
			interval = intervals[i];
			if ((newInterval[1] < interval[0] && (i == 0 || intervals[i - 1][1] < newInterval[0]))
					|| (newInterval[0] > interval[1] && i + 1 == len)) {
				if (newInterval[0] > interval[1]) {
					store.add(interval);
					store.add(newInterval);
				} else {
					store.add(newInterval);
					store.add(interval);
				}
			} else if (newInterval[1] < interval[0] || newInterval[0] > interval[1]) {
				store.add(interval);
			} else {
				if (newInterval[0] > interval[0])
					newInterval[0] = interval[0];
				if (newInterval[1] <= interval[1]) {
					store.add(new int[] { newInterval[0], interval[1] });
				} else if (i + 1 == len || newInterval[1] < intervals[i + 1][0]) {
					store.add(newInterval);
				}
			}
		}
		int[][] res = new int[store.size()][2];
		for (int i = 0; i < store.size(); i++) {
			res[i] = store.get(i);
		}
		return res;
	}
}
