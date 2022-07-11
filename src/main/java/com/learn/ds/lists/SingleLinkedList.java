package com.learn.ds.lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class SingleLinkedList<V> implements Iterable<V> {

  private Node<V> head;
  private Node<V> tail;
  private int size = 0;

  public SingleLinkedList(){
  }

  public static class Node<V> {

    private V val;
    private Node<V> next;

    public Node(V value, Node<V> next) {
      this.val = value;
      this.next = next;
    }

    public Node<V> next(){
      return next;
    }

    public void next(Node<V> n){
      next = n;
    }
  }

  // add in tail
  public void add(V val){
    if(Objects.isNull(head)){
      head = tail = new Node<V>(val, null);
    }else{
      var oldTail = tail;
      tail = new Node<V>(val, null);
      oldTail.next(tail);
    }
    size++;
  }

  public int size() {
    return size;
  }

  public void addAll(Collection<V> collection){
    for(V el : collection){
      add(el);
    }
  }

  // add in head
  public void push(V val) {
    if(Objects.isNull(head)){
      head = tail = new Node<V>(val, null);
    }else{
      var oldHead = head;
      head = new Node<V>(val, oldHead);
    }
    size++;
  }

  public V getFirst(){
    return Objects.isNull(head) ? null : head.val;
  }

  public V getLast() {
    return Objects.isNull(head) ? null : tail.val;
  }

  // remove the head
  public V pop() {
    if(isEmpty()) 
      return null;
    var oldHead = head;
    head = oldHead.next();
    oldHead.next(null);
    size--;
    return oldHead.val;
  }

  // list is empty
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public Iterator<V> iterator() {
    return new Iter(head);
  }

  public class Iter implements Iterator<V> {

    public Iter(Node<V> start){
      this.node = start;
    }

    private Node<V> node;

    @Override
    public boolean hasNext() {
      return Objects.nonNull(node);
    }

    @Override
    public V next() {
      V val = node.val;
      node = node.next();
      return val;
    }
  }
  
}
