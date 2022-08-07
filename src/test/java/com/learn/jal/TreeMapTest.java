package com.learn.jal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.TreeMap;

import org.junit.Test;

public class TreeMapTest {

  @Test
  public void testComputeIf(){
    TreeMap<String, String> map = new TreeMap<>();
    map.put("key", null);
    var value = map.computeIfAbsent("key", key -> "null");
    assertNotNull(value);
  }

}
