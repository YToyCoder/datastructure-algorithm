package com.learn.algorithms.leetcode.medium;

import java.util.LinkedList;
import java.util.List;


// 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

//  

// 示例 1:

// 输入: s = "cbaebabacd", p = "abc"
// 输出: [0,6]
// 解释:
// 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
// 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//  示例 2:

// 输入: s = "abab", p = "ab"
// 输出: [0,1,2]
// 解释:
// 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
// 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
// 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。

// 来源：力扣（LeetCode）
// 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class FindAnagrams {
  
  public List<Integer> findAnagrams(String s, String p) {
    if(s.length() < p.length()) return List.of();
    List<Integer> ans = new LinkedList<>();
    int[] map = new int[26];
    int[] pmap = new int[26];
    for(int i=0; i < p.length(); i++){
      pmap[mapIndex(p.charAt(i))]++;
      map[mapIndex(s.charAt(i))]++;
    }
    if(isvalid(map, pmap)){
      ans.add(0);
    }
    /*
     * s ----------->
     * p ------> k
     */
    for(int i=1; i + p.length() <= s.length(); i++){
      map[mapIndex(s.charAt(i - 1 ))]--;
      map[mapIndex(s.charAt(i + p.length() - 1))]++;
      if(isvalid(map, pmap)) ans.add(i);
    }
    return ans;
  }

  boolean isvalid(int[] map, int[] pmap){
    for(int i=0; i < 26; i++){
      if(map[i] != pmap[i]) return false;
    }
    return true;
  }

  int mapIndex(char c){
    return c - 'a';
  }
}
