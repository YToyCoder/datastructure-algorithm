package com.learn.algorithms.leetcode.easy;


/*

给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。

让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组：

arr.length >= 3
在 0 < i < arr.length - 1 条件下，存在 i 使得：
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/valid-mountain-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class ValidMountainArray {
  
  public boolean validMountainArray(int[] arr) {
    if(arr.length < 3) return false;
    boolean increase = true;
    for(int i=1; i<arr.length; i++){
      if(
        arr[i] == arr[i - 1] || 
        (!increase && arr[i] > arr[i - 1]) || 
        (i == 1 && arr[i] < arr[i - 1])
      ) return false;
      if(increase && arr[i] < arr[i - 1]) increase = false;
    }
    return !increase;
  }
}
