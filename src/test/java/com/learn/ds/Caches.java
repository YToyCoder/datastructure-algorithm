package com.learn.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.stream.IntStream;

import org.junit.Test;

import com.learn.ds.caches.Cache;
import com.learn.ds.caches.LFUCache;

public class Caches {

  @Test
  public void lfu_cache_test(){
    Cache<Integer,String> cache = LFUCache.<Integer,String>create(4);
    assertNull(cache.get(1));
    IntStream.range(0, 4)
    .forEach(i -> {
      cache.put(i, String.format("string-%d", i));
    });
    assertNotNull(cache.get(0));
    assertNotNull(cache.get(1));
    assertNotNull(cache.get(2));
    assertNotNull(cache.get(3));
    assertEquals("string-0", cache.put(4, "4"));
  }

}
