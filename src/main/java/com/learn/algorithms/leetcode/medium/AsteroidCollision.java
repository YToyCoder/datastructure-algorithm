package com.learn.algorithms.leetcode.medium;

import java.util.Stack;

/**
对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/asteroid-collision
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AsteroidCollision {
  
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for(int el : asteroids){
      if(!stack.isEmpty()){
        boolean currentExists = true;
        int pre = stack.peek();
        while(
          /**
           * 当前存在 & 前向不为空 & 会相撞
           */
          currentExists && 
          !stack.isEmpty() &&
          willCrash(pre, el)
        ) {
          int absPre = Math.abs(pre);
          int absEl  = Math.abs(el);
          if(absEl == absPre) {
            currentExists = false;
            stack.pop();
            if(!stack.isEmpty())
              pre = stack.peek();
          }else if(absPre < absEl){
            stack.pop();
            if(!stack.isEmpty())
              pre = stack.peek();
          }else currentExists = false;
        }
        if(currentExists) stack.add(el);
      }else stack.add(el);
    }
    final int[] ans = new int[stack.size()];
    for(int i=ans.length - 1; i >= 0; i--){
      ans[i] = stack.pop();
    }
    return ans;
  }

  private boolean willCrash(int left, int right){
    return left > 0 && right < 0;
  }
}
