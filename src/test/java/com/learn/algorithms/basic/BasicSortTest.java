package com.learn.algorithms.basic;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BasicSortTest {

  private static List<Integer> case1 = new ArrayList<>(List.of(2,1, 9, 4));
  private static List<Integer> case2 = new ArrayList<>(List.of(3, 7, 10 , 8 , 6, 100, 25, 16, 30 , 21));

  @Test
  public void insertionTest(){
    BasicSort.insertion(case1);
    assertArrayEquals(case1.toArray(), List.of(1,2,4,9).toArray());
    BasicSort.insertion(case2);
    final var case2arr = case2.toArray();
    Arrays.sort(case2arr);
    assertArrayEquals(case2.toArray(), case2arr);
  }

  @Test
  public void bubbleTest(){
    BasicSort.bubble(case1);
    assertArrayEquals(case1.toArray(), List.of(1,2,4,9).toArray());
    BasicSort.bubble(case2);
    final var case2arr = case2.toArray();
    Arrays.sort(case2arr);
    assertArrayEquals(case2.toArray(), case2arr);
  }
}
