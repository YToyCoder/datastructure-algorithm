package com.learn.algorithms.leetcode.medium;

public class SetZeroes {
  
  public void setZeroes(int[][] matrix) {
    int[] rows = new int[matrix.length];
    int[] cols = new int[matrix[0].length];
    for(int row=0; row<matrix.length; row++){
      for(int col=0; col<matrix[row].length; col++){
        if(matrix[row][col] == 0){
          rows[row]++;
          cols[col]++;
        }
      }
    }

    for(int row=0; row<matrix.length; row++){
      for(int col=0; col<matrix[row].length; col++){
        if(rows[row] > 0 || cols[col] > 0){
          matrix[row][col] = 0;
        }
      }
    }

  }

}
