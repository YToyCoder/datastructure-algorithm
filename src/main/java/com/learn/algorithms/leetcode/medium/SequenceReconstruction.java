package com.learn.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SequenceReconstruction {
  
  public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
    final int[] indegree = new int[nums.length + 1]; // 入度记录
    final Set<Integer>[] outs = new Set[nums.length + 1]; // 下一结点记录
    for(int i=0; i<outs.length; i++)
      outs[i] = new HashSet<>();

    for(int[] sequence : sequences){
      for(int i=1; i<sequence.length; i++){
        if(outs[sequence[i - 1]].add(sequence[i])){
          indegree[sequence[i]]++;
        }
      }
    }
    Queue<Integer> queue = new LinkedList<>();
    for(int i=0; i < indegree.length; i++){
      if(indegree[i] == 0) queue.offer(i);
    }
    int walk = 0;
    while(!queue.isEmpty()){
      if(queue.size() != 1) return false;
      int next = queue.poll();
      if(next != nums[walk++]) return false;
      for(int out : outs[next]){
        indegree[out]--;
        if(indegree[out] == 0) queue.offer(out);
      }
    }
    return true;
  }

  public boolean sequenceReconstruction1(int[] nums, int[][] sequences) {
    // 入度记录表
    Map<Integer, List<Set<Integer>>> inRecords = new HashMap<>();
    for(int[] sequence : sequences){
      for(int i=0; i<sequence.length; i++){
        // all ins 
        List<Set<Integer>> insAndOut = inRecords.computeIfAbsent(sequence[i], key -> List.of(new HashSet<>(), new HashSet<>()));
        Set<Integer> ins = insAndOut.get(0);
        Set<Integer> outs = insAndOut.get(1);
        if(i > 0 && !ins.contains(sequence[i - 1])){
          // a new in
          ins.add(sequence[i - 1]);
        }
        if(i < sequence.length - 1 && !outs.contains(sequence[i + 1])){
          // a new out
          outs.add(sequence[i + 1]);
        }
      }
    }

    if(inRecords.size() != nums.length) return false;
    int nextNode = -1;
    Map.Entry<Integer, List<Set<Integer>>> node = null;
    Set<Integer> insOfNode, outsOfNode;
    while(!inRecords.isEmpty()){
      for(Map.Entry<Integer, List<Set<Integer>>> el : inRecords.entrySet()){
        insOfNode = el.getValue().get(0);
        outsOfNode = el.getValue().get(1);
        if(insOfNode.isEmpty()){
          // find the next node to handle
          if(nextNode != -1) return false; // find multi next node
          nextNode = el.getKey();
          node = el;
        }
      }
      // handle node
      outsOfNode = node.getValue().get(1);
      for(int out : outsOfNode){
        List<Set<Integer>>  outNode =  inRecords.get(out);
        outNode.get(0).remove(nextNode);
      }

      // finish handle
      inRecords.remove(nextNode);
      nextNode = -1;
      node = null;
    }
    return true;
  }
}
