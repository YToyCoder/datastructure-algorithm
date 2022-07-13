package com.learn.algorithms.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.learn.utils.Heaps;

public class BasicSort {
  private BasicSort(){}

  public static Logger log = LogManager.getLogger(BasicSort.class);

  /**
   * radix sort
   * 
   * [0, 30, 81, 22, 31, 12]
   * [0, 30, 81, 31, 22, 12]
   * [0, 12, 22, 30, 31, 81]
   * @param <T>
   * @param ls
   */
  public static void radix(int[] arr){
    final int[] maxAndMin = maxAndMin(arr);
    final int max = arr[maxAndMin[0]];
    for(int exp=1; max/exp > 0; exp *= 10){
      counting(arr, exp, max, maxAndMin[1]);
    }
  }

  static void counting(int[] arr, int n, int max, int min){
    final int[] counts = new int[10]; 
    for(int el : arr){
      int indexInCounts = (el / n) % 10;
      counts[indexInCounts]++;
    }
    for(int i=1; i<10; i++) counts[i] += counts[i - 1];
    final int[] copy = Arrays.copyOf(arr, arr.length);
    for(int i=arr.length - 1; i >= 0; i--){
      int indexInCounts = (copy[i] / n) % 10;
      arr[--counts[indexInCounts]] = copy[i];
    } 
  }

  static int[] maxAndMin(int[] arr){
    int max = 0;
    int min = 0;
    for(int i=0; i < arr.length; i++){
      if(arr[i] > arr[max]) max = i;
      if(arr[i] < arr[min]) min = i;
    }
    return new int[]{max, min};
  }


  /**
   * bucket sort
   * <p>logic :
   * <p> 1. create n empty
   * <p>bucketSort(arr[], n)
   * <p>1) Create n empty buckets (Or lists).
   * <p>2) Do following for every array element arr[i]........a) Insert arr[i] into bucket[n*array[i]]
   * <p>3) Sort individual buckets using insertion sort.
   * <p>4) Concatenate all sorted buckets.
   */
  public static void bucket(double[] ls, int n){
    final List<List<Double>> buckets = Stream.generate(() -> new ArrayList<Double>()).limit(n).collect(Collectors.toList());
    for(double el : ls){
      final int location = (int)(el * n);
      List<Double> bucket = buckets.get(location);
      if(Objects.isNull(bucket)) buckets.set(location, (bucket = new ArrayList<>()));
      insertInOrder(bucket, el, (a , b) -> a > b);
    }

    final List<Double> sorted = buckets.stream().flatMap(bucket -> bucket.stream()).collect(Collectors.toList());
    for(int i=0; i < sorted.size(); i++){
      ls[i] = sorted.get(i);
    }
  }

  /**
   * simpe insert sort implementation
   * @param <T>
   * @param ls
   * @param target
   * @param comparator
   */
  private static <T extends Comparable<T>> void insertInOrder(List<T> ls, T target, BiPredicate<T, T> comparator){
    ls.add(target);
    if(ls.size() <= 1) return;
    int walk = ls.size() - 1;
    while(walk > 0 && comparator.test(ls.get(walk - 1), ls.get(walk))){
      swap(ls, walk, walk - 1);
      walk--;
    }
  }


  /**
   * <p>counting sort
   * <p>logic:
   * arr[] = [1, 1, 4 , 5, 8, 6, 6, 9] -> max 9 min 1
   * counting[] = [0, 0, 0, 0, 0, 0, 0, 0, 0]
   *               1  2  3  4  5  6  7  8  9
   * counting[] = [2, 0, 0, 1, 1, 2, 0, 1, 1]
   * counting[] = [2, 2, 2, 3, 4, 6, 6, 7, 8]
   * @param list
   */
  public static void counting2(List<Integer> list){
    if(list.isEmpty()) return;
    final int[] maxAndMin = maxAndmin(list);
    final int max = list.get(maxAndMin[0]);
    final int min = list.get(maxAndMin[1]);
    final int range = max - min + 1;
    final int[] counts = new int[range];
    for(int el : list){
      counts[el - min] += 1;
    }

    for(int i=1; i < counts.length; i++){
      counts[i] += counts[i - 1];
    }

    final Integer[] origin = list.toArray(new Integer[0]);
    for(int el : origin){
      list.set(--counts[el - min], el);
    }
  }

  /**
   * simple counting sort
   * @param list
   */
  public static void counting(List<Integer> list) {
    if(list.isEmpty()) return;
    final int[] maxAndMin = maxAndmin(list);
    final int max = list.get(maxAndMin[0]);
    final int min = list.get(maxAndMin[1]);
    final int range = max - min + 1;
    final int[] counts = new int[range];
    for(int el : list){
      counts[el - min] += 1;
    }
    int walk = 0;
    for(int index=0; index < counts.length; index++){
      for(int opTime=0; opTime < counts[index]; opTime++){
        list.set(walk++, index + min);
      }
    }
  }

  /**
   * get the index of max node and min in list
   * @param <T>
   * @param list
   * @return if not empty return [max, min], else return null
   */
  private static <T extends Comparable<T>> int[] maxAndmin(List<T> list){
    if(list.isEmpty()) return null;
    int max = 0, min = 0;
    for(int i=0; i < list.size(); i++){
      if(greater(list.get(i), list.get(max))) max = i;
      if(greater(list.get(min), list.get(i))) min = i;
    }
    return new int[]{max, min};
  }
  /**
   * quick sort
   * @param <T>
   * @param list
   */
  public static <T extends Comparable<T>> void quick(List<T> list){
    partition(list, 0, list.size());
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
     *     |
     *    walk
     * 
     * lower       pivot
     * |            ||
     * |            \/
     * ? 7 9 4 5 2 1 6
     *       |
     *      walk -> less than pivot && do swap
     *  
     *  lower      pivot
     *   |          ||
     *   |          \/
     * ? 4 9 7 5 2 1 6
     *       |
     *      walk -> swapped && continue
     * 
     *  lower      pivot
     *   |          ||
     *   |          \/
     * ? 4 9 7 5 2 1 6
     *         |
     *        walk -> less than pivot && do swap
     *
     *   lower    pivot
     *     |        ||
     *     |        \/
     * ? 4 5 7 9 2 1 6
     *         |
     *        walk -> swapped && continue
     * 
     * ? 4 5 2 9 7 1 6
     * 
     *       lower pivot
     *         |    ||
     *         |    \/
     * ? 4 5 2 1 7 9 6
     *             |
     *            walk -> swapped && continue
     * 
     * swap pivot to the partition "lower + 1"
     * ? 4 5 2 1 6 9 7
     * 
     */
    if(end - start <= 1) return;
    int lower = start - 1;
    final T pivot = list.get(end - 1);
    for(int i=start; i < end - 1; i++){
      // if(greater(pivot, list.get(i))){ 
      if(less(list.get(i), pivot)){ 
        // found smaller one
        swap(list, i, ++lower);
      }
    }
    swap(list, ++lower, end - 1);
    // do more partition
    partition(list, start,lower);
    partition(list, lower + 1, end);
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

  /**
   * a is less than b
   * @param <T>
   * @param a
   * @param b
   * @return a < b
   */
  private static <T extends Comparable<T>> boolean less(T a, T b){
    return a.compareTo(b) < 0;
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
    if(list.size() <= a || list.size() <= b) 
      // log.info(String.format("a val is %d, b val is %d, list size is %d", a, b, list.size()));
      System.out.println((String.format("a val is %d, b val is %d, list size is %d", a, b, list.size())));
    assert a >= 0;
    assert b >= 0;
    assert list.size() > a && list.size() > b;
    T temp = list.get(a);
    list.set(a, list.get(b));
    list.set(b, temp);
  }
  
}
