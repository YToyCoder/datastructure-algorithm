package com.learn.ds;

import static org.junit.Assert.assertEquals;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.learn.ds.lists.SingleLinkedList;

public class ListTest {

  @Test
  public void singleLinkedListTest(){
    var list = new SingleLinkedList<Integer>();
    list.addAll(Stream.generate(new Supplier<Integer>() {
      int seed = 0;

      @Override
      public Integer get() {
        return seed++;
      }
      
    }).limit(10).collect(Collectors.toList()));
    assertEquals(10, list.size());
    int walk = 0;
    for(var el : list){
      assertEquals(walk++, (int)el);
    }
  }
}
