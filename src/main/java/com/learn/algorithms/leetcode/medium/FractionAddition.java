package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

public class FractionAddition {

  public String fractionAddition(String expression) {

    Fraction adds = new Fraction(0, 1);
    char[] chars = expression.toCharArray();
    int n = 0;
    int d = 0;
    int sign = 0;
    boolean gettingFraction = false;
    boolean gettingN = true;
    int power = 1;

    for(int i=0; i<chars.length; i++){
      if(i == 0 && Character.isDigit(chars[i])){
        n = n * power + (chars[i] - '0');
        power *= 10;
        gettingFraction = true;
        sign = 1; // 正数
      }else if(gettingFraction){
        if(Objects.equals(chars[i], '/')){
          gettingN = false;
          power = 1;
        }else if(gettingN){
          n = n * power + (chars[i] - '0');
          power *= 10;
        }else if(!gettingN){
          d = d * power + (chars[i] - '0');
          power *= 10;
          if(i == chars.length - 1 || !Character.isDigit(chars[i + 1]) ){ // finish getting Fraction
            adds = add(adds , new Fraction(n  * sign, d));
            n = 0;
            d = 0;
            power = 1;
            gettingFraction = false;
          }
        }
      }else {
        sign = Objects.equals(chars[i], '-') ? -1 : 1;
        gettingFraction = true;
        gettingN = true;
      }
    }
    StringBuilder sb = new StringBuilder();
    int b = gcd(Math.abs(adds.d), Math.abs(adds.n));
    sb.append(adds.n / b).append("/").append( adds.d / b);
    return sb.toString();
  }
  
  static class Fraction{
    final int n;
    final int d;
    
    public Fraction(final int n, final int d){
      this.n = n;
      this.d = d;
    }
  }

  int gcd(int n , int b){
    return n == 0 || b == 0 ? 
          Math.abs(n - b) : n > b ? 
          gcd(b, n % b) :
          gcd(n, b % n); 
  }

  Fraction add(Fraction a, Fraction b){
    return new Fraction(a.n * b.d + a.d * b.n, a.d * b.d);
  }

}
