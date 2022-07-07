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
