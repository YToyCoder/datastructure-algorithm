package com.learn.ds.tree;

import com.learn.utils.BinaryTrees.BinaryTreeHelper;
import com.learn.utils.BinaryTrees.BinaryTreeNode;

public class AVLTree<K extends Comparable<K>,V> extends BinaryTreeHelper<K,V>{
  private BinaryTreeNode<K,V> root;

  /**
   * AVL tree insertion
   * @param key
   * @param val
   */
  public void insert(final K key, final V val){
    final InsertNodeAndOldValue<K,V> insertNodeAndOldValue = binaryInsert(key, val);
    // do rotate
  }

  @Override
  protected void setRoot(BinaryTreeNode<K, V> node) {
    this.root = node;
  }

  @Override
  protected BinaryTreeNode<K, V> root() {
    return root;
  }
}
