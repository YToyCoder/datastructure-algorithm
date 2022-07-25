package com.learn.algorithms.leetcode.medium;


/*
  
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/search-a-2d-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/

public class SearchMatrix {
 
  public boolean searchMatrix(int[][] matrix, int target) {
    return binarySearch(0, matrix.length - 1, matrix, target) ;
  } 

  boolean binarySearch(int rowStart, int rowEnd, int[][] matrix, int target){
    if(
      target < matrix[rowStart][0] || 
      target > matrix[rowEnd][matrix[0].length - 1]
    ) return false;
    if(rowStart == rowEnd){
      for(int el : matrix[rowStart]){
        if(el == target) return true;
      }
    }else{
      int mid = (rowStart + rowEnd) >> 1;
      // 1 + 2 | 11 >> 1 ?? 1
      int midV = matrix[mid][matrix[0].length - 1];
      return midV == target ? true : midV > target ? 
              binarySearch(rowStart, mid , matrix, target) :
              binarySearch(mid + 1, rowEnd, matrix, target);
    }
    return false;
  }
}
