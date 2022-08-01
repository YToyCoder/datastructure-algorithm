package com.learn.algorithms.leetcode.medium;

public class Construct {
  
  public Node construct(int[][] grid) {
    return build(grid, 0, 0, grid.length);
  }

  Node build(int[][] grid, int row, int col, int size){
    if(size == 1) return new Node(grid[row][col] == 1, true);
    final int subsize = size / 2;
    final Node topleft = build(grid, row, col, subsize);
    final Node topright = build(grid, row, col + subsize, subsize);
    final Node bottomleft = build(grid, row + subsize, col, subsize);
    final Node bottomright = build(grid, row + subsize, col + subsize, subsize);
    return topleft.val == topright.val && topleft.val == bottomleft.val && topleft.val == bottomright.val && 
           topleft.isLeaf && topright.isLeaf && bottomleft.isLeaf && bottomright.isLeaf
           ? 
           new Node(topleft.val, true) :
           new Node(topleft.val, false, topleft, topright, bottomleft, bottomright);
  }

  static class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
  }
}
