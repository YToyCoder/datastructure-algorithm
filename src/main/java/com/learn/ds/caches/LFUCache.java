package com.learn.ds.caches;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * LFU算法（Last Frequently Used）
 * 要求：get 和 put 操作, 时间复杂度O(1)

LFU算法的设计原则：
1）put 和 get 操作，都算是使用，freq计数都得加1
2）如果达到容量限制，移除freq最小的那个Cache
3）移除时，如果有多个Cache的freq相同，那么移除最久未使用的那个（LRU）

 */

public class LFUCache<K,V> implements Cache<K,V>{
  private final int capacity;
  private int size = 0;
  // priority queue
  private Node<K, V> queue_head = null; 
  private Node<K, V> queue_tail = null; 
  // quick get
  private Map<K, Node<K,V>> map = new HashMap<>();

  public LFUCache(int _capacity){
    capacity = _capacity;
  }

  public static <K,V> LFUCache<K,V> create(int capacity){
    return new LFUCache<>(capacity);
  }

  @Override
  public V get(K key) {
    // return map.get(key);
    return Optional.ofNullable(map.get(key))
    .map(node -> {
      if(Objects.nonNull(node)){
        node.frequent++;
        move_forward(node);
        return node.value;
      }
      return null;
    })
    .orElse(null);
  }

  @Override
  public V put(K key, V val) {
    V res = null;
    if(size == capacity) {
      res = remove_tail();
    }
    append(key, val);
    return res;
  }

  private V remove_tail(){
    if(size == 0) 
      return null;
    V tail_value = queue_tail.value;
    map.remove(queue_tail.key);
    if(size == 1){
      queue_head = queue_tail = null;
    }else { /* size > 1 */
      // drop tail
      queue_tail = queue_tail.head;
      queue_tail.tail = null;
    }
    size--;
    return tail_value;
  }

  private void move_forward(Node<K,V> node){
    if(size > 1){
      Node<K,V> head2insert = node.head;
      while(
        Objects.nonNull(head2insert) && 
        head2insert.frequent <= node.frequent
      ) head2insert = head2insert.head;

      if(!Objects.equals(head2insert, node.head) /* head2insert not head */){
        // break chain
        //head can't be null
        var head = node.head;
        if(node == queue_tail){
          queue_tail = head;
        }
        node.head = null;
        head.tail = node.tail;
        if(Objects.nonNull(node.tail)){
          var tail = node.tail;
          tail.head = head;
          node.tail = null;
        }

        // link head #todo
        if(Objects.nonNull(head2insert)){
          // insert
          var tail2add = head2insert.tail;
          head2insert.tail = node;
          node.head = head2insert;
          node.tail = tail2add;
          if(Objects.nonNull(tail2add)){
            tail2add.head = node;
          }
        }else {
          // append to head
          node.tail = queue_head;
          queue_head.head = node;
          queue_head = node;
        }
      }
    } 
  }
  /**
   * just append, not do other checking things
   * @param key
   * @param val
   */
  private void append(K key, V val){
    if(size == 0){
      queue_head = queue_tail = new Node<K, V>(key, val, null, null);
    }else {
      queue_tail = new Node<>(key, val, queue_tail, null);
      queue_tail.head.tail = queue_tail;
    }
    map.put(key, queue_tail);
    size++;
  }

  /**
   * node
   */
  private static class Node<K,V> {

    Node<K,V> head;
    Node<K,V> tail;

    K key;
    V value;
    int frequent;

    public Node(K _key, V _value, Node<K, V> _head, Node<K, V> _tail){
      value = _value;
      head = _head;
      tail = _tail;
      frequent = 0;
      key = _key;
    }

  }
}
