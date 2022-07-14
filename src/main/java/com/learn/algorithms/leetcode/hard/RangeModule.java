package com.learn.algorithms.leetcode.hard;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;


/**
 * Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。
 * 半开区间 [left, right) 表示所有 left <= x < right 的实数 x 。
 * 实现 RangeModule 类:
    RangeModule() 初始化数据结构的对象。
    void addRange(int left, int right) 添加 半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
    boolean queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true ，否则返回 false 。
    void removeRange(int left, int right) 停止跟踪 半开区间 [left, right) 中当前正在跟踪的每个实数。

  来源：力扣（LeetCode）
  链接：https://leetcode.cn/problems/range-module
  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RangeModule {
  
  private TreeMap<Integer, Integer> ranges;
  // <start, end>
  
  public RangeModule() {
    ranges = new TreeMap<>();
  }
  
  public void addRange(int left, int right) {
    // 小于left的range
    Map.Entry<Integer, Integer> range = ranges.floorEntry(left);
    if(Objects.nonNull(range) && inRange(left, right, range)) 
      // left rignt 区间已经存在
      // a <----> b
      // <- a -- left -- right -- b ->
      return;
    NavigableMap<Integer, Integer> includeRange = ranges.subMap(left, false, right, true);
    // <-- left --- include Range   --- include range end <= right -->
    final Map.Entry<Integer, Integer> lastEntry = includeRange.lastEntry();
    final int maxRight = includeRange.isEmpty() ? right : Math.max(right, lastEntry.getValue());
    if(Objects.nonNull(range) && left <= range.getValue()){
      // case <-- range start -- left -- range end -- includeRange -- right ->
      // case <-- range start -- left == range end -- includeRange -->
      ranges.replace(range.getKey(), maxRight);
    }else{
      // case <-- left -- includeRange -- right -->
      ranges.put(left, maxRight);
    }

    // remove between range
    for(int key : includeRange.keySet().toArray(new Integer[0])){
      ranges.remove(key);
    }
  }
  
  public boolean queryRange(int left, int right) {
    if(left>right) return false;
    Map.Entry<Integer, Integer> range = ranges.floorEntry(left);
    return Objects.nonNull(range) && inRange(left, right, range);
  }
  
  private boolean inRange(final int left, final int right, Map.Entry<Integer, Integer> range){
    return (range.getKey() <= left ) && ( range.getValue() >= right);
  }
  
  public void removeRange(int left, int right) {
    NavigableMap<Integer, Integer> includeRange = ranges.subMap(left, false, right, false);
    if(!includeRange.isEmpty()){
      // last range
      final var lastEntry = ranges.lastEntry();
      for(int key : includeRange.keySet().toArray(new Integer[0])){
        ranges.remove(key);
      }
      if(right < lastEntry.getValue()) ranges.put(right, lastEntry.getValue());
    }

    final var floorOfLeft = ranges.floorEntry(left);
    if(Objects.nonNull(floorOfLeft) && floorOfLeft.getValue() > left){
      final int rightOfFloorLeft = floorOfLeft.getValue();
      if(floorOfLeft.getKey() < left)
        ranges.replace(floorOfLeft.getKey(), left);
      else ranges.remove(left);
      if(rightOfFloorLeft > right ){
        ranges.put(right, rightOfFloorLeft);
      }
    }
  }

  public TreeMap<Integer, Integer> map(){
    return ranges;
  }
}
