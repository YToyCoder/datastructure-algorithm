package com.learn.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class Easys {
  
  public String reformat(String s) {
    final char[] chars = new char[s.length()];
    Queue<Character> digits = new LinkedList<>();
    Queue<Character> als = new LinkedList<>();
    boolean add_digit = Character.isDigit(s.charAt(0));
    int walk = 0;
    for(int i=0; i<s.length(); i++){
      if(add_digit) {
        // digit no empty
        if(!digits.isEmpty()) {
          chars[walk++] = digits.poll();
          add_digit = !add_digit;
          if(Character.isDigit(s.charAt(i)))
            digits.add(s.charAt(i));
          else als.add(s.charAt(i));
        }
        else if(Character.isDigit(s.charAt(i))){
          chars[walk++] = s.charAt(i);
          add_digit = !add_digit;
        }else als.add(s.charAt(i));
      }else{
        if(!als.isEmpty()) {
          chars[walk++] = als.poll();
          add_digit = !add_digit;
          if(Character.isDigit(s.charAt(i)))
            digits.add(s.charAt(i));
          else als.add(s.charAt(i));
        }
        else if(Character.isDigit(s.charAt(i))){
          digits.add(s.charAt(i));
        }else{
          chars[walk++] = s.charAt(i);
          add_digit = !add_digit;
        } 
      }
    }
    while(
      (add_digit && !digits.isEmpty()) ||  
      (!add_digit && !als.isEmpty())
    ){
      if(add_digit)
        chars[walk++] = digits.poll();
      else
        chars[walk++] = als.poll();
      add_digit = !add_digit;
    }
    if(s.length() % 2 == 1 && digits.size() + als.size() == 1){
      return new StringBuilder()
      .append(digits.isEmpty() ? als.poll() : digits.poll())
      .append(chars, 0, chars.length - 1).toString();
    }
    return !digits.isEmpty() || !als.isEmpty() ? "" : String.valueOf(chars);
  }


  public int isPrefixOfWord(String sentence, String searchWord) {
    int search_walk = 0;
    int word_count = 0;
    final char[] sentence_chars = sentence.toCharArray();
    for(int i=0; i<sentence_chars.length; i++){
      

      if(
        search_walk != -1 && 
        Objects.equals(sentence_chars[i], searchWord.charAt(search_walk))
      ) {
        search_walk++;
        if(search_walk == searchWord.length())
          return word_count;
      } else if(
        search_walk != -1 && 
        !Objects.equals(sentence_chars[i], searchWord.charAt(search_walk))
      ) search_walk = -1;

      if(i == 0 && !Objects.equals(sentence_chars[i], ' '))
        word_count++;
      else if(
        i + 1 < sentence_chars.length && 
        Objects.equals(sentence_chars[i], ' ') && 
        !Objects.equals(sentence_chars[i + 1], ' ')
      ){
        word_count++;
        search_walk = 0;
      }
    }
    return -1;
  }


  public boolean canBeEqual(int[] target, int[] arr) {
    Arrays.sort(target);
    Arrays.sort(arr);
    for(int i=0; i<target.length; i++){
      if(target[i] != arr[i])
        return false;
    }
    return true;
  }


  public int[] shuffle(int[] nums, int n) {
    int[] ans = new int[2 * n];
    for(int i=0; i<n; i++){
      ans[i * 2] = nums[i];
      ans[i * 2+ 1] = nums[n + i]; 
    }
    return ans;
  }

  // 1475. 商品折扣后的最终价格
  // 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
  // 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
  // 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public int[] finalPrices(int[] prices) {
    final int len = prices.length;
    final int[] index4next_less = new int[prices.length];
    index4next_less[len - 1] = len - 1;
    for(int i = prices.length - 1; i > 0; i--){
      int next = i;
      final int cur = prices[i - 1];
      while(
        index4next_less[next] != next && 
        prices[next] > cur
      ){
        next = index4next_less[next];
      }
      index4next_less[i - 1] = prices[next] <= cur ? next : i - 1;
    }
    for(int i=0; i<len; i++){
      index4next_less[i] = index4next_less[i] == i ? prices[i] : prices[i] - prices[index4next_less[i]];
    }
    return index4next_less;
  }

  // 1592. 重新排列单词间的空格
  public String reorderSpaces(String text) {
    boolean in_word = false;
    final char[] chars = text.toCharArray();
    final int len = text.length();
    int left = 0;
    int blank_count = 0;
    List<String> strs = new LinkedList<>();
    for(int i=0; i<len; i++){
      final char cur = chars[i];
      if(!in_word) {
        if(!Objects.equals(cur, ' ')){
          left = i;
          in_word = true;
          if(i + 1 == len){
            strs.add(text.substring(len - 1));
          }
        }else
          blank_count++;
      }else{
        if(i + 1 == len || Objects.equals(cur, ' ')){
          blank_count += Objects.equals(cur, ' ') ? 1 : 0;
          strs.add(text.substring(left, ( i + 1 == len && !Objects.equals(chars[i], ' ')) ? len : i));
          in_word= false;
        }
      }
    }
    int tail_append = strs.size() <= 1 ? blank_count : blank_count % (strs.size() - 1);
    int average = strs.size() <= 1 ? 0 : blank_count / (strs.size() - 1);
    StringBuilder builder = new StringBuilder(strs.isEmpty() ? "" : strs.get(0));
    for(int i=1; i<strs.size(); i++){
      builder.append(" ".repeat(average)).append(strs.get(i));
    }
    return builder.append(" ".repeat(tail_append)).toString();
  }

  // 1598. 文件夹操作日志搜集器
  // 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
  // 下面给出对变更操作的说明：
  // "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
  // "./" ：继续停留在当前文件夹。
  // "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
  // 给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
  // 文件系统启动时位于主文件夹，然后执行 logs 中的操作。
  // 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
  // 来源：力扣（LeetCode）
  // 链接：https://leetcode.cn/problems/crawler-log-folder
  // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public int minOperations(String[] logs) {
    final String goto_cur = "./";
    final String goto_up  = "../";
    int step = 0;
    for(String log : logs){
      switch (log) {
        case goto_cur:
          break;
        case goto_up:
          if(step > 0)
            step--;
          break;
        default:
          step++;
          break;
      }
    }
    return step;
  }

  // 1636. 按照频率将数组升序排序
  // 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。 
  // 请你返回排序后的数组。
  public int[] frequencySort(int[] nums) {
    Map<Integer, IntHolder> map = new HashMap<>();
    for(int el : nums)
      map.computeIfAbsent(el, key -> new IntHolder()).int4++;
    int walk = 0;
    List<Map.Entry<Integer, IntHolder> > entries = new ArrayList<>( map.entrySet() );
    entries.sort((a, b) -> b.getKey() - a.getKey());
    entries.sort((a, b) -> a.getValue().int4 - b.getValue().int4);
    int[] ans = new int[nums.length];
    for(Map.Entry<Integer, IntHolder> entry : entries){
      for(int i=0; i<entry.getValue().int4; i++){
        ans[walk++] = entry.getKey();
      }
    }
    return ans;
  }

  static class IntHolder {
    int int4;
  }

}
