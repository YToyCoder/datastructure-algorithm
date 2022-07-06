package com.learn.ds.tree;

import java.util.Objects;

public class RBTree<K extends Comparable<K>> {
  public static class Node<K> {
    private K key;
    private Node<K> parent;
    private Node<K> left;
    private Node<K> right;
    private Color color;
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

  public boolean exists(K key){
    return Objects.nonNull(bstreeSearch(key));
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
    }
    else insertHelper(root, new Node<>(key, null, null, null, Color.Red));
    size++;
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
    if(isBlack(node.parent))
      return; // parent is Black do nothing
    final Node<K> grandfather = node.parent.parent;
    final Node<K> uncle = isLeft(grandfather, node.parent) ?  grandfather.right : grandfather.left;
    if(isRed(uncle)) {
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
        setBlack(node);
        setRed(parent);
        rightRotate(parent);
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
    if(Objects.nonNull(rightChild.left))
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
    // null is black
    if(Objects.nonNull(node))
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

  /**
   * delete node which key is the {@code key}
   * @param key 
   * @return if remove return true, else return false
   */
  public boolean remove(K key){
    Node<K> searchNode = bstreeSearch(key);
    if(Objects.isNull(searchNode)) return false;
    size--;
    // find the node to delete
    final Node<K> minOfRmNodeLeftTree = minOf(searchNode.right);
    // not root
    final Node<K> nodeDel = Objects.isNull(minOfRmNodeLeftTree) ? searchNode : minOfRmNodeLeftTree;
    if(isRoot(nodeDel)){ // handle root isolate
      final Node<K> leftOfNodeDel = nodeDel.left;
      root = leftOfNodeDel;
      if(Objects.nonNull(leftOfNodeDel)) leftOfNodeDel.parent = null;
      nodeDel.left = null;
      return true;
    }
    if(Objects.nonNull(minOfRmNodeLeftTree)){
      // replace key
      searchNode.key = minOfRmNodeLeftTree.key;
    }
    final boolean delNodeIsBlack = isBlack(nodeDel) ;
    final boolean replaceNIsBlack = isBlack(nodeDel.left) ;
    final Node<K> sibling = nodeDel.parent.right;

    bstreeDel(nodeDel);
    if(!delNodeIsBlack || !replaceNIsBlack){
      /**
       * case :
       * 
       *    d(black)
       *   /
       *  ?(red)
       * just delete && recolor
       */
      setBlack(nodeDel.left);
    }else {
      // both black
      /**
       * case 1: sibling is black and sibling has at least one red child
       */
      if(isBlack(sibling) && hasRedChild(sibling)){
        // 3 case :
        // case 1 : two red children >> left rotate && recolor(set sibling right black)
        if(isRed(sibling.left) && isRed(sibling.right)){
          leftRotate(sibling.parent);
          setBlack(sibling.right);
        }
        // case 2 : one left child >> right rotate && left rotate && recolor
        if(isBlack(sibling.right)){
          setBlack(sibling.left);
          final Node<K> siblingParent = sibling.parent;
          rightRotate(sibling);
          leftRotate(siblingParent);
        }
        // case 3 : one right child >> left rotate && recolor
        if(isBlack(sibling.left)){
          leftRotate(sibling.parent);
          setBlack(sibling.right);
        }
      }
    }
    return true;
  }

  /**
   * get the min node of subtree which root is {@code r}
   * @param r subtree's root
   * @return min node of r, if not exists return null
   */
  private Node<K> minOf(final Node<K> r){
    if(Objects.isNull(r)) return null;
    Node<K> walk = r;
    while(Objects.nonNull(walk.left)) walk = walk.left;
    return walk;
  }

  // if a node has at least one red child
  private boolean hasRedChild(final Node<K> node){
    return Objects.nonNull(node) && (isRed(node.left) || isRed(node.right));
  }


  /**
   * perfrom the binary search tree deletion
   * @param {@code Node} node to delete
   */
  private void bstreeDel(Node<K> nodeDel){
    // it a leaf or a node with single child
    
    /**
     *      nodeDel
     *      /    \
     *    null   ?(may exist)
     */
    // nodeDel will not be the root @see #remove
    final Node<K> parent = nodeDel.parent;
    if(isLeft(parent, nodeDel)) parent.left = nodeDel.right;
    else parent.right = nodeDel.right;
    if(Objects.nonNull(nodeDel.right)) nodeDel.right.parent = parent;
    // not neccessary
    nodeDel.parent = null;
    nodeDel.right = null;
  }

  /**
   * search the node which key is {@code key}
   * @param key search key
   * @return search result , if exist return ,else return null;
   */
  private Node<K> bstreeSearch(K key){
    if(size() == 0) return null;
    Node<K> walk = Objects.requireNonNull(root);
    while(Objects.nonNull(walk) && walk.key.compareTo(key) != 0){
      walk = walk.key.compareTo(key) > 0 ? walk.left : walk.right;
    }
    return walk;
  }

  private boolean isRed(Node<K> node){
    return Objects.nonNull(node) && Objects.equals(node.color, Color.Red);
  }

  private boolean isBlack(Node<K> node){
    return Objects.isNull(node) || Objects.equals(node.color, Color.Black);
  }
}
