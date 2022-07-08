package com.learn.utils;

public class Node<K> {
  private K key;

  public Node(K key){
    this.key = key;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }
}
