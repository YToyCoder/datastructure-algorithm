package com.learn.algorithms.basic;

import java.util.List;

public class BasicSort {
  private BasicSort(){}


  /**
   * selection sort 
   * <p> The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
   * @param <T>
   * @param list
   */
  public static <T extends Comparable<T>> void selection(List<T> list){
    for(int i=0; i < list.size() - 1; i++){
      // find min element between i and list.size
      int min = i;
      for(int j=i + 1; j < list.size(); j++){
        if(list.get(j).compareTo(list.get(min)) < 0){
          min = j;
        }
      }
      if(min != i) swap(list, min, i);
    }
  }

  /**
   * bubble sort
   * @param <T>
   * @param list
   */
  public static <T extends Comparable<T>> void bubble(List<T> list){
    for(int i = 0; i < list.size() - 1; i++){
      for(int j=0; j < list.size() - i - 1; j++){
        if(list.get(j).compareTo(list.get(j + 1)) > 0){
          swap(list, j, j + 1);
        }
      }
    }
  }

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
