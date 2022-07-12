package com.learn.ds.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Queue;
import java.util.function.Consumer;


/**
 * simple implementation of Graph
 */
public class Graph {

  public void bfTraversal(int start, Consumer<Integer> nodeHandler){
    if(!containNode(start)) return;
    Set<Integer> visited = new HashSet<>();
    visitInterval(start, nodeHandler, visited);
  }

  private void visitInterval(int start, Consumer<Integer> nodeHandler, Set<Integer> visited){
    nodeHandler.accept(start);
    visited.add(start);
    Queue<Integer> toVisit = new LinkedList<>();
    Set<Integer> ts = edges.get(start);
    if(Objects.nonNull(ts))
      toVisit.addAll(ts);
    while(!toVisit.isEmpty()){
      int visitNode = toVisit.poll();
      if(!visited.contains(visitNode)){
        nodeHandler.accept(visitNode);
        visited.add(visitNode);
        ts = edges.get(visitNode);
        if(Objects.nonNull(ts))
          toVisit.addAll(ts);
      }
    }
    for(int el : nodes){
      if(!visited.contains(el)){
        visitInterval(el, nodeHandler, visited);
      }
    }
  }

  // source
  // [from, to]
  public static Graph create(int[][] source){
    Graph graph = new Graph();
    for(int[] el : source){
      int from = el[0];
      int to   = el[1];
      if(!graph.containNode(from)){
        graph.addNode(from);
      }
      if(!graph.containNode(to)){
        graph.addNode(to);
      }
      graph.addEdge(from, to);
    }
    return graph;
  }

  private Set<Integer> nodes;
  private Map<Integer, Set<Integer>> edges;

  public Graph(){
    nodes = new HashSet<>();
    edges = new HashMap<>();
  }

  public void addNode(int node){
    nodes.add(node);
  }

  public boolean containNode(int node){
    return nodes.contains(node);
  }

  public void addEdge(int from, int to){
    Set<Integer> tos = edges.computeIfAbsent(from, key -> new HashSet<>());
    if(!tos.contains(to)) tos.add(to);
  }

}
