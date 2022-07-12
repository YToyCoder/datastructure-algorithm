package com.learn.algorithms.zuo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class Graphs {

  public static interface Graph {
    /**
     * 广度优先遍历
     * @param nodeHandler
     */
    void bftTraversal(Consumer<GNode> nodeHandler);
    List<GNode> nodes();
    List<Edge> edges();
    void addNode(int node);
    void addEdge(int from, int to);
  }

  public static interface GNode {
    int value();
    int in();
    int out();
    List<GNode> nexts();
    List<Edge> edges();
  }

  public static interface Edge {
    void weight(int w);
    int weight();
    GNode from();
    GNode to();
  }

  /**
   * 
   * [weight, from, to]
   * @param matrix
   * @return
   */
  public static Graph createGraph(int[][] matrix){
    GraphImpl graph = new GraphImpl(new ArrayList<>(), new ArrayList<>());
    for(int i = 0; i < matrix.length; i++){
      int weight = matrix[i][0];
      int from = matrix[i][1];
      int to = matrix[i][2];
      if(!graph.exists(from))
        graph.addNode(from);
      if(!graph.exists(to))
        graph.addNode(to);
      graph.addEdge(from, to);
    }
    return graph;
  }

  public static class GraphImpl implements Graph {

    private Map<Integer, GNode> nodes;
    private Map<Integer, List<Edge>> edges;

    public GraphImpl(final List<? extends GNode> nodes, final List<? extends Edge> edges){
      this.nodes = nodes.stream().collect(Collectors.toMap(GNode::value, el -> el));
      this.edges = edges.stream().collect(Collectors.groupingBy(el -> el.from().value()));
    }

    @Override
    public void bftTraversal(Consumer<GNode> nodeHandler) {
    }

    @Override
    public List<GNode> nodes() {
      return List.copyOf(nodes.values());
    }

    @Override
    public List<Edge> edges() {
      return edges
            .values().stream()
            .flatMap(
              es -> es.stream()
            )
            .collect(Collectors.toList());
    }

    public static class GNodeImpl implements GNode{
      private int value;
      private int in;
      private int out;
      private List<GNode> nexts;
      private List<Edge> edges;

      public GNodeImpl(int value, int in, int out, List<GNode> nexts, List<Edge> edges) {
        this.value = value;
        this.in = in;
        this.out = out;
        this.nexts = nexts;
        this.edges = edges;
      }

      @Override
      public int value() {
        return value;
      }

      @Override
      public int in() {
        return in;
      }

      @Override
      public int out() {
        return out;
      }

      @Override
      public List<GNode> nexts() {
        return nexts;
      }

      @Override
      public List<Edge> edges() {
        return edges;
      }
    }

    public static class EdgeImpl implements Edge {
      private int weight;
      private final GNode from;
      private final GNode to;

      public EdgeImpl(int weight, GNode from, GNode to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
      }

      @Override
      public int weight() {
        return weight;
      }

      @Override
      public GNode from() {
        return from;
      }

      @Override
      public GNode to() {
        return to;
      }

      @Override
      public void weight(int w) {
        this.weight = w;
      }
    }

    @Override
    public void addNode(int node) {
      if(exists(node)) return;
      nodes.put(node, new GNodeImpl(node,0,0, new ArrayList<>(), new ArrayList<>()));
    }

    @Override
    public void addEdge(int from, int to) {
      GNode fnode, tnode;
      if(Objects.isNull(fnode = getNode(from))) 
        throw new RuntimeException(String.format("%d node not exists", from));  
      if(Objects.isNull(tnode = getNode(to))) 
        throw new RuntimeException(String.format("%d node not exists", to));  
      List<Edge> fromEdges = edges.computeIfAbsent(from, key -> new ArrayList<>());
      EdgeImpl edge = null;
      fromEdges.add(edge = new EdgeImpl(1, getNode(from), getNode(to)));
      fnode.nexts().add(tnode);
      fnode.edges().add(edge);
    }

    public boolean exists(int node) {
      return nodes.containsKey(node);
    }

    private GNode getNode(int val){
      return nodes.get(val);
    }
  }
  
}
