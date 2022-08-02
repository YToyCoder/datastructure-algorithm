package com.learn.algorithms.leetcode.easy;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestPalindrome {
  
  public int longestPalindrome(String s) {
    Map<Character, IntHolder> counts = new HashMap<>();
    final char[] chars = s.toCharArray();
    int max = 0;
    for(char c : chars){
      IntHolder count = counts.computeIfAbsent(c, key -> new IntHolder());
      count.val++;
    }
    int hasOdd = 0;
    for(IntHolder count : counts.values()){
      if(count.val % 2 == 0)
        max += count.val;
      else {
        max += count.val - 1;
        hasOdd = 1;
      }
    }
    return max + hasOdd;
  }

  static class IntHolder{
    int val;
  }

  static void partitiondo(Collection<IntHolder> vals){
    Map<Boolean, List<IntHolder>> partition = vals.stream()
    .collect(Collectors.partitioningBy(
      el -> el.val % 2 == 0
    ));
    for(List<IntHolder> part : partition.values()){
      IntHolder sum = new IntHolder();
      part.stream()
      .forEach(el -> {
        System.out.println(el.val);
        sum.val += el.val;
      });
      System.out.println("sum * " + sum.val);
    }
  }

  public static void main(String[] args) {
    new LongestPalindrome().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
  }
}
