package com.learn.algorithms.basic;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

public class BasicSortTest {

  private static List<Integer> case1 = new ArrayList<>(List.of(2,1, 9, 4));
  private static List<Integer> case2 = new ArrayList<>(List.of(3, 7, 10 , 8 , 6, 100, 25, 16, 30 , 21));
  private static List<Integer> case3 = new ArrayList<>(List.of(50, 100, 200, 20, 101, 300, 100, 200, 150, 27, 149, 3, 180,74));

  @Test
  public void shellSortTest(){
    common(BasicSort::shell);
  }

  @Test
  public void insertionTest(){
    // BasicSort.insertion(case1);
    // assertArrayEquals(case1.toArray(), List.of(1,2,4,9).toArray());
    // BasicSort.insertion(case2);
    // final var case2arr = case2.toArray();
    // Arrays.sort(case2arr);
    // assertArrayEquals(case2.toArray(), case2arr);
    common(BasicSort::insertion);
  }

  @Test
  public void bubbleTest(){
    // BasicSort.bubble(case1);
    // assertArrayEquals(case1.toArray(), List.of(1,2,4,9).toArray());
    // BasicSort.bubble(case2);
    // final var case2arr = case2.toArray();
    // Arrays.sort(case2arr);
    // assertArrayEquals(case2.toArray(), case2arr);
    common(BasicSort::bubble);
  }

  @Test
  public void selectionTest(){
    common(BasicSort::selection);
  }

  @Test
  public void mergeTest() {
    common(BasicSort::merge);
  }

  @Test
  public void quickTest() {
    common(BasicSort::quick);
    // doRun(BasicSort::quick);
  }

  @Test
  public void countingTest() {
    common(BasicSort::counting);
    common(BasicSort::counting2);
  }

  @Test
  public void bucketTest(){
    final var case1 = new ArrayList<>(List.of(0.12, 0.81, 0.83, 0.72, 0.72, 0.6, 0.7));
    final var origin = new double[case1.size()];
    for(int i=0; i < case1.size(); i++){
      origin[i] = case1.get(i);
    }
    final var case1arr = Arrays.copyOf(origin, origin.length);
    Arrays.sort(case1arr);
    BasicSort.bucket(origin,8);
    assertArrayEquals(case1arr, origin, 0.00001);
    // for(int el : )
  }

  static int[] intcase1 = new int[] { 2,1, 9, 4 };
  static int[] intcase2 = new int[] { 3, 7, 10 , 8 , 6, 100, 25, 16, 30 , 21 };
  static int[] intcase3 = new int[] { 50, 100, 200, 20, 101, 300, 100, 200, 150, 27, 149, 3, 180,74 };
  @Test
  public void radixSort() {
    final int[] icc1 = Arrays.copyOf(intcase1, intcase1.length);
    final int[] icc2 = Arrays.copyOf(intcase2, intcase2.length);
    final int[] icc3 = Arrays.copyOf(intcase3, intcase3.length);
    // case 1
    BasicSort.radix(icc1);
    Arrays.sort(intcase1);
    assertArrayEquals(intcase1, icc1);
    BasicSort.radix(icc2);
    Arrays.sort(intcase2);
    assertArrayEquals(intcase2, icc2);
    BasicSort.radix(icc3);
    Arrays.sort(intcase3);
    assertArrayEquals(intcase3, icc3);
  }

  static class Radix_sort_tests{

  }

  /**
   *            100
   *           /   \
   *         30     25
   *        / \    /  \
   *      16 21   10  3
   *     / \  /\    
   *    7  8 6
   */
  @Test
  public void heapTest() {
    common(BasicSort::heap);
    // BasicSort.heap(case1);
    // case1.forEach(System.out::println);
    // BasicSort.heap(case2);
    // case2.forEach(System.out::println);
  }

  private void doRun(Consumer<List<Integer>> sort){
    // sort.accept(case1);
    sort.accept(case2);
  }

  public void common(Consumer<List<Integer>> sort){
    sort.accept(case1);
    assertArrayEquals(case1.toArray(), List.of(1,2,4,9).toArray());
    sort.accept(case2);
    final var case2arr = case2.toArray();
    Arrays.sort(case2arr);
    assertArrayEquals(case2.toArray(), case2arr);

    sort.accept(case3);
    final var case3arr = case3.toArray();
    Arrays.sort(case3arr);
    assertArrayEquals(case3.toArray(), case3arr);
  }
}
