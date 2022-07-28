package com.learn.ds.lists;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Objects;

public class Skiplist<T extends Comparable<T>> {
  private static final int MAX_LEVEL = 16;
  private static final Random RANDOM = new Random();
  private Node<T> head;
  
  
  public boolean search(T target) {
    Node<T> ans = head;
    int level = head.height;
    while(level > 0 && Objects.nonNull(ans) && valueCompare( ans, target) != 0){
      if(Objects.isNull( ans.forward[level - 1] )){
        if(level > 0) level--;
        else {
          ans = null;
        }
      } else if(valueCompare(ans.forward[level - 1], target) == 0){
        // should >>> ans = ans.forward[level - 1]
        return true;
      }else if(valueCompare( ans.forward[level - 1], target) < 0){
        level--;
      }else {
        ans = ans.forward[level - 1];
      }
    }
    return Objects.nonNull(ans) && valueCompare(ans, target) == 0;
  }
  
    
  public void add(T num) {
    Node<T>[] updates = new Node[MAX_LEVEL];
    Node<T> walk = head;
    for(int i=MAX_LEVEL; i > 0; i--){
      while(
        Objects.nonNull(walk.forward[i - 1]) && 
        valueCompare(walk.forward[i - 1], num) <= 0
      ) walk = walk.forward[i - 1];
      updates[i - 1] = walk;
    }

    if(valueCompare(updates[0], num) == 0){
      addEl(updates[0], num);
    }else{
      final int randomHeight = nodeHeight(MAX_LEVEL);
      Node<T> newNode = new Node<>(randomHeight + 1, num);
      addEl(newNode, num);
      for(int i=0; i <= randomHeight; i++){
        Node<T> next = updates[i].forward[i];
        updates[i].forward[i] = newNode;
        newNode.forward[i] = next;
      }
    }
  }
  

  public boolean erase(T num) {

    Node<T>[] updates = new Node[MAX_LEVEL];
    Node<T> walk = head;
    for(int i=MAX_LEVEL; i > 0; i--){
      while(
        Objects.nonNull(walk.forward[i - 1]) && 
        valueCompare(walk.forward[i - 1], num) < 0
      ) walk = walk.forward[i - 1];
      updates[i - 1] = walk;
    }

    if(
        Objects.isNull(updates[0].forward[0]) ||
        valueCompare(updates[0].forward[0], num) != 0
    ) return false;

    if(elSize(updates[0].forward[0]) > 1){
      // updates[0].forward[0].count--;
      removeEl(updates[0].forward[0], num);
    }else{
      for(
        int i=0; 
        i < MAX_LEVEL && Objects.nonNull(updates[i].forward[i]) && valueCompare( updates[i].forward[i], num) == 0; 
        i++
      ){
        Node<T> toRm = updates[i].forward[i];
        updates[i].forward[i] = toRm.forward[i];
        toRm.forward[i] = null;
      }
    }

    return true;
  }

  static <T> void addEl(Node<T> node, T target){
    node.vals.add(target);
  }

  int nodeHeight(int heightCap){
    int level = 0;
    double border = 100 * (1 - 0.5);
    while (((RANDOM.nextInt(Integer.MAX_VALUE) % 100) + 1) > border) {
        if (level + 1 >= heightCap) {
            return level;
        }
        level++;
    }
    return level;
  }

  static <T> int elSize(Node<T> node){
    return node.vals.size();
  }

  static <T> boolean removeEl(Node<T> node, T target){
    return false;
  }

  static class Node<T> {
    List<T> vals;
    Node<T>[] forward ;
    final int height;
    public Node(int h, T val){
      this.height = h;
      forward = new Node[h];
    }
  }

  static <T> int valueCompare(Node<T> node, T target, Comparator<T> comparator){
    return comparator.compare(node.vals.get(0), target);
  }

  static <T extends Comparable<T>> int valueCompare(Node<T> node, T target){
    return valueCompare(node, target, T::compareTo);
  }

}
