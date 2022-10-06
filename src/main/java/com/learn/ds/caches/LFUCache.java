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

  @Override
  public V get(K key) {
    // return map.get(key);
    return Optional.of(map.get(key))
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
      size--;
    }
    append(key, val);
    size++;
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
    return tail_value;
  }

  private void move_forward(Node<K,V> node){
    while(
      !Objects.equals(node, queue_head) || 
      node.head.frequent <= node.frequent
    ){

      var pre = node.head;
      var pp = pre.head;
      // pp -> pre -> node -> next
      // pp -> node -> pre -> next
      // two cases
      // case 1 pre is queue_head
      // case 2 pre not queue_head

      // common ops
      pre.tail = node.tail;
      node.tail.head = pre;
      pre.head = node;
      node.tail = pre;

      if(pre == queue_head /* case 1 */){
        queue_head = node;
        node.head = null;
      }else { /* case 2 */
        node.head = pp;
        pp.tail = node;
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
    }
    map.put(key, queue_tail);
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

    public Node(K key, V _value, Node<K, V> _head, Node<K, V> _tail){
      value = _value;
      head = _head;
      tail = _tail;
      frequent = 0;
    }

  }
}
