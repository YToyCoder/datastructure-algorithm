package com.learn.algorithms.leetcode.hard;

import java.util.Objects;
import java.util.Random;

public class Skiplist {
  private static final int MAX_LEVEL = 16;
  private static final Random RANDOM = new Random();
  private Node head;
  
  public Skiplist() {
    head = new Node(MAX_LEVEL, Integer.MIN_VALUE);
  }
  
  public boolean search(int target) {
    Node ans = head;
    int level = head.height;
    while(level > 0 && Objects.nonNull(ans) && ans.val != target){
      if(Objects.isNull( ans.forward[level - 1] )){
        if(level > 0) level--;
        else {
          ans = null;
        }
      } else if(ans.forward[level - 1].val == target){
        // should >>> ans = ans.forward[level - 1]
        return true;
      }else if(ans.forward[level - 1].val > target){
        level--;
      }else {
        ans = ans.forward[level - 1];
      }
    }
    return Objects.nonNull(ans) && ans.val == target;
  }
  
  public void add(int num) {
    Node[] updates = new Node[MAX_LEVEL];
    Node walk = head;
    for(int i=MAX_LEVEL; i > 0; i--){
      while(
        Objects.nonNull(walk.forward[i - 1]) && 
        walk.forward[i - 1].val <= num
      ) walk = walk.forward[i - 1];
      updates[i - 1] = walk;
    }

    if(updates[0].val == num){
      updates[0].count++;
    }else{
      final int randomHeight = nodeHeight(MAX_LEVEL);
      Node newNode = new Node(randomHeight + 1, num);
      newNode.count = 1;
      for(int i=0; i <= randomHeight; i++){
        Node next = updates[i].forward[i];
        updates[i].forward[i] = newNode;
        newNode.forward[i] = next;
      }
    }
  }
  
  public boolean erase(int num) {

    Node[] updates = new Node[MAX_LEVEL];
    Node walk = head;
    for(int i=MAX_LEVEL; i > 0; i--){
      while(
        Objects.nonNull(walk.forward[i - 1]) && 
        walk.forward[i - 1].val < num
      ) walk = walk.forward[i - 1];
      updates[i - 1] = walk;
    }

    if(
        Objects.isNull(updates[0].forward[0]) ||
        updates[0].forward[0].val != num
    ) return false;

    if(updates[0].forward[0].count > 1){
      updates[0].forward[0].count--;
    }else{
      for(int i=0; i < MAX_LEVEL && Objects.nonNull(updates[i].forward[i]) && updates[i].forward[i].val == num; i++){
        Node toRm = updates[i].forward[i];
        updates[i].forward[i] = toRm.forward[i];
        toRm.forward[i] = null;
      }
    }

    return true;
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
  
  static class Node {
    int val;
    int count = 0;
    Node[] forward ;
    final int height;
    public Node(int h, int val){
      this.height = h;
      forward = new Node[h];
      this.val = val;
    }
  }
}

/*

["Skiplist","add","add","add","add","search","erase","search","search","search"]
[[],[0],[5],[2],[1],[0],[5],[2],[3],[2]]

["Skiplist","add","add","add","add","add","add","add","add","add","erase","search","add","erase","erase","erase","add","search","search","search","erase","search","add","add","add","erase","search","add","search","erase","search","search","erase","erase","add","erase","search","erase","erase","search","add","add","erase","erase","erase","add","erase","add","erase","erase","add","add","add","search","search","add","erase","search","add","add","search","add","search","erase","erase","search","search","erase","search","add","erase","search","erase","search","erase","erase","search","search","add","add","add","add","search","search","search","search","search","search","search","search","search"]
[[],[16],[5],[14],[13],[0],[3],[12],[9],[12],[3],[6],[7],[0],[1],[10],[5],[12],[7],[16],[7],[0],[9],[16],[3],[2],[17],[2],[17],[0],[9],[14],[1],[6],[1],[16],[9],[10],[9],[2],[3],[16],[15],[12],[7],[4],[3],[2],[1],[14],[13],[12],[3],[6],[17],[2],[3],[14],[11],[0],[13],[2],[1],[10],[17],[0],[5],[8],[9],[8],[11],[10],[11],[10],[9],[8],[15],[14],[1],[6],[17],[16],[13],[4],[5],[4],[17],[16],[7],[14],[1]]

 */
