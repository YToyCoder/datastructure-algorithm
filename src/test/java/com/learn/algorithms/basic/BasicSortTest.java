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

  public void common(Consumer<List<Integer>> sort){
    sort.accept(case1);
    assertArrayEquals(case1.toArray(), List.of(1,2,4,9).toArray());
    sort.accept(case2);
    final var case2arr = case2.toArray();
    Arrays.sort(case2arr);
    assertArrayEquals(case2.toArray(), case2arr);
  }
}
