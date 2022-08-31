package com.learn.algorithms.huawei;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import com.learn.ds.table.Entry;
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

  // 503. 下一个更大元素 II
  // 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
  // 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/next-greater-element-ii
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public int[] nextGreaterElements(int[] nums) {
    final int len = nums.length;
    Stack<Integer> stack = new Stack<>();
    int[] ans = new int[nums.length];
    for(int i=len * 2 - 1; i>=0; i--){
      int rl = i % len;
      if(
        !stack.isEmpty() &&
        nums[rl] >= nums[stack.peek()]
      ){
        while(!stack.isEmpty() && nums[rl] >= nums[stack.peek()])
          stack.pop();
        ans[rl] = stack.isEmpty() ? -1 : nums[stack.peek()]; 
      }else ans[rl] = nums[(rl + 1) % len];
      stack.add(rl);
    }
    return ans;
  }


  // * 并查集
  // 547. 省份数量  
  // 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
  // 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
  // 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
  // 返回矩阵中 省份 的数量。
  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/number-of-provinces
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public int findCircleNum(int[][] isConnected) {
    int[] set = new int[isConnected.length];
    // init
    for(int i=0; i<set.length; i++){
      set[i] = i;
    }
    for(int i=0; i < isConnected.length; i++){
      for(int j=0; j<isConnected[i].length; j++){
        if(isConnected[i][j] == 1)
          union(set, i, j);
      }
    }
    int provinces = 0;
    for(int i=0; i<set.length; i++){
      if(set[i] == i)provinces++;
    }
    return provinces;
  }

  private void union(int[] set, int i, int j){
    set[find(set, i)] = find(set, j);
  }

  private int find(int[] set, int index){
    return set[index] == index ? index : find(set, set[index]);
  }

  // * 滑动窗口
  // 209. 长度最小的子数组
  // 给定一个含有 n 个正整数的数组和一个正整数 target 。
  // 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public int minSubArrayLen(int target, int[] nums) {
    int sub_sum = 0;
    int left = -1;
    int min_len = Integer.MAX_VALUE;
    boolean flag = false;
    for(int i=0;i<nums.length; i++){
      sub_sum += nums[i];
      while(sub_sum - nums[left + 1] >= target){
        left++;
        sub_sum -= nums[left];
      }
      if(sub_sum >= target && i - left < min_len){
        min_len = i - left;
        flag = true;
      }
    }
    return flag ? min_len : 0;
  }

  // * 滑动窗口
  //  3. 无重复字符的最长子串
  //  给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
  public int lengthOfLongestSubstring(String s) {
    Set<Character> sub_chars = new HashSet<>();
    int left = 0, right = 0;
    final int len = s.length();
    int max_len_ever = 0;
    while(left < len && right < len){
      final char current = s.charAt(right);
      while(left < right && sub_chars.contains(current))
        sub_chars.remove(s.charAt(left++));
      sub_chars.add(current);
      right++;
      max_len_ever = Math.max(sub_chars.size(), max_len_ever);
    }
    return max_len_ever;
  }

  // 1004. 最大连续1的个数 III
  // 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数。
  public int longestOnes(int[] nums, int k) {
    int left = 0;
    int k_count = 0;
    int longest = 0;
    for(int i=0; i < nums.length; i++){
      if(nums[i] == 0) k_count++;
      while(nums[i] == 0 && k_count > k)
        if(nums[left++] == 0)
          k_count--;
      longest = Math.max(longest, i - left + 1);
    }
    return longest;
  }

  // * 滑动窗口
  // 1208. 尽可能使字符串相等
  // 给你两个长度相同的字符串，s 和 t。
  // 将 s中的第i个字符变到t中的第 i 个字符需要s[i] - t[i]|的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
  // 用于变更字符串的最大预算是maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
  // 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
  // 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/get-equal-substrings-within-budget
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public int equalSubstring(String s, String t, int maxCost) {
    int left = 0;
    final int len = s.length();
    int remain = maxCost;
    int max_len = 0;
    for(int i=0; i<len; i++){
      remain -= Math.abs(s.charAt(i) - t.charAt(i));
      while( remain < 0 ){
        remain += Math.abs(s.charAt(left) - t.charAt(left));
        left++;
      }
      max_len = Math.max(max_len, i - left + 1);
    }
    return max_len;
  }

  // * 前缀和
  // 724. 寻找数组的中心下标
  //  给你一个整数数组nums ，请计算数组的 中心下标 。
  //  数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
  //  如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
  //  如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
  //  来源：力扣（LeetCode）
  //  链接：https://leetcode.cn/problems/find-pivot-index
  //  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public int pivotIndex(int[] nums) {
    final int len = nums.length;
    int sum = IntStream.range(0, len).reduce(0, (pre, i) -> nums[i] + pre);
    int sub_sum = 0;
    for(int i=0; i<len; i++){
      if(sum - nums[i] == sub_sum * 2 )
        return i;
      sub_sum += nums[i];
    }
    return -1;
  }


  // 560. 和为 K 的子数组
  // 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
  public int subarraySum(int[] nums, int k) {
    int count = 0;
    Map<Integer, IntHolder> pre_sum_freq = new HashMap<>();
    pre_sum_freq.put(0, new IntHolder(1));
    int sum = 0;
    for(int el : nums){
      sum += el;
      IntHolder may_exists_prefix;
      if(Objects.nonNull( may_exists_prefix = pre_sum_freq.get(sum - k)))
        count += may_exists_prefix.val;
      pre_sum_freq.computeIfAbsent(sum, key -> new IntHolder(0)).val++;
    }
    return count;
  }

  static class IntHolder {
    int val;
    public IntHolder(int _val){
      val = _val;
    }
  }

  // 1094. 拼车
  // 车上最初有capacity个空座位。车只能向一个方向行驶（也就是说，不允许掉头或改变方向）
  // 给定整数capacity和一个数组 trips , trip[i] = [numPassengersi, fromi, toi]表示第 i 次旅行有numPassengersi乘客，接他们和放他们的位置分别是fromi和toi。这些位置是从汽车的初始位置向东的公里数。
  // 当且仅当你可以在所有给定的行程中接送所有乘客时，返回true，否则请返回 false。
  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/car-pooling
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public boolean carPooling(int[][] trips, int capacity) {
    TreeMap<Integer, IntHolder> walk = new TreeMap<>();
    for(int[] el : trips){
      walk.computeIfAbsent(el[1], key -> new IntHolder(0)).val += el[0];
      walk.computeIfAbsent(el[2], key -> new IntHolder(0)).val -= el[0];
    }
    int sum = 0;
    for(Map.Entry<Integer, IntHolder> stop : walk.entrySet()){
      sum += stop.getValue().val;
      if(sum > capacity) return false;
    }
    return true;
  }


  // * 差分法
  // 121. 买卖股票的最佳时机
  //  给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
  //  你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
  //  返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
  //  来源：力扣（LeetCode）
  //  链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
  //  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public int maxProfit(int[] prices) {
    int[] diff = new int[prices.length];
    diff[0] = 0;
    for(int i=1; i<prices.length; i++){
      diff[i] = prices[i] - prices[i - 1];
    }
    PriorityQueue<Integer> pre_sum = new PriorityQueue<>();
    int sum = 0;
    int max = 0;
    for(int el : diff){
      sum += el;
      if(!pre_sum.isEmpty() && sum - pre_sum.peek() > max)
        max = sum - pre_sum.peek();
      pre_sum.add(sum);
    }
    return max;
  }
}
