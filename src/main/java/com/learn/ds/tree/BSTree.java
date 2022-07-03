package com.learn.ds.tree;

import com.learn.utils.Pair;
import java.util.Objects;
/**
  * <p> binary search tree is a simple tree has no more than two child, 
  * called left child and right child
  * <p>the left child is less than parent and right child is greeter than parent
              root
          /          \
      left            right
      /   \           /   \
  left    right   left    right
*/
public class BSTree<K extends Comparable<K>, V> {
  private int size = 0;
  private Node<K, V> root;

  public static class Node<K, V> {
    private K key;
    private V val;
    private Node<K, V> parent;
    private Node<K, V> left;
    private Node<K, V> right;

    public Node(K key, V val, Node<K, V> parent, Node<K, V> left, Node<K, V> right) {
      this.key = key;
      this.val = val;
      this.parent = parent;
      this.left = left;
      this.right = right;
    }

    public Node(K key, V val) {
      this.key = key;
      this.val = val;
    }
  

  }

  public BSTree() {
    this.root = null;
  }

  /*
   * find node of key and it's parent, if not find node, set it as null, and set parent as leaf node which it should add {@code key}
   */
  private Pair<Node<K,V>, Node<K,V>> findParentAndNode(K key){
    if(Objects.isNull(root)) return null;
    if(root.key.compareTo(key) == 0) 
      return new Pair<BSTree.Node<K,V>,BSTree.Node<K,V>>(null, root);
    var parent = root;
    var node = root.key.compareTo(key) > 0 ? root.left : root.right;
    // node不为空且key不相等时继续搜索
    while(Objects.nonNull(node) && node.key.compareTo(key) != 0){
      parent = node;
      node = node.key.compareTo(key) > 0 ? node.left : node.right;
    }
    return new Pair<BSTree.Node<K,V>,BSTree.Node<K,V>>(parent, node);
  }


  /**
   * 将key，value组成键值对放入树, 如果存在key对应的值，返回原有的值并将key,value放入tree,否则返回null
   * @param key 关键词
   * @param value 值
   * @return {@link V} key原本对应的value, 或null
   */
  public V put(final K key, final V value){
    final var findParentAndNode = findParentAndNode(key);
    if(Objects.isNull(findParentAndNode)) {
      // empty
      this.root = new Node<>(key, value, null, null, null);
      size++;
    }else if(Objects.isNull(findParentAndNode._1)){
      // it's root
      if(!Objects.equals(root, findParentAndNode._2)) throw new RuntimeException("this should not happen");
      // just replace value
      final var old = root.val;
      root.val = value;
      return old;
    }else if(Objects.isNull(findParentAndNode._2)){
      // not appear
      final var parent = findParentAndNode._1;
      final var newNode = new Node<K,V>(key, value, parent, null, null);
      if(parent.key.compareTo(key) > 0){
        parent.left = newNode;
      }else{
        parent.right = newNode;
      }
      size++;
    }else {
      // repeatting
      // just replace value
      final var node = findParentAndNode._2;
      final var old = node.val;
      node.val = value;
      return old;
    }
    return null;
  }

  /**
   * 删除key对应的节点, 如果该节点不存在直接返回null，存在则返回删除节点的val
   * @param key key值
   * @return {@link V} key 对应的 value
   */
  public V remove(final K key){
    final var findParentAndNode = findParentAndNode(Objects.requireNonNull(key));
    // 空树或无节点
    if(Objects.isNull(findParentAndNode) || Objects.isNull(findParentAndNode._2)) return null;
    else { // 存在节点
      final var node = findParentAndNode._2;
      final var parent = findParentAndNode._1;
      var leftMax = findMaxOf(node.left);
      Node<K,V> nodeToReplace = null;
      if(Objects.nonNull(leftMax)){
        // left max
        /**
         *        root
         *       /    \
         *    left    right
         *   /    \
         * left   leftMax
         *       /
         *     leftMaxleft
         * 
         *        ||
         *        \/
         * 
         *        leftMax
         *       /       \
         *     left       right
         *    /    \
         * left     leftMaxleft
         */
        // switch left
        final var parentOfLeftMax = leftMax.parent;
        if(Objects.equals(parentOfLeftMax.left, leftMax)){
          parentOfLeftMax.left = leftMax.left;
        }else{
          parentOfLeftMax.right = leftMax.left;
        }
        nodeToReplace = leftMax;
      }else{
        // right min
        /**
         *      root
         *     /    \
         *   null   right
         *          /   \
         *        left   right
         *        /
         *     minLeft
         *        \
         *     minLeftRight
         * 
         *     ||
         *     \/
         * 
         *      minLeft
         *     /       \
         *   null     right
         *            /   \
         *         left   right
         *         /
         *   minLeftRight
         */
        // switch right
        final var minRight = findMinOf(node.right); // 不可能为null
        if(!Objects.isNull(minRight)){
          // it's not leaf
          final var parentOfMinRight = minRight.parent;
          if(Objects.equals(parentOfMinRight.left, minRight)) parentOfMinRight.left = minRight.right;
          else parentOfMinRight.right = minRight.right;
        }
        nodeToReplace = minRight;
      }
      // replace node
      size--;
      if(Objects.nonNull(nodeToReplace)){
        nodeToReplace.parent = parent;
        nodeToReplace.right = node.right;
        nodeToReplace.left = node.left;
      }
      if(!Objects.isNull(parent)){
        if(Objects.equals(parent.left, node)) parent.left = nodeToReplace;
        else parent.right = nodeToReplace;
      }else{
        // it's root
        root = nodeToReplace;
      }
      return node.val;
    }
  }

  /**
   * 获取以入参{@code root} 为根节点的树的最大值节点, 如果根节点{@code root}为空直接返回null
   * @param root 代表的查找树的根节点
   * @return {@link Node} 对于入参root结构树里面的最大值
   */
  private Node<K,V> findMaxOf(final Node<K,V> root){
    if(Objects.isNull(root)) return null;
    var walk = root;
    while(Objects.nonNull(walk.right)){
      walk =walk.right;
    }
    return walk;
  }

  /**
   * 获取以入参{@code root} 为根节点的树的最小值节点， 如果根节点{@code root}为{@code null}为直接返回null
   * @param root
   * @return {@link Node} 对于入参root结构树里面的最小值
   */
  private Node<K,V> findMinOf(final Node<K,V> root){
    if(Objects.isNull(root)) return null;
    var walk = root;
    while(Objects.nonNull(walk.left)){
      walk = walk.left;
    }
    return walk;
  }

  /**
    * find the val node's parent if node exists just find it, 
    * else if val is equals root, return null
    * else  find the leaf to insert
    */
  private Node<K,V> find(K key) {
    final var parentAndNode = findParentAndNode(key);
    return (Objects.isNull(parentAndNode) || Objects.isNull(parentAndNode._2)) ? null : parentAndNode._2;
  }

  /**
   * 获取key对应的值, 如果存在则返回该值,否则返回null
   * @param key {@link K}
   * @return {@link V} key对应的值或null
   */
  public V get(K key){
    final var node = find(key);
    return Objects.isNull(node) ? null : node.val;
  }

  public int size(){
    return size;
  }

}
