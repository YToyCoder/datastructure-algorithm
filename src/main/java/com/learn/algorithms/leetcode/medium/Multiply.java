package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

public class Multiply {

  public String multiply(String num1, String num2) {
    if(num1.length() == 0) return num2;
    String ans = "0";
    int power = 0;
    for(int i=0; i < num1.length(); i++){
      char c = num1.charAt(num1.length() - i - 1);
      ans = add(ans, multi(c, multiTen( num2, power++)));
    }
    return ans;
  }

  public String multi(char num, String nums){
    int carry = 0;
    final int numInt = digit(num);
    if(numInt == 0 || (nums.length() == 0 && Objects.equals('0', nums.charAt(0)))) return "0";
    int multi = 0;
    StringBuilder sbuilder = new StringBuilder();
    for(int i=0; i<nums.length(); i++){
      char el = nums.charAt(nums.length() - i - 1);
      multi = digit(el) * numInt + carry;
      carry = multi / 10;
      sbuilder.append(multi % 10);
    }
    if(carry != 0) sbuilder.append(carry);
    return sbuilder.reverse().toString();
  }

  public String multiTen(String nums, int tenLen){
    if(nums.length() == 1 && Objects.equals(nums.charAt(0), '0')) return "0";
    StringBuilder strs = new StringBuilder();
    for(int i = 0; i < tenLen; i++){
      strs.append("0");
    }
    return strs.insert(0, nums).toString();
  }

  static int digit(char c){
    return Character.digit(c, 36);
  }

  /*
   * a      123 
   * b     3456
   */
  public String add(String a, String b){
    final int maxLen = Math.max(a.length(), b.length());
    StringBuilder strBuilder = new StringBuilder();
    int carry = 0;
    int aV, bV;
    for(int i = 0; i < maxLen; i++){
      aV = i < a.length() ? digit(a.charAt(a.length() - i - 1)) : 0;
      bV = i < b.length() ? digit(b.charAt(b.length() - i - 1)) : 0;
      int cur = aV + bV + carry;
      carry = cur / 10;
      strBuilder.append(cur % 10);
    }
    if(carry > 0) strBuilder.append(carry);
    return strBuilder.reverse().toString();
  }
}
