package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import com.learn.utils.TreeNode;

public class Medium {

  public String solveEquation(String equation) {
    final String[] exps = equation.split("=");
    Map<Boolean, Integer> left = resolveExpr(exps[0]);
    Map<Boolean, Integer> right = resolveExpr(exps[1]);
    int x = left.get(Boolean.TRUE) - right.get(Boolean.TRUE);
    int digit = right.get(Boolean.FALSE) - left.get(Boolean.FALSE);
    return x == 0 ? digit != 0 ? "No solution" : "Infinite solutions" : digit == 0 ? "x=0" : String.format("x=%d", digit/x);
  }

  // true x
  // false digit
  Map<Boolean, Integer> resolveExpr(String expr){
    int x = 0;
    int digit = 0;
    int left = 0;
    int signal = 1;
    for(int i=0; i<expr.length(); i++){
      if(
          i == expr.length() - 1 ||
          Objects.equals( expr.charAt(i), '+') ||
          Objects.equals( expr.charAt(i), '-')
      ){
        final String val = expr.substring(left, i == expr.length() - 1 ? expr.length() : i).trim();
        if(val.length() > 0){
          if(Objects.equals(val.charAt(val.length() - 1), 'x')){
            // x
            x += signal * (val.length() == 1 ? 1 : Integer.valueOf(val.substring(0, val.length() - 1)));
          }else{
            digit += signal * Integer.valueOf(val);
          }
        }
        signal = Objects.equals(expr.charAt(i), '+') ? 1 : -1;
        left = i + 1;
      }
    }
    return Map.of(
        Boolean.TRUE, x,
        Boolean.FALSE, digit
    );
  }


  public int[] corpFlightBookings(int[][] bookings, int n) {
    // difference 差分
    final int[] ans = new int[n];
    for(int[] booking : bookings){
      ans[booking[0] - 1] += booking[2];
      if(booking[1] < n){
        ans[booking[1]] -= booking[2];
      }
    }
    for(int i=1; i<n; i++){
      ans[i] += ans[i - 1];
    }
    return ans;
  }


  // todo 
  public String pushDominoes(String dominoes) {
    final char[] chars = dominoes.toCharArray();
    int closest_r = -1;
    for(int i=0; i< dominoes.length(); i++){
      if(Objects.equals(dominoes.charAt(i), 'L')){
        // len  % 2 == 1 , mid = .
        // 
        // R 1 2 3 4 L
        // 0 1       5
        int lag = i - closest_r + 1;
      }else if(Objects.equals(chars[i], 'R')){
        closest_r = i;
      }else if(closest_r != -1){
        chars[i] = 'R';
      }
    }
    return "";
  }

  //   有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。

  // 给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。

  // 返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。

  // 每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。

  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    Map<Integer, PriorityQueue<List<Integer>>> mapper = new TreeMap<>();
    for(int id=0; id<groupSizes.length; id++){
      PriorityQueue<List<Integer>> list_queue = mapper.computeIfAbsent(groupSizes[id], key -> new PriorityQueue<>((a, b) -> a.size() - b.size()));
      if(list_queue.isEmpty() || list_queue.peek().size() == groupSizes[id])
        list_queue.offer(new LinkedList<>(List.of(id)));
      else {
        LinkedList<Integer> old = (LinkedList<Integer>) list_queue.poll();
        old.add(id);
        list_queue.offer(old);
      }
    }
    return mapper.values().stream().flatMap(el -> el.stream()).toList();
  }

  // 设计实现双端队列。

  // 实现 MyCircularDeque 类:

  // MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
  // boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
  // boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
  // boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
  // boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
  // int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
  // int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
  // boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
  // boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。

  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/design-circular-deque
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  static class MyCircularDeque {
    private final int[] arr;
    private int head_pointer;
    private int tail_pointer;

    public MyCircularDeque(int k) {
      arr = new int[k];
      reset();
    }


    private int next_tail(){
      return (tail_pointer + 1) % arr.length;
    }

    private int next_head() {
      return (head_pointer - 1 + arr.length) % arr.length;
    }

    // do - 1
    private int move_forward(int i){
      return (i - 1 + arr.length) % arr.length;
    }

    private int move_back(int i){
      return (i + 1) % arr.length;
    }

    private void reset(){
      head_pointer = tail_pointer = -1;
    }
    
    public boolean insertFront(int value) {
      if(isFull()) return false;
      if(isEmpty()) arr[head_pointer = tail_pointer = next_head()] = value;
      else
        arr[head_pointer = next_head()] = value;
      return true;
    }
    
    public boolean insertLast(int value) {
      if(isFull()) return false;
      if(isEmpty()) arr[head_pointer = tail_pointer = next_tail()] = value;
      else arr[tail_pointer = next_tail()] = value;
      return true;
    }
    
    public boolean deleteFront() {
      if(isEmpty()) return false;
      if(head_pointer == tail_pointer)
        reset();
      else head_pointer = move_back(head_pointer);
      return true;
    }
    
    public boolean deleteLast() {
      if(isEmpty()) return false;
      if(tail_pointer == head_pointer)
        reset();
      else tail_pointer = move_forward(tail_pointer);
      return true;
    }
    
    public int getFront() {
      return isEmpty() ? -1 : arr[head_pointer];
    }
    
    public int getRear() {
      return isEmpty() ? -1 : arr[tail_pointer];
    }
    
    public boolean isEmpty() {
      return head_pointer == -1;
    }
    
    public boolean isFull() {
      return next_tail() == head_pointer;
    }
  }

//
//  给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
//       
//
//  示例 1：
//
//  输入：nums = [10,5,2,6], k = 100
//  输出：8
//  解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//  需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
//  示例 2：
//
//  输入：nums = [1,2,3], k = 0
//  输出：0
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode.cn/problems/subarray-product-less-than-k
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int multi = 1;
    int[] left_position = new int[nums.length];
    int left = find_smaller_el(nums, left_position, 0, k);
    for(int i=left; i<nums.length; i++){
      if(nums[i] * multi < k){
        left_position[i] = left;
        multi *= nums[i];
      }else { // >= k
        multi *= nums[i] ;
        while(left < i && multi >= k){
          multi /= nums[left++];
        }
        if(left == i){
          multi = 1;
          i = left = find_smaller_el(nums, left_position, i, k);
          if(left < nums.length){
            left_position[i] = i;
            multi = nums[left];
          }
        } else left_position[i] = left;
      }
    }
    // reverse
    int count = 0;
    for(int i = nums.length - 1; i >= 0 ; i--){
      count += switch (left_position[i]){
        case -1 -> 0;
        default -> {
          if(left_position[i] == i) yield 1;
          yield i - left_position[i] + 1;
        }
      };
    }
    return count;
  }

  private int find_smaller_el(int[] nums, int[] left_position, int start, int k){
    while(start < nums.length && nums[start] >= k)
      left_position[start++] = -1;
    return start;
  }


  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int closest_element_index = findClosestElement(arr, x);
    int left = closest_element_index, right = closest_element_index + 1;
    List<Integer> ans = new ArrayList<>(k);
    while(ans.size() < k){
      if(left == -1)
        ans.add(arr[right++]);
      else if(right == arr.length)
        ans.add(arr[left--]);
      else {
        if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)){
          ans.add(arr[right++]);
        }else ans.add(arr[left--]);
      }
    }
    ans.sort((a, b) -> a - b);
    return ans;
  }

  // 找到res, 使得arr[res - 1] >= x and arr[res + 1] > x
  private int findClosestElement(int[] arr, int x){
    if(arr[0] >= x) return 0;
    else if(arr[arr.length - 1] <= x) return arr.length - 1;
    int left = 0;
    int right = arr.length;
    int medium = (left + right) >> 1;
    while(arr[medium] > x || (medium < arr.length && arr[medium + 1] <= x)){
      if(arr[medium] > x) right = medium;
      else left = medium;
      medium = (left + right) >> 1;
    }
    return medium;
  }


  //  662. 二叉树最大宽度
  // 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。

  // 树的 最大宽度 是所有层中最大的 宽度 。

  // 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。

  // 题目数据保证答案将会在  32 位 带符号整数范围内。

  //  

  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/maximum-width-of-binary-tree
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  // 层序遍历
  public int widthOfBinaryTree(TreeNode root) {
    if(Objects.isNull(root)) 
      return 0;
    Deque<WithIndex> queue = new LinkedList<>();
    queue.add(new WithIndex(root, 0));
    int max_width = 1;
    while(!queue.isEmpty()){
      max_width = Math.max(queue.peekLast().index - queue.peekFirst().index + 1 , max_width);
      final int need2rm = queue.size();
      for(int i=0; i<need2rm; i++){
        WithIndex curNode = queue.poll();
        if( Objects.nonNull( curNode.node.left) ){
          queue.add(new WithIndex(curNode.node.left, curNode.index * 2));
        }
        if( Objects.nonNull( curNode.node.right) ){
          queue.add(new WithIndex(curNode.node.right, curNode.index * 2 + 1));
        }
      }
    }
    return max_width;
  }

  private static class WithIndex {
    final TreeNode node;
    final int index;

    public WithIndex(TreeNode _node, int _index){
      node = _node;
      index = _index;
    }
  }

}
