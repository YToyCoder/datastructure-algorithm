package com.learn.algorithms.leetcode.hard;

public class UniquePaths {

	/**
	 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
	 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
	 * 问总共有多少条不同的路径？
	 * 输入：m = 3, n = 7 输出：28
	 */

	public int uniquePaths(int m, int n) {
		int[][] pd= new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(i==0 && j==0) pd[i][j] = 1;
				else if(i == 0) pd[i][j] = 0 + pd[i][j - 1];
				else if(j == 0) pd[i][j] = 0 + pd[i - 1][j];
				else pd[i][j] = pd[i][j - 1] + pd[i - 1][j];
			}
		}
		return pd[m - 1][n - 1];
	}
}
