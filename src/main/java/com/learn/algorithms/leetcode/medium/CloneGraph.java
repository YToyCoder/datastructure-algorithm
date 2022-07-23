package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Map;

public class CloneGraph {
  

  Map<Node,Node> visited = new HashMap<>();
  public Node cloneGraph(Node node) {
    return traversal(node);
  }

  Node traversal(Node node){
    if(Objects.isNull(node)) return node;
    Node ans;
    if(Objects.isNull(ans = visited.get(node))){
      ans = new Node(node.val);
      visited.put(node, ans);
      for(Node nb : node.neighbors){
        ans.neighbors.add(traversal(nb));
      }
    } 
    return ans;
  }


  static class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
  }
}
