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

  /**
   * 广度优先算法
   * @param start
   * @param nodeHandler
   */
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


  // to store the color of each node
  // this will use color to mark the differnece the node 
  // more standard way to implement the bft
  // 相对#bftTraversal更加标准的实现
  private Map<Integer, Color> colorMapper;
  private Map<Integer, Integer> preNodeMapper;
  private Map<Integer, Integer> pathLenMapper;
  void stdBfTraversal(
    int start, 
    Consumer<Integer> nodeHandler, 
    /** pathLenMapper, colorMapper, preNodeMapper */
    TConsumer<Map<Integer, Integer>, Map<Integer, Color>, Map<Integer,Integer>> mapperAware
  ) {
    if(!containNode(start)) return;
    colorMapper = new HashMap<>(nodes.size());
    preNodeMapper = new HashMap<>(nodes.size());
    for(int el : nodes){
      // set all nodes to white
      colorMapper.put(el, Color.White);
      preNodeMapper.put(el, null);
      pathLenMapper.put(el, -1);
    }
    stdBftVisit(start, nodeHandler);
    if(Objects.nonNull(mapperAware))
      mapperAware.accept(pathLenMapper, colorMapper, preNodeMapper);
    // clear mapper
    colorMapper = null;
    preNodeMapper = null;
    pathLenMapper = null;
  }

  public void stdBfTraversal(
    int start,
    TConsumer<Map<Integer, Integer>, Map<Integer, Color>, Map<Integer,Integer>> mapperAware
  ) {
    stdBfTraversal(start, null, mapperAware);
  }

  public static interface TConsumer<F,S,T> {
    void accept(F f, S s, T t);
  }

  void stdBftVisit(int start, Consumer<Integer> nodeHandler) {
    colorMapper.replace(start, Color.Gray);
    Queue<Integer> visited = new LinkedList<>();
    visited.add(start);
    if(Objects.nonNull(nodeHandler)) nodeHandler.accept(start);
    Set<Integer> nexts = null;
    pathLenMapper.replace(start,  0);
    while(!visited.isEmpty()){
      int one = visited.poll();
      nexts = edges.get(one);
      int pathLen = pathLenMapper.get(one);
      if(Objects.nonNull(nexts) && !nexts.isEmpty()){
        for(int next : nexts){
          final Color color = colorMapper.get(next);
          if(color == Color.White){
            colorMapper.replace(next, Color.Gray);
            preNodeMapper.put(next, one);
            visited.add(next);
            pathLenMapper.replace(next, pathLen + 1);
            if(Objects.nonNull(nodeHandler)) nodeHandler.accept(start);
          }
        }
        colorMapper.replace(one, Color.Black);
      }
    }
  }

  /**
   * 深度优先搜索
   * @param start
   * @param nodeHandler
   */
  public void dfTraversal(int start, Consumer<Integer> nodeHandler){
    if(!containNode(start)) return;
    Set<Integer> visited = new HashSet<>();
    deepVisit(start, nodeHandler, visited);
    for(int el : nodes){
      if(!visited.contains(el)){
        deepVisit(el, nodeHandler, visited);
      }
    }
  }

  private void deepVisit(int start, Consumer<Integer> nodeHandler, Set<Integer> visited) {
    nodeHandler.accept(start);
    visited.add(start);
    Set<Integer> ts = edges.get(start);
    if(Objects.nonNull(ts) && !ts.isEmpty()){
      for(int el : ts){
        if(!visited.contains(el)) // 递归-回溯
          deepVisit(el, nodeHandler, visited);
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
