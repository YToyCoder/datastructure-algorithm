package com.learn.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class LargestComponentSize {
  
  public int largestComponentSize(int[] nums) {
    Map<Integer,Node> nodes = new HashMap<>();
    for(int el : nums){
      Node elNode = new Node(el, new ArrayList<>());
      boolean hasCommonFactor = false;
      for(Map.Entry<Integer, Node> node : nodes.entrySet()){
        for(int factor : node.getValue().factors){
          if(el % factor == 0){
            elNode.surrounds.add(node.getKey());
            node.getValue().surrounds.add(el);
            hasCommonFactor = true;
            break;
          }
        }
        if(!hasCommonFactor){
          int commonFactor = gcd(el, node.getKey());
          if(commonFactor > 1){
            elNode.surrounds.add(node.getKey());
            node.getValue().surrounds.add(el);
            elNode.factors.add(commonFactor);
            node.getValue().factors.add(el);
          }
        }
        hasCommonFactor = false;
      }
      nodes.put(el, elNode);
    }
    int max = Integer.MIN_VALUE;
    for(Node point : nodes.values()){
      if(point.color == white){
        int size = bfTraverse(point, nodes);
        if(size > max) max = size;
      }
    }
    return max;
  }

  int bfTraverse(Node start, Map<Integer,Node> nodes){
    setColor(start, gray);
    Queue<Node> toVisitChildren = new LinkedList<>();
    toVisitChildren.offer(start);
    int size = 1;
    while(!toVisitChildren.isEmpty()){
      final Node curNode = toVisitChildren.poll();
      Node surroundNode;
      for(final int surround : curNode.surrounds){
        surroundNode = nodes.get(surround);
        if(surroundNode.color == white){
          setColor(surroundNode, gray);
          toVisitChildren.add(surroundNode);
          size++;
        }
      }
      setColor(curNode, black);
    }
    return size;
  }

  static void setColor(Node node, int color){
    node.color = color;
  }

  static int white = 0;
  static int gray = 1;
  static int black = 2;

  static class Node{
    int val;
    List<Integer> factors;
    List<Integer> surrounds;
    int color = white;
    public Node(final int v, final List<Integer> surrounds){
      this.val = v;
      this.surrounds = surrounds;
      this.factors = new LinkedList<>();
    }
  }

  int gcd(int a, int b){
    return a == 0 ? b : a > b ? 
      gcd(a % b, b) : 
      gcd(b % a, a);
  }
}
