package com.learn.algorithms.leetcode.medium;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/** 

实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。

当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。

日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end 。

实现 MyCalendar 类：

MyCalendar() 初始化日历对象。
boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/my-calendar-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
       ^       ^                       ^               ^
*/
public class MyCalendar {

  TreeMap<Integer,Integer> calendar;
  
  public MyCalendar() {
    calendar = new TreeMap<>();
  }
  
  public boolean book(int start, int end) {
    if(calendar.isEmpty()){
      calendar.put(start, end);
      return true;
    }
    // end ==>> left
    // one-left  ?(start) one-right <<=== end ===>> left
    final Integer higherOne = calendar.ceilingKey(end);
    final Map.Entry<Integer, Integer> mayInclude = Objects.isNull(higherOne) ? calendar.lastEntry() : calendar.lowerEntry(higherOne); 
    if(Objects.equals(higherOne, calendar.firstKey()) ||  mayInclude.getValue() <= start) {
      calendar.put(start, end);
      return true;
    }
    return false;
  }
}
