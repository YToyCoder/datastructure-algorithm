package com.learn.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class ShiftGrid {
  
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    k = k % (grid.length * grid[0].length) ;
    int downMov = k ;
    int rightMov = k ;

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    for (int i = 0; i < grid.length; i++) {
        List<Integer> row = new ArrayList<Integer>();
        for (int j = 0; j < grid[i].length; j++) {
            row.add(0);
        }
        ans.add(row);
    }

    for(int i=0; i < grid.length; i++){
      for(int j=0; j < grid[i].length; j++){
        int rowLoc = (j + rightMov) % grid[i].length; // 2 + 1 % 3 == 0
        downMov = (j + k) / grid[i].length;
        int colLoc = (i + downMov) % grid.length; // 

        ans.get(colLoc).set(rowLoc, grid[i][j]);
      }
    }
    return ans;
  }

}
