package com.learn.algorithms;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class Search {

  @Test
  public void bs_test(){
    
    int r1 = SearchAndSort.binary_search(List.of(1,2,3,4), 2);
    assertEquals(1, r1);
    int r2 = SearchAndSort.binary_search(List.of(1,2,3,4, 5), 4);
    assertEquals(3, r2);
  }
}
