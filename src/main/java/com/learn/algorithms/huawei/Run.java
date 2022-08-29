package com.learn.algorithms.huawei;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Stack;

import com.learn.utils.ListNode;
import com.learn.utils.TreeNode;

public class Run {
  
  
  // leetcode 70
  // 爬楼梯
  // 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
  // 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
  public int climbStairs(int n) {
    if(n <= 2) 
      return n;
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    for(int i=2; i < n; i++){
      dp[i] += (dp[i - 1] + dp[i - 2]);
    }
    return dp[n - 1];
  }

  // leetcode 112
  // 路径总和
  // 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
  // 叶子节点 是指没有子节点的节点。
  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/path-sum
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if(Objects.isNull(root)) 
      return false;
    int maybe_zero = targetSum - root.val;
    return 
    (maybe_zero == 0 && Objects.isNull(root.left) && Objects.isNull(root.right)) || 
    hasPathSum(root.left, maybe_zero) || 
    hasPathSum(root.right, maybe_zero) ;
  }


  // leetcode 509 
  // short code version
  public int fib(int n) {
    return switch (n) {
      case 0 -> 0;
      case 1 -> 1;
      default -> fib(n - 1) + fib(n - 2);
    };
  }


  // leetcode 23
  // 合并K个升序链表
  // 给你一个链表数组，每个链表都已经按升序排列。
  // 请你将所有链表合并到一个升序链表中，返回合并后的链表。
  public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length == 0) return null;
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a , b) -> a.val - b.val);
    for(ListNode el : lists)
      if(Objects.nonNull(el))
        priorityQueue.add(el);
    if(priorityQueue.isEmpty()) return null;
    ListNode node = priorityQueue.poll();
    ListNode walk = node;
    if(Objects.nonNull(node.next))
      priorityQueue.add(node.next);
    while(!priorityQueue.isEmpty()){
      walk.next = priorityQueue.peek();
      if(Objects.nonNull(priorityQueue.poll().next))
        priorityQueue.add(walk.next.next);
      walk = walk.next;
    }
    return node;
  }

  // 169
  // 多数元素
  // 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
  // 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/majority-element
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }


  // 739 * 单调栈
  // 每日温度
  // 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/daily-temperatures
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int[] ans = new int[temperatures.length];
    for(int i=temperatures.length ; i > 0; i--){
      if(stack.isEmpty() || 
        temperatures[i - 1] >= temperatures[ stack.peek() - 1]
      ){
        while(
          !stack.isEmpty() && temperatures[i - 1] >= temperatures[stack.peek() - 1]
        ) stack.pop();
        ans[i - 1] = stack.isEmpty() ? 0 : stack.peek() - i;
        stack.add(i);
      }else {
        ans[i - 1] = 1;
        stack.add(i);
      }
    }
    return ans;
  }

}
