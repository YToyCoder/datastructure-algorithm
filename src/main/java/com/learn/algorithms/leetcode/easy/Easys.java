package com.learn.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
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
}
