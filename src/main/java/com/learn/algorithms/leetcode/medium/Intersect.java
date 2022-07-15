package com.learn.algorithms.leetcode.medium;

import java.util.Objects;

public class Intersect {
  
  public Node intersect(Node quadTree1, Node quadTree2) {
    if(Objects.isNull(quadTree1) || Objects.isNull(quadTree2)) 
      return Objects.isNull(quadTree1) ? quadTree2 : quadTree1;
    final Node ans = new Node();
    final int t = v(quadTree1, quadTree2, ans);
    return ans;
  }

  /**
   * @param quadTree1
   * @param quadTree2
   * @param walk (not null)
   */
  private void visit(Node quadTree1, Node quadTree2, Node walk){
    walk.val = Objects.nonNull(quadTree1) && Objects.nonNull(quadTree2) ? 
      quadTree1.val | quadTree2.val : Objects.isNull(quadTree1) ? 
      quadTree2.val : 
      quadTree1.val;
    walk.isLeaf = Objects.nonNull(quadTree1) && Objects.nonNull(quadTree2) ? 
      quadTree1.isLeaf & quadTree2.isLeaf : Objects.isNull(quadTree1) ?
      quadTree2.isLeaf : quadTree2.isLeaf;
    if((Objects.nonNull(quadTree1) && Objects.nonNull(quadTree1.bottomLeft)) || 
       (Objects.nonNull(quadTree2) && Objects.nonNull(quadTree2.bottomLeft))
    ) {
      walk.bottomLeft = new Node();
      visit(quadTree1.bottomLeft, quadTree2.bottomLeft, walk.bottomLeft);
    }
    if((Objects.nonNull(quadTree1) && Objects.nonNull(quadTree1.bottomRight)) || 
       (Objects.nonNull(quadTree2) && Objects.nonNull(quadTree2.bottomRight))
    ) {
      walk.bottomRight = new Node();
      visit(quadTree1.bottomRight, quadTree2.bottomRight, walk.bottomRight);
    }
    if((Objects.nonNull(quadTree1) && Objects.nonNull(quadTree1.topLeft)) || 
       (Objects.nonNull(quadTree2) && Objects.nonNull(quadTree2.topLeft))
    ) {
      walk.topLeft = new Node();
      visit(quadTree1.topLeft, quadTree2.topLeft, walk.topLeft);
    }
    if((Objects.nonNull(quadTree1) && Objects.nonNull(quadTree1.topRight)) || 
       (Objects.nonNull(quadTree2) && Objects.nonNull(quadTree2.topRight))
    ) {
      walk.topRight = new Node();
      visit(quadTree1.topRight, quadTree2.topRight, walk.topRight);
    }
  }

  private int v(Node quadTree1, Node quadTree2, Node walk){
    walk.val = Objects.nonNull(quadTree1) && Objects.nonNull(quadTree2) ? 
      quadTree1.val | quadTree2.val : Objects.isNull(quadTree1) ? 
      quadTree2.val : 
      quadTree1.val;
    walk.isLeaf = Objects.nonNull(quadTree1) && Objects.nonNull(quadTree2) ? 
      quadTree1.isLeaf & quadTree2.isLeaf : Objects.isNull(quadTree1) ?
      quadTree2.isLeaf : quadTree2.isLeaf;
    int bl = -1, br = -1, tl = -1, tr = -1;
    if((Objects.nonNull(quadTree1) && Objects.nonNull(quadTree1.bottomLeft)) || 
       (Objects.nonNull(quadTree2) && Objects.nonNull(quadTree2.bottomLeft))
    ) {
      walk.bottomLeft = new Node();
      bl = v(quadTree1.bottomLeft, quadTree2.bottomLeft, walk.bottomLeft);
    }
    if((Objects.nonNull(quadTree1) && Objects.nonNull(quadTree1.bottomRight)) || 
       (Objects.nonNull(quadTree2) && Objects.nonNull(quadTree2.bottomRight))
    ) {
      walk.bottomRight = new Node();
      br = v(quadTree1.bottomRight, quadTree2.bottomRight, walk.bottomRight);
    }
    if((Objects.nonNull(quadTree1) && Objects.nonNull(quadTree1.topLeft)) || 
       (Objects.nonNull(quadTree2) && Objects.nonNull(quadTree2.topLeft))
    ) {
      walk.topLeft = new Node();
      tl = v(quadTree1.topLeft, quadTree2.topLeft, walk.topLeft);
    }
    if((Objects.nonNull(quadTree1) && Objects.nonNull(quadTree1.topRight)) || 
       (Objects.nonNull(quadTree2) && Objects.nonNull(quadTree2.topRight))
    ) {
      walk.topRight = new Node();
      tr = v(quadTree1.topRight, quadTree2.topRight, walk.topRight);
    }
    return allZero(bl, br, tl, tr) ? 0 : allOne(bl, br, tl, tr) ? 1 : 0;
  }

  private boolean allZero(int a, int b, int c, int d){
    return a == 0 && b == 0 && c == 0 && d == 0;
  }

  private boolean allOne(int a, int b, int c, int d){
    return a == 1 && b == 1 && c == 1 && d == 1;
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
