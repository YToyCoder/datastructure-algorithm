package com.learn.ds;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.learn.ds.graph.Graph;

public class GraphTest {

  @Test
  public void test() {
    Graph graph = Graph.create(new int[][] {
      {1, 2},
      {3, 4},
      {2, 3},
      {1, 5},
      {3, 7},
      {8, 6}
    });

    List<Integer> allNodes = new ArrayList<>();
    graph.bfTraversal(1, el -> {
      allNodes.add(el);
    });
    assertEquals(8, allNodes.size());
  }
}
