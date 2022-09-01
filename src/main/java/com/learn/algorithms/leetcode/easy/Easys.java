package com.learn.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

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
}
