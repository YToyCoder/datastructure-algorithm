package com.learn.algorithms.leetcode.easy;

public class DistanceBetweenBusStops {
  
  public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    if(start == destination) return 0;
    int walk = start, walk_reverse = start;
    int wlen = 0, wrlen = 0;
    while(walk != destination || walk_reverse != destination){
      if(walk != destination){
        wlen += distance[walk];
        walk = walk == distance.length - 1 ? 0 : (walk + 1);
      }
      if(walk_reverse != destination){
        wrlen += distance[walk_reverse == 0 ? distance.length - 1 : (walk_reverse - 1)];
        walk_reverse = walk_reverse == 0 ? distance.length - 1 : (walk_reverse - 1);
      }
    } 
    return Math.min(wlen, wrlen);
  }
}
