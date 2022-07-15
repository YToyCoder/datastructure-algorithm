package com.learn.algorithms.leetcode.medium;

public class Intersect {
  
  public Node intersect(Node quadTree1, Node quadTree2) {
    if(quadTree1.isLeaf) {
      return quadTree1.val ? 
      new Node(true, true, null,null,null,null) : 
      new Node(quadTree2.val, quadTree2.isLeaf, quadTree2.topLeft, quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight);
    }
    if(quadTree2.isLeaf) 
    // 反转到 quadTree1.isLeaf
      return intersect(quadTree2, quadTree1);
    // not leaf
    Node tl = intersect(quadTree1.topLeft, quadTree2.topLeft);
    Node tr = intersect(quadTree1.topRight, quadTree2.topRight);
    Node bl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
    Node br = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
    return tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && tl.val == tr.val && tr.val == bl.val && bl.val == br.val ? 
    new Node(tl.val, true, null, null, null, null) :
    new Node(false, false, tl, tr, bl, br);
  }

  static class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
}
