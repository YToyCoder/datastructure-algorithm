package com.learn.ds.tree;

import java.util.Objects;

/**
 * <p>线段树
 * <p>求区间元素总和
 */
public class IntervalTree {
  private int[] tree;
  private int[] lazy_mark;

  void build(int[] source){
    tree = new int[source.length + 1];
    traversal(1, source.length, 1, source);
  }

  int traversal(int left, int right, int node,int[] source){
    if(left == right){
      tree[left] = source[left];
      return source[left];
    }
    int medium = left + (right - left) >> 1;
    int leftSum = traversal(left, medium, node * 2, source);
    int rightSum = traversal(medium + 1, right, node * 2 + 1, source);
    tree[node] = leftSum + rightSum;
    return tree[node];
  }

  public void update(int left, int right, int val){
    if(Objects.isNull(lazy_mark)) lazy_mark = new int[tree.length];
  }

  void doUpdate(int left, int right, int reachLeft, int reachRight, int node, int val){
  }

  public int query(int left, int right){
    return doQuery(left, right, 1, tree.length, 1);
  }

  /*
   * 0 1 2 
   * 0 * 2 + 1 || 0 * 2 + 2
   */
  // 
  int doQuery(int left, int right, int reachLeft, int reachRight, int node){
    if(right < reachLeft || left > reachRight) return -1;
    if(left <= reachLeft && right <= reachRight) return tree[node];
    final int mid = (reachLeft + reachRight) >> 1; // 分界位置
    handleMark(node, reachRight - reachLeft + 1);
    return (left <= mid ? doQuery(left, right, reachLeft, mid, node * 2) : 0) + 
           (right > mid ? doQuery(left, right, mid + 1, reachRight, node * 2 + 1) : 0);
  }

  // 加载懒标记
  void handleMark(final int node, final int length){
    lazy_mark[node * 2] += lazy_mark[node];
    lazy_mark[node * 2 + 1] += lazy_mark[node];
    tree[node * 2] += lazy_mark[node] * (length - length/2);
    tree[node * 2 + 1] += lazy_mark[node] * (length/2);
    lazy_mark[node] = 0;
  }

}
