package com.learn.algorithms.leetcode.medium;

/* 
给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。

每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。

返回赢得比赛的整数。

题目数据 保证 游戏存在赢家。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-the-winner-of-an-array-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
public class GetWinner {
  
  public int getWinner(int[] arr, int k) {
    int count = 1;
    int walk = 2;
    int max = Math.max(arr[0], arr[1]);
    while(count < k && walk < arr.length){
      count = max > arr[walk] ? count + 1 : 1;
      max = Math.max(max, arr[walk]);
      walk = walk + 1;
    }
    return max;
  }

}
