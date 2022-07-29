package com.learn.algorithms.leetcode.easy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
  
  public List<String> fizzBuzz(int n) {
    return IntStream.range(1, n + 1)
    .mapToObj(el -> {
      if(el % 3 == 0 && el % 5 == 0) {
        return "FizzBuzz";
      }else if(el % 3 == 0){
        return "Fizz";
      }else if(el % 5 == 0)
        return "Buzz";
      else return Integer.toString(el);
    })
    .collect(Collectors.toList());
  }
}
