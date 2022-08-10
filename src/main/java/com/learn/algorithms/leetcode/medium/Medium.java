package com.learn.algorithms.leetcode.medium;

import java.util.Map;
import java.util.Objects;

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
    final int[] ans = new int[n];
    for(int[] booking : bookings){
      for(int air=booking[0]; air <= booking[1]; air++){
        ans[air - 1] += booking[2];
      }
    }
    return ans;
  }

}
