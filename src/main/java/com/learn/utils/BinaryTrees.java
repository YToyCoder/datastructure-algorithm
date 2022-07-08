package com.learn.utils;

import java.util.Objects;

public class BinaryTrees {
  private BinaryTrees(){}

  public static class BinaryTreeNode<K, V> extends Node<K> {
    public V val;
    public BinaryTreeNode<K,V> left;
    public BinaryTreeNode<K,V> right;
    public BinaryTreeNode<K,V> parent;
  
    public BinaryTreeNode(K key, V val, BinaryTreeNode<K, V> left, BinaryTreeNode<K, V> right, BinaryTreeNode<K,V> parent) {
      super(key);
      this.val = val;
      this.left = left;
      this.right = right;
      this.parent = parent;
    }
  
    public BinaryTreeNode(K key, V val){
      this(key, val, null, null, null);
    }
  }



  public static <K,V> boolean isLeft(BinaryTreeNode<K,V> parent, BinaryTreeNode<K,V> child){
    return isChild(parent, child) && Objects.equals(parent.left, child);
  }

  public static <K,V> boolean isRight(BinaryTreeNode<K,V> parent, BinaryTreeNode<K,V> child){
    return isChild(parent, child) && Objects.equals(parent.right, child);
  }

  public static <K,V> boolean isChild(BinaryTreeNode<K,V> parent, BinaryTreeNode<K,V> child){
    return Objects.nonNull(parent) && 
           Objects.nonNull(child) &&
           (Objects.equals(parent.left, child) || Objects.equals(parent.right, child));
  }

  static <K,V> boolean hasChild(BinaryTreeNode<K,V> node){
    return Objects.nonNull(node) && (Objects.nonNull(node.left) || Objects.nonNull(node.right));
  }

  public static abstract class BinaryTreeHelper<K extends Comparable<K>,V>{
    protected int size = 0;

    protected boolean isRoot(BinaryTreeNode<K,V> node){
      return Objects.equals(node, root());
    }
    protected abstract void setRoot(BinaryTreeNode<K,V> node);
    protected abstract BinaryTreeNode<K,V> root();

    protected void rightRotate(BinaryTreeNode<K,V> r){
      final BinaryTreeNode<K,V> leftChild = r.left;
      // 
      r.left = leftChild.right;
      if(Objects.nonNull(leftChild.right))
        leftChild.right.parent = r;
      final BinaryTreeNode<K,V> parent = r.parent;
      if(isRoot(r)) setRoot(leftChild);
      else if(isLeft(parent, r)) parent.left = leftChild;
      else parent.right = leftChild;
      // set parent
      leftChild.parent = parent;
      leftChild.right = r;
      r.parent = leftChild;
    }

    protected void leftRotate(BinaryTreeNode<K,V> r){
      final BinaryTreeNode<K,V> rightChild = r.right;
      r.right = rightChild.left;
      if(Objects.nonNull(rightChild.left))
        rightChild.left.parent = r;
      final BinaryTreeNode<K,V> parent = r.parent;
      if(isRoot(r)) setRoot(rightChild);
      else if(isLeft(parent, r)) parent.left = rightChild;
      else parent.right = rightChild;
      rightChild.parent = parent;
      rightChild.left = r;
      r.parent = rightChild;
    }

    protected static class InsertNodeAndOldValue<K,V> {
      public BinaryTreeNode<K,V> node;
      public V old;

      public InsertNodeAndOldValue(BinaryTreeNode<K,V> node, V old) {
        this.node = node;
        this.old = old;
      }

    }


    /**
     * 插入k-v，并返回插入的节点，如果key对应的节点已存在就替换旧值并且一起返回
     * @param key
     * @param val
     * @return {@code InsertNodeAndOldValue}
     */
    protected InsertNodeAndOldValue<K,V> binaryInsert(K key, V val){
      BinaryTreeNode<K,V> node = find(key);
      if(Objects.isNull(node)){
        // empty
        setRoot((node = new BinaryTreeNode<>(key, val)));
        size++;
      }
      final var ans = new InsertNodeAndOldValue<>(node, null);
      if(node.getKey().compareTo(key) == 0){
        ans.old = node.val;
        node.val = val;
      }else {
        // node need to insert
        final BinaryTreeNode<K,V> created = new BinaryTreeNode<>(key, val, null, null, node);
        if(key.compareTo(node.getKey()) > 0 ) node.right = created;
        else node.left = created;
        ans.node = created;
        size++;
      }
      return ans;
    }

    /**
     * 找到{@code BinaryTreeNode<K,V>}的key值等于或大于{@code key}的节点
     * @param key
     * @return 如果没有找到就返回null，找到就返回
     */
    protected BinaryTreeNode<K,V> find(K key) {
      // 只有当tree是空（root为null）才会找不到
      BinaryTreeNode<K,V> walk = root();
      if(Objects.isNull(walk)) return null;
      while(
        /*
         * 继续查找的条件:
         * key不相等 有子节点 下一步走到的子节点不为null
         */
        walk.getKey().compareTo(key) != 0 && 
        hasChild(walk) && 
        walk.getKey().compareTo(key) > 0 ? Objects.nonNull(walk.right) : Objects.nonNull(walk.left)
      ){
        walk = walk.getKey().compareTo(key) > 0 ? walk.right : walk.left;
      }
      return walk;
    }
  }
  
}
