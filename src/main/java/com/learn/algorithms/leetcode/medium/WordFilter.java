package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**

设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。

实现 WordFilter 类：

WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
 

示例：

输入
["WordFilter", "f"]
[[["apple"]], ["a", "e"]]
输出
[null, 0]
解释
WordFilter wordFilter = new WordFilter(["apple"]);
wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/prefix-and-suffix-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

public class WordFilter {
  Trie prefix = new Trie();
  Trie suffix = new Trie();
  
  public WordFilter(String[] words) {
    for(int i=0; i < words.length; i++){
      prefix.put(words[i], i);
      suffix.putr(words[i], i);
    }
  }
  
  public int f(String pref, String suff) {
    List<Integer> prefI = prefix.query(pref);
    List<Integer> suffI = suffix.queryR(suff);

    int n = prefI.size(); int m = suffI.size();
    for (int i = n - 1, j = m - 1; i >= 0 && j >= 0; ) {
      if (prefI.get(i) > suffI.get(j)) i--;
      else if (prefI.get(i) < suffI.get(j)) j--;
      else return prefI.get(i);
    }
    return -1;
  }


  static class Node {
    List<Integer> indexs = new ArrayList<>();
    Node[] child = new Node[26];
  }

  static class Trie {
    Node root = new Node();
    void put(String word, int mark, boolean reverse){
      Node walk = root;
      final int len = Math.min(word.length(), 7);
      for(int i=0; i < len; i++){
        byte index = char2byte(word.charAt(reverse ? word.length() - i - 1 : i));
        if(Objects.isNull(walk.child[index])){
          walk.child[index] = new Node();
        }
        walk.child[index].indexs.add(mark);
        walk = walk.child[index];
      }
    }

    void put(String word, int mark){
      put(word, mark, false);
    }

    void putr(String word, int mark){
      put(word, mark, true);
    }

    public List<Integer> query(String word){
      Node walk = root;
      for(int i=0; i < word.length(); i++){
        walk = walk.child[char2byte(word.charAt(i))];
        if(Objects.isNull(walk)) return List.of();
      }
      return walk.indexs;
    }

    public List<Integer> queryR(String word){
      Node walk = root;
      for(int i=0; i < word.length(); i++){
        walk = walk.child[char2byte(word.charAt(word.length() - i - 1))];
        if(Objects.isNull(walk)) return List.of();
      }
      return walk.indexs;
    }

    public static byte char2byte(char c){
      return (byte)(c - (char)'a');
    }
  }
}
