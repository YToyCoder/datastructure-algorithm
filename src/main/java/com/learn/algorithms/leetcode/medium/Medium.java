package com.learn.algorithms.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeMap;

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

}
