package com.learn.algorithms.leetcode.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GenerateParenthesis {
  
  public List<String> generateParenthesis(int n) {
    List<String> ans =new LinkedList<>(); 
    dfs("", n, n, ans);
    return ans;
  }

  List<String> generate(int n, Map<Integer, List<String>> cache){
    if(n <= 0) return List.of("");
    List<String> mayCached = cache.get(n);
    if(Objects.nonNull(mayCached)) 
      return mayCached;
    if(n == 1) return List.of("()");
    List<String> tocache = new LinkedList<>();
    for(int i=0; i < n; i++){
      List<String> leftIns = generate(i, cache);
      List<String> rights = generate(n - i - 1, cache);
      for(String leftIn : leftIns){
        for(String right : rights){
          // (leftIn)right
          tocache.add("(" + leftIn + ")" + right);
        }
      }
    }
    cache.put(n, tocache);
    return tocache;
  }

  // 广度优先搜索
  // reference 
  // 这一类问题是在一棵隐式的树上求解，可以用深度优先遍历，也可以用广度优先遍历。
  // 一般用深度优先遍历。原因是：

  // 代码好写，使用递归的方法，直接借助系统栈完成状态的转移；
  // 广度优先遍历得自己编写结点类和借助队列。
  // 这里的「状态」是指程序执行到 隐式树 的某个结点的语言描述，在程序中用不同的 变量 加以区分。

  // 作者：liweiwei1419
  // 链接：https://leetcode.cn/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
  // 来源：力扣（LeetCode）
  // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
  void dfs(final String str, final int left, int right, List<String> cache){
    if(left == 0 && right == 0)
      cache.add(str);
    else {
      if(left > right) return;
      if(left > 0)
        dfs(str + "(", left - 1, right, cache);
      if(right > 0)
        dfs(str + ")", left,  right - 1, cache);
    }
  }
}
