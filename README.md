# algorithms-learn

### 介绍

数据结构和算法学习

### 数据结构(data-structure)

- Heap (堆)

堆的应用:

1. Heap Sort 

2. Priority Queue

3. Graph Algorithms

4. problem

> K'th Largest Element in an array

> Sort an almost sorted array

> Merge K Sorted Arrays

堆(Binary Heap)是一种特殊的树形数据结构，并且是一个完全二叉树。堆分为`大根堆`和`小根堆`.

MaxHeap(大根堆) : 父节点的key值必须大于其任何子节点的key值。

MinHea(小根堆) : 父节点的key值必须小于其任何子节点的key值。

小根堆的操作:

1) getMini() 将返回小根堆的root节点。时间复杂度是$O(1)$

2) extractMin() 从小根堆里面移除最小节点，时间复杂度是$O(log n)$

3) decreaseKey() 减小某个节点的key的值。该操作的时间复杂度是$O(log n)$，如果减小的值比父节点的key值大不做任何操作，否则向上迭代修复二叉树.

4) insert() 插入一个新的key节点需要花费$O(log n)$时间复杂度。该方法会将该节点插入树的末尾，如果该节点大于父节点不需要做任何事，否则需要从该节点向上迭代修复被破坏的树的属性。

5) delete() 删除节点需要花费$O(log n)$ 的时间复杂度。删除节点时通过`decreaseKey`将节点的值减小为mini，那么mini就会被迭代到root，最后执行extactMin就完成了该节点的删除.

```
        小根堆                    大根堆

          10                      100 
        /    \                   /    \
      15     30                40      50
    /   \   /   \             /  \    /  \
  40    50 100  40          10    15 50  40
```

二叉堆的主要应用是优先队列。

二项堆(Binomial Heap) 是一种堆结构。与二叉堆相比，其优势是可以快速合并两个堆，因此它属于可合并堆(Mergeable Heap)数据结构的一种.


****

- List (链表)

链表和数组很相似都是线性的, 但是也有不同点.数组的元素是存储在连续的内存区域，而链表的元素存储的位置却不一定是连续的。链表是通过指针将一个一个元素连接起来的。
根据链表节点包含的指针可以将链表分为`单链表`和`双向链表`.

SingleLinkedList (单链表)

> 单链表是那些节点只包含一个指针的链表，该指针用于指向该节点的下一节点。

```
+----------+          +------------+          +-----------+
| val      |          | val        |          | val       |
|     next -------->  |       next -------->  |     next --------> ...
+----------+          +------------+          +-----------+
```

LinkedList (双向链表)

> 双向链表是指链表的节点包含两个分别指向前向元素和后向元素的链表.

```
  +---------------+      +---------------+      +--------------+
<-- prev          |<------prev           |<------prev          |
  |      val      |      |     val       |      |     val      |
  |           next ----> |          next ---->  |         next ---> ...
  +---------------+      +---------------+      +--------------+
```

> 单链表

Queue (队列)

- Tree (树)

Binary Search Tree(二叉搜索树)

AVL Tree (二叉平衡树)

Red Black Tree (红黑树)

****

- Graph (图)

图是一个非线性数据结构。图是一个由多个节点和多个边组成的结构。节点有时也称为顶点，边是线或弧用于连接两个节点。

> 定义:
> A Graph consists of a finite set of vertices(or nodes) and set of Edges which connect a pair of nodes.
> 图是有限的边（连接两个节点）将有限的节点连接起来的结构。

*两种常用的图的表示法*:

1. 邻接矩阵

假设图的边的大小是$V$, 邻接矩阵是一个2维的$V x V$的数组.假设邻接矩阵是`adj[]`, 那么`adj[i][j] = 1`表示存在一个边从点`i`到`j`.

```
      1 2 3 4 5 6 7 
    +---------------+
  1 | 0 1 0 1 0 0 0 |
  2 | 0 0 0 1 0 1 0 |
  3 | 1 1 1 0 0 0 0 |
  4 | 1 0 1 0 0 1 0 |
  5 | 0 1 1 0 0 0 0 |
  6 | 0 1 1 0 1 0 0 |
  7 | 1 1 1 0 0 0 0 |
    +---------------+

```

2. 邻接列表

邻接列表是用一个数组表示，数组大小是边的大小. 如果该数组是`arr[]`, 那么`arr[i]`代表第`i`个节点的临近节点.

```
    +--+   +------+    +-------+
0   | ---> | 1  | ---> | 4  | ---> ...
    +--+   +------+    +-------+

    +--+   +------+    +-------+   +-------+   +-------+   
1   | ---> | 0  | ---> | 4  | ---> | 2  | ---> | 3  | --->  ..
    +--+   +------+    +-------+   +-------+   +-------+     

    +--+   +------+    +-------+
2   | ---> | 1  | ---> | 3  | ---> ...
    +--+   +------+    +-------+

    +--+   +------+    +-------+
3   | ---> | 1  | ---> | 4  | ---> ...
    +--+   +------+    +-------+

    +--+   +------+    +-------+   +-------+
4   | ---> | 3  | ---> | 0  | ---> | 1  | --->...
    +--+   +------+    +-------+   +-------+  

```

*遍历节点*:

1. 广度优先遍历

广度优先搜索始终是将已发现节点和未发现节点之间的边界，沿其广度方向向外扩展，也就是说算法需要在发现所有距离源节点s为k的所有节点之后，才会发现距离源节点s为$k + 1$的其他节点.

为了跟踪算法的进展，广度优先搜索在概念上将每个节点图上白色、灰色或黑色，所有节点在一开始的时候均涂上白色，在算法退进过程中，这些节点可能会变成灰色或黑色，在搜索过程中，第一次遇到一个节点就称该节点被`发现`,此时该节点的颜色将发生改变。因此，凡是`灰色`和`黑色`的节点都是已发现的结点。但广度优先搜索对灰色和黑色结点加以区别,以确保搜索按照广度优先模式进行推进,如果边$(u,v) \in E$且结点u是黑色，则结点v既可能是灰色也可能是黑色，也就是说，所有与黑色结点邻接的结点都已发现。对于灰色结点来说，其邻接结点中可能存在未被发现的白色结点，灰色结点所代表的就是已知和未知两个集合之间的边界。

*实现: src/main/java/com/learn/ds/graph/Graph*

****

2. 深度优先遍历

from [Bill Thies](http://people.csail.mit.edu/thies/6.046-web/recitation9.txt)

Edge Classification

1. Tree edge:  encounter new (white) vertex
   - gray to white
2. Back edge: from descendent to ancestor
   - gray to gray
3. Forward edge:  nontree edge from ancestor to descendent
   - gray to black
4. cross edge:  remainder - betweeen trees or sub-trees
   - gray to black


```
DFS(G)
  for each vertex u in V[G]
    do color[u] <- WHITE
       pi[u] <- NIL
  time <- 0
  for each vertex u \in V[G]
    do if color[u] = WHITE
       then DFS-VISIT(u)

DFS-VISIT(u)
  color[u] <- GRAY
  time <- time + 1
  d[u] <- time
  for each v \in Adj[u]
    do if color[v] = WHITE
      then pi[v] <- u
           DFS-VISIT(v)
 color[u] <- BLACK
 f[u] <- time + 1
 time <- time + 1
```


from [求有向图边的分类分别是什么意思？](https://www.zhihu.com/question/20003218)

我们在做dfs的时候，当访问到一个节点时，会出现四种情况：

1.此节点未被访问过，则此次的访问关系边（发起点——>接受点）称为树边（tree edge）；

2.此节点被访问过但此节点的子孙还没访问完，换句话说，此次的发起点的源头可以追溯到接收点，则此次访问关系边称为后向边（back edge）；

3.此节点被访问过且此节点的子孙已经访问完，而且发起点是搜索初始边，则称为前向边（down edge）；

4.此节点被访问过且此节点的子孙已经访问完，而且发起点不是搜索初始边，则称为横叉边（cross edge）

深度优先搜索应用: 

1. Topological Sort (拓扑排序)

2. Detecting cycle in graph (查找环)

3. Path Find (路径查找)

> 过程: 进行深度优先搜索( a -> z ) ，通过栈保存`a`到当前节点的路径，当遇到`z`时返回保存的路径。

*实现*: 

1. src/main/java/com/learn/algorithms/zuo/Graphs

2. src/main/java/com/learn/ds/graph/Graph

****

- Hashing Data Structure (hash结构数据)

Hashing 是一种通过hash函数将键值对的映射存储在hash表的技术。这样的技术是用于更快的访问容器的元素，映射的速度取决于使用的hash函数。

基本操作:

1. HashTable : 创建hash表

2. Delete : 从hash表中删除特定的key-value(键值对)

3. Put : 获取hash表中特定的key对应的值

4. DeleteHashTable : 删除hash表

Hashing重要的组件:

HashTable : 用于存储键值对

Hash function : 将key转化成实际的int值

### 算法(algorithms)

- basic sort

1. bubble sort (冒泡排序)
2. quick sort (快排)
3. heap sort (堆排序)
4. selection sort (选择排序)
5. insert sort (插入排序)
6. merge sort (归并排序)
7. counting sort (计数排序)
8. bucket sort (桶排序)
9. radix sort (基数排序)

*实现： src/main/java/com/learn/algorithms/basic/BasicSort*

- Bits (位运算)

1. multiply

通过位操作实现两数之和

*方法: `if b & 1 == 1 , a * b = a * 2 * (b - 1) / 2 + a else a * b = a * 2 * b / 2`*

### leetcode

- easy

1. CombinationSum

2. DeleteText

3. GetIntersectioNode

4. GetRow

5. HasAlternatingBits

6. IsBoomerang

7. MaxDepth

8. MaximumWealth

9. MergeTwoLists

10. MinBitFlips

11. MinStack

12. MostCommonWord

13. NextGreatestLetter

14. NumberOfLines

15. NumWays

16. PalindromeNumber

17. RemoveElement

18. RotateString

19. ShorttestToChar

20. StrStr

21. ToGoatLatin

22. TwoSum

23. minDiffInBST

给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

差值是一个正数，其数值等于两值之差的绝对值。

*思路: 二叉树中序遍历*

```java
int min = Integer.MAX_VALUE;
public int minDiffInBST(TreeNode root) {
  interthemTrav(root, new ArrayList<>());
  return min;
}

void interthemTrav(TreeNode root, List<Integer> arr){
  if(Objects.isNull(root)) return;
  interthemTrav(root.left, arr);
  //
  if(!arr.isEmpty()){
    int temp ;
    if((temp = Math.abs( arr.get(arr.size() - 1)  - root.val)) < min)min = temp; 
  }
  arr.add(root.val);
  interthemTrav(root.right, arr);
}
```

24. MovingAverage

给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。

实现 MovingAverage 类：

MovingAverage(int size) 用窗口大小 size 初始化对象。
double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/qIsx9U
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

25. isBalanced(二叉树平衡)

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

26. hasPathSum 二叉树路径总和

给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

叶子节点 是指没有子节点的节点。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

27. majorityElement(多数元素)

给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

28. titleToNumber (Excel 表列序号)

给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。

例如：

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

示例 1:

输入: columnTitle = "A"
输出: 1
示例 2:

输入: columnTitle = "AB"
输出: 28
示例 3:

输入: columnTitle = "ZY"
输出: 701

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/excel-sheet-column-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

29. isIsomorphic (同构字符串)

给定两个字符串 s 和 t ，判断它们是否是同构的。

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

 

示例 1:

输入：s = "egg", t = "add"
输出：true
示例 2：

输入：s = "foo", t = "bar"
输出：false
示例 3：

输入：s = "paper", t = "title"
输出：true

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/isomorphic-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


*解法: 排序+计数*

- medium

1. AddTwoNumbers

2. CanIWin

3. CombinationSum

4. ConvertTime

5. CountNumbersWithUniqueDigits

6. Deserialize

7. Divide

8. FindDuplicates

9. GenerateParenthesis

10. GrayCode

11. Insert

12. IsValidBST

13. IsValidSudoku

14. Jump

15. LetterCombinations

16. LevelOrder

17. LexicalOrder

18. LongestPalindromicSubstring

19. LongestSubstringWithoutRepestingCharacters

20. LongestValidParentheses

21. MaxArea

22. MaxConsecutiveAnswers

23. MinDeletion

24. MinEatingSpeed

25. MinPathSum

26. NextPermutation

27. NumArray

28. NumSubarrayProductLessThanK

29. Permute

30. PermuteUnique

31. RandomIndex

32. RemoveDuplicates

33. ReorderList

34. ReverseInteger

35. Rotate

36. Search

37. SimplifyPath

38. SortColors

39. StringtoInteger

40. Subsets

41. ZigzgConversion

42. asteroidCollision

>给定一个整数数组 asteroids，表示在同一行的行星。

>对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。

>找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。

43. fourSum (四数之和)

> 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

>0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。

>示例 1：

>输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
示例 2：

>输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]

*解法: 1. 回溯(遍历) 2. 排序 + 双指针(官方解法)*

44. groupAnagrams (字母异位词分组)

> 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

> 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*解题方法: 统计字母出现的次数作为key*

45. intersect(四叉树交集)

46. arrayNesting(数组嵌套)

索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。

假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。

 

示例 1:

输入: A = [5,4,0,3,1,6,2]
输出: 4
解释: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

其中一种最长的 S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 

提示：

N是[1, 20,000]之间的整数。
A中不含有重复的元素。
A中的元素大小在[0, N-1]之间。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/array-nesting
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


- hard

1. BusiestServers

2. FindSubstring

3. FirstMissingPositive

4. MedianofTwoSortedArrays

5. RangeModule

区间 的范围并查询它们。

半开区间 [left, right) 表示所有 left <= x < right 的实数 x 。

实现 RangeModule 类:

RangeModule() 初始化数据结构的对象。
void addRange(int left, int right) 添加 半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
boolean queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true ，否则返回 false 。
void removeRange(int left, int right) 停止跟踪 半开区间 [left, right) 中当前正在跟踪的每个实数。
 

示例 1：

输入
["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
输出
[null, null, null, true, false, true]

解释
RangeModule rangeModule = new RangeModule();
rangeModule.addRange(10, 20);
rangeModule.removeRange(14, 16);
rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/range-module
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



6. ReachingPoint

7. Trap

8. UniqueMorseRepresentations

9. UniquePaths

10. WordFilter

> 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
>
> 实现 WordFilter 类：
>
> WordFilter(string[] words) 使用词典中的单词 words 初始化对象。 
> f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/prefix-and-suffix-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*解题方法: Trie 字典树*

****

- zuo (左程云)

1. 判断一个二叉树是否是搜索二叉树

- 判断是否满足 `left-key < node-key < right-key`

- 中序遍历放入数组，数组是按照节点升序排列，比较数组是否符合该条件(构建该数组时可以递归也可以使用循环) 

> 代码位置 

> src/main/java/com/learn/algorithms/zuo/BST#isBST

> src/main/java/com/learn/algorithms/zuo/BST#isBST2

2. 判断一个二叉树是否是完全二叉树

- 进行广度优先搜索，判断是否存在前序节点是不存在两个子节点和当前节点是否是不存在left但存在right的情况

3. 判断一个二叉树是否平衡

- 后续遍历子树是否是平衡树

4. 找到两个节点的最低公共祖先