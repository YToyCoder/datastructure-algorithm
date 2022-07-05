package com.learn.algorithms.basic;

import java.util.List;

import com.learn.utils.Heaps;

public class BasicSort {
  private BasicSort(){}

  /**
   * quick sort
   * @param <T>
   * @param list
   */
  public static <T extends Comparable<T>> void quick(List<T> list){
    partition(list, 0, list.size());
    list.forEach(System.out::println);
  }

  public static <T extends Comparable<T>> void partition(List<T> list, int start, int end){
    /**
     * a swap example:
     * start <------------------------> end
     * 
     * lower       pivot
     * |            ||
     * |            \/
     * ? 7 9 4 5 2 1 6
     *  pivot
     *   ||
     *   \/
     * ? 6 9 4 5 2 1 7
     * 
     */
    if(end - start <= 1) return;
    int lower = start - 1;
    final T pivot = list.get(end - 1);
    for(int i=start; i < end - 1; i++){
      if(greater(pivot, list.get(i))){ 
        // found smaller one
        swap(list, i, ++lower);
      }
    }
    swap(list, ++lower, end - 1);
    // do more partition
    partition(list, start,lower);
    partition(list, lower, end);
  }

  /**
   * heap sort
   * structure:
   *  array [0, 1, 2, 3, 4, 5, 6, ...] can be seen as follow: 
   *        0 
   *       / \
   *      1   2
   *     / \ / \
   *    3  4 5  6
   *   ...
   * node i has child 2 * i + 1 and 2 * i + 2 , has parent (i - 1)/2
   * try to build the max heap
   * @param <T>
   * @param list
   */
  public static <T extends Comparable<T>> void heap(List<T> list){
    // build the heap
    for(int i= list.size()/2 - 1; i >= 0; i--){
      heapfyDown(list, i, list.size());
    }
    System.out.println("built");
    list.forEach(System.out::println);
    System.out.println("print finished");

    // iterate list select swap index of 0 and end, do {@code heapfyDown} from 0 to end
    for(int i=0; i < list.size(); i++){
      final int end = list.size()  - i;
      swap(list, 0, end - 1);
      heapfyDown(list, 0, end - 1);
    }
  }

  /**
   * a is greater than b
   * @param <T>
   * @param a
   * @param b
   * @return a > b
   */
  private static <T extends Comparable<T>> boolean greater(T a, T b) {
    return a.compareTo(b) > 0;
  }

  private static <T extends Comparable<T>> void heapfyDown(List<T> list, int start, int end){
    int walk = start;
    int leftChild = Heaps.leftChild(walk), rightChild = Heaps.rightChild(walk);
    while(
      walk < end && 
      ( 
        (leftChild < end && greater(list.get(leftChild), list.get(walk))) || 
        (rightChild < end && greater(list.get(rightChild), list.get(walk)))
      )
    ){
      // swap with child 
      final int betterChild = 
        leftChild < end && 
        (rightChild >= end || greater(list.get(leftChild), list.get(rightChild))) 
        ? leftChild : 
          rightChild ;
      swap(list, walk, betterChild);
      walk = betterChild;
      leftChild = Heaps.leftChild(walk);
      rightChild = Heaps.rightChild(walk);
    }
  }

  /**
   * merge sort
   * @param <T>
   * @param list
   */
  public static <T extends Comparable<T>> void merge(List<T> list){
    doMergeSort(list, 0, list.size());
  }

  private static <T extends Comparable<T>> void doMergeSort(List<T> list, int start, int end){
    // 
    if(end - start <= 1) return;
    final int mid = (start + end) / 2;
    doMergeSort(list, start, mid);
    doMergeSort(list, mid, end);

    // do sort
    for(int i=0; i<end; i++){
      // use insertion sort 
      insertionSort(list, start, end);
    }
  } 

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
      while(walk > 0 && list.get(walk).compareTo(list.get(walk - 1)) < 0 && walk < list.size()){
        swap(list, walk, walk - 1);
        walk--;
      }
    }
  }

  private static <T extends Comparable<T>>  void insertionSort(List<T> list, int start, int end){
    for(int i=start; i < list.size() && i < end; i++){
      int walk = i;
      while(walk > 0 && list.get(walk).compareTo(list.get(walk - 1)) < 0 && walk < list.size() && walk < end){
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
