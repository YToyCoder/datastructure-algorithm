package com.learn.algorithms.basic;

import java.util.List;

public class BasicSort {
  private BasicSort(){}


  /**
   * insertion sort
   * @param <T>
   * @param list
   */
  public static <T extends Comparable<T>>  void insertion(List<T> list){
    for(int i=1; i < list.size(); i++){
      int walk = i;
      while(walk > 0 && list.get(walk).compareTo(list.get(walk - 1)) < 0){
        swap(list, walk, walk - 1);
        walk--;
      }
    }
  }

  // simple swap
  public static <T extends Comparable<T>> void swap(List<T> list, int a, int b){
    assert a >= 0;
    assert b >= 0;
    assert list.size() > a && list.size() > b;
    T temp = list.get(a);
    list.set(a, list.get(b));
    list.set(b, temp);
  }
  
}
