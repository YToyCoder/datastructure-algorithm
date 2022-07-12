# algorithms-learn

### 介绍
java leetcode 算法练习

用于保存leetcode刷题记录保存

### data-structure

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

*实现*: 

1. src/main/java/com/learn/algorithms/zuo/Graphs

2. src/main/java/com/learn/ds/graph/Graph


### algorithms

- basic sort

1. bubble sort (冒泡排序)
2. quick sort (快排)
3. heap sort (堆排序)
4. selection sort (选择排序)
5. insert sort (插入排序)
6. merge sort (归并排序)
7. counting sort (计数排序)
8. bucket sort (桶排序)

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

- hard

1. BusiestServers

2. FindSubstring

3. FirstMissingPositive

4. MedianofTwoSortedArrays

5. RangeModule

6. ReachingPoint

7. Trap

8. UniqueMorseRepresentations

9. UniquePaths


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