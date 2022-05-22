package com.learn.algorithms.leetcode.medium;

// 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
// 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
// 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
// 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家是否能稳赢则返回 true ，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
// 来源：力扣（LeetCode）
// 链接：https://leetcode.cn/problems/can-i-win
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class CanIWin {
  private int n;
  private int total;
  private int[] store;
  
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if(maxChoosableInteger * (maxChoosableInteger + 1)/2 < desiredTotal) return false;
    if(desiredTotal == 0) return true;
    n = maxChoosableInteger; total = desiredTotal; store = new int[1 << 20];
    return dfs(0, 0) == 1;
  }
  
  private int dfs(int state, int sum){
    if(store[state] != 0) return store[state];
    for(int i=0; i < n; i++){
      if((state >> i & 1 ) != 1){
        if(sum + i + 1>= total) return store[state] = 1; 
        if(dfs(state | (1 << i), sum + i + 1) == -1) return store[state] = 1;
      }
    }
    return store[state] = -1;
  }
}
