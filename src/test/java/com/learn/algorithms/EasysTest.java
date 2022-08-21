package com.learn.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.learn.algorithms.leetcode.easy.Easys;

public class EasysTest {
  Easys easys = new Easys();

  @Test
  public void reformat(){
    easys.reformat("covid2019");
  }

  @Test
  public void isPrefixOfWord() {
    assertEquals(4, easys.isPrefixOfWord( "i love eating burger", "burg")); 
  }
}
