package com.learn.algorithms.leetcode.easy;

import java.util.LinkedList;
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

}
