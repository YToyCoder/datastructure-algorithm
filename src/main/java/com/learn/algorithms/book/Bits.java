package com.learn.algorithms.book;

public class Bits {

  /**
   * 通过位操作实现两数之积
   * @param a
   * @param b
   * @return
   */
  public static int multiply(int a, int b){
    if(a == 0 || b == 0) return 0;
    // b even 2 * n
    // a 
    // a * b 
    // a * b = a * 2 * (b - 1) / 2 + a
    return isOdd(b)  ? 
    multiply(multiplyByTwo(a), divideByTwo(isPositive(b) ? b - 1 : b + 1) ) + (isPositive(b) ? a : -a) : 
    multiply(multiplyByTwo(a), divideByTwo(b));
  }


  // 除以二
  public static int divideByTwo(int el){
    return el >> 1;
  }

  public static boolean isOdd(int el){
    return (el & 1) == 1;
  }

  public static int multiplyByTwo(int el){
    // Integer.toBinaryString(i)
    return el << 1;
  }

  public static boolean isPositive(int el){
    return ((el >> 31) & 1) == 0;
  }



}
