package com.learn.ds.tree;

import java.util.Objects;

public class RBTree<K extends Comparable<K>> {
  public static class Node<K> {
    K key;
    Node<K> parent;
    Node<K> left;
    Node<K> right;
    Color color;
    public Node(K key, Node<K> parent, Node<K> left, Node<K> right, Color color) {
      this.key = key;
      this.parent = parent;
      this.left = left;
      this.right = right;
      this.color = color;
    }

  }

  public static enum Color {
    Black,
    Red;
  }

  // the root of tree
  private Node<K> root;
  // tree size
  private int size = 0;

  private boolean exists(K key){
    return true;
  }

  public int size(){
    return size;
  }

  /**
   * 插入key
   * <p> 如果存在直接返回false，如果不存在执行插入操作
   * @param key
   * @return
   */
  public boolean insert(K key) {
    if(exists(key)){
      return false;
    }
    if(Objects.isNull(root)) {
      root = new Node<>(key, null, null, null, Color.Black);
      size++;
    }
    else insertHelper(root, new Node<>(key, null, null, null, Color.Red));
    return true;
  }


  private void insertHelper(Node<K> r, Node<K> node){
    // do insert like binary search tree
    // do not include the root insert , root insert in {@code insert}
    Node<K> parentForInsert = Objects.requireNonNull(r);
    final K insertKey = node.key;
    // find the insert parent
    while(Objects.nonNull(
      parentForInsert.key.compareTo(insertKey) > 0 ? parentForInsert.left : parentForInsert.right
    )) {
      parentForInsert = parentForInsert.key.compareTo(insertKey) > 0 ? parentForInsert.left : parentForInsert.right;
    }
    if(insertKey.compareTo(parentForInsert.key) > 0) parentForInsert.right = node;
    else parentForInsert.left = node;
    node.parent = parentForInsert;
    // do balancing
    balancing(node);
  }


  /**
   * balance after insert {@code RBTree#insertHelper(Node, Node)}
   * @param root 插入的根节点
   * @param node 需要balance的节点
   */
  private void balancing(Node<K> node) {
    if(Objects.equals(root, node)) root.color = Color.Black;
    if(node.parent.color.equals(Color.Black)) 
      return; // parent is Black do nothing
    final Node<K> grandfather = node.parent.parent;
    final Node<K> uncle = isLeft(grandfather, node.parent) ?  grandfather.right : grandfather.left; 
    if(uncle.color.equals(Color.Red)) {
      uncle.color = Color.Black;
      node.parent.color = Color.Black;
      grandfather.color = Color.Red;
      balancing(grandfather);
    }else{
      // 4 case
      // 1 LLCase
      if(isLeft(grandfather, node.parent) && isLeft(node.parent, node)){
        /**
         * case example:
         *                G
         *               / \
         *              P   U
         *             / \
         *            X   ?
         * 
         *               ||
         *               \/
         * 
         *                P
         *               / \
         *              X   G
         *                 / \
         *                ?   U
         *
         */
        // set color
        setBlack(node.parent);
        setRed(grandfather);
        // rotate
        rightRotate(grandfather);

      }else if(isLeft(grandfather, node.parent) && !isLeft(node.parent, node)){
        /**
         * case example:
         *                G
         *               / \
         *              P   U
         *             / \
         *            ?   X
         * 
         *               ||
         *               \/
         * 
         *                G
         *               / \
         *              X   U
         *             / \
         *            P   ?
         * 
         *               ||
         *               \/
         * 
         *                X
         *               / \
         *              P   G
         *                 / \
         *                ?   U
         *
         */
        final Node<K> parent = node.parent;
        //rotate
        leftRotate(node.parent);
        balancing(parent);
      }else if(!isLeft(grandfather, node.parent)){
        /**
         * case example:
         *                G
         *               / \
         *              U   P
         *                 / \
         *                ?   X
         * 
         *               ||
         *               \/
         * 
         *                P
         *               / \
         *              G   X
         *             / \
         *            U   ?
         *
         */
        // set color 
        setBlack(node.parent);
        setRed(grandfather);
        // rotate
        leftRotate(grandfather);
      }else {
        /**
         * case example:
         *                G
         *               / \
         *              U   P
         *                 / \
         *                X   ?
         *  
         *               ||
         *               \/
         * 
         *                G
         *               / \
         *              U   X
         *                 / \
         *                ?   P
         *
         *               ||
         *               \/
         * 
         *                X
         *               / \
         *              G   P
         *             / \
         *            U   ?
         *
         */
        final Node<K> parent = node.parent;
        rightRotate(node.parent);
        balancing(parent);
      }
    }
  }

  private boolean isLeft(Node<K> parent, Node<K> child){
    return Objects.equals(parent.left, child);
  }

  /**
   * do the right rotate 
   * @param r root of rotate
   */
  private void rightRotate(Node<K> r){
    final Node<K> leftChild = r.left;
    // 
    r.left = leftChild.right;
    leftChild.right.parent = r;
    final Node<K> parent = r.parent;
    if(isRoot(r)) root = leftChild;
    else if(isLeft(parent, r)) parent.left = leftChild;
    else parent.right = leftChild;
    // set parent
    leftChild.parent = parent;
    leftChild.right = r;
    r.parent = leftChild;
  }

  /***
   * do the left rotate
   * @param r root of rotate
   */
  private void leftRotate(Node<K> r){
    /**
     * case example:
     * 
      *                G
      *               / \
      *              U   P
      *                 / \
      *                ?   X
      * 
      *               ||
      *               \/
      * 
      *                P
      *               / \
      *              G   X
      *             / \   
      *            U   ?   
      *
     */
    final Node<K> rightChild = r.right;
    r.right = rightChild.left;
    rightChild.left.parent = r;
    final Node<K> parent = r.parent;
    if(isRoot(r)) root = rightChild;
    else if(isLeft(parent, r)) parent.left = rightChild;
    else parent.right = rightChild;
    rightChild.parent = parent;
    rightChild.left = r;
    r.parent = rightChild;
  }

  private void setRed(Node<K> node){
    node.color = Color.Red;
  }

  private void setBlack(Node<K> node) {
    node.color = Color.Black;
  }

  /**
   * if a node is root
   * @param node
   * @return 
   */
  private boolean isRoot(Node<K> node){
    return Objects.equals(root, node);
  }
}
