package com.learn.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.learn.algorithms.book.Bits;

public class BitsTest {

  @Test
  public void test() {
    assertEquals(10 * 11, Bits.multiply(10, 11));
    assertEquals(13 * 11, Bits.multiply(13, 11));
    assertEquals(11 * 18, Bits.multiply(11, 18));
    assertEquals(29 * 110, Bits.multiply(29, 110));
    assertEquals(16 * 11, Bits.multiply(16, 11));
  }
}
