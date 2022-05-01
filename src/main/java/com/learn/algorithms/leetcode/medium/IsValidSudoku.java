package com.learn.algorithms.leetcode.medium;

public class IsValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		byte[][] row = new byte[9][10];
		byte[][] col = new byte[9][10];
		byte[][] box = new byte[9][10];
		for(int r = 0; r < 9; r ++) {
			for(int c = 0; c < 9; c++) {
				if(Character.isDigit(board[r][c])){
				int now = Character.getNumericValue(board[r][c]);
				int boxIndex = c/3 + (r / 3) * 3;
				if(row[r][now] == 1 || col[c][now] == 1 || box[boxIndex][now] == 1) 
					return false;
				row[r][now] = 1;
				col[c][now] = 1;
				box[boxIndex][now] = 1;
				}
			}
		}
		return true;
	}
}
