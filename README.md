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
>
> Sort an almost sorted array
>
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

Segment Tree (线段树)

- skiplist (跳表)

跳表是一种随机化的数据结构，可以被看做二叉树的一个变种，它在性能上和红黑树、\texttt{AVL}AVL 树不相上下，但是跳表的原理非常简单，目前在 \texttt{Redis}Redis 和 \texttt{LevelDB}LevelDB 中都有用到。跳表的期望空间复杂度为 O(n)O(n)，跳表的查询，插入和删除操作的期望时间复杂度均为 O(\log n)O(logn)。跳表实际为一种多层的有序链表，跳表的每一层都为一个有序链表，且满足每个位于第 ii 层的节点有 pp 的概率出现在第 i+1i+1 层，其中 pp 为常数。

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/design-skiplist/solution/she-ji-tiao-biao-by-leetcode-solution-e8yh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

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

排序算法的稳定性:  假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，即在原序列中，ri=rj，且ri在rj之前，而在排序后的序列中，ri仍在rj之前，则称这种排序算法是稳定的；否则称为不稳定的。

1. bubble sort (冒泡排序)

```java

public static <T extends Comparable<T>> void bubble(List<T> list){
  for(int i = 0; i < list.size() - 1; i++){
    for(int j=0; j < list.size() - i - 1; j++){
      if(list.get(j).compareTo(list.get(j + 1)) > 0){
        swap(list, j, j + 1);
      }
    }
  }
}
```

2. quick sort (快排)

```java

  public static <T extends Comparable<T>> void quick(List<T> list){
    partition(list, 0, list.size());
  }

  public static <T extends Comparable<T>> void partition(List<T> list, int start, int end){
    /**
     * a swap example:
     * start <------------------------> end
     * 
     * lower       pivot
     * |            ||
     * |            \/
     * ? 7 9 4 5 2 1 6
     *     |
     *    walk
     * 
     * lower       pivot
     * |            ||
     * |            \/
     * ? 7 9 4 5 2 1 6
     *       |
     *      walk -> less than pivot && do swap
     *  
     *  lower      pivot
     *   |          ||
     *   |          \/
     * ? 4 9 7 5 2 1 6
     *       |
     *      walk -> swapped && continue
     * 
     *  lower      pivot
     *   |          ||
     *   |          \/
     * ? 4 9 7 5 2 1 6
     *         |
     *        walk -> less than pivot && do swap
     *
     *   lower    pivot
     *     |        ||
     *     |        \/
     * ? 4 5 7 9 2 1 6
     *         |
     *        walk -> swapped && continue
     * 
     * ? 4 5 2 9 7 1 6
     * 
     *       lower pivot
     *         |    ||
     *         |    \/
     * ? 4 5 2 1 7 9 6
     *             |
     *            walk -> swapped && continue
     * 
     * swap pivot to the partition "lower + 1"
     * ? 4 5 2 1 6 9 7
     * 
     */
    if(end - start <= 1) return;
    int lower = start - 1;
    final T pivot = list.get(end - 1);
    for(int i=start; i < end - 1; i++){
      // if(greater(pivot, list.get(i))){ 
      if(less(list.get(i), pivot)){ 
        // found smaller one
        swap(list, i, ++lower);
      }
    }
    swap(list, ++lower, end - 1);
    // do more partition
    partition(list, start,lower);
    partition(list, lower + 1, end);
  }

```
3. heap sort (堆排序)

```java

  public static <T extends Comparable<T>> void heap(List<T> list){
    // build the heap
    for(int i= list.size()/2 - 1; i >= 0; i--){
      heapfyDown(list, i, list.size());
    }

    // iterate list select swap index of 0 and end, do {@code heapfyDown} from 0 to end
    for(int i=0; i < list.size(); i++){
      final int end = list.size()  - i;
      swap(list, 0, end - 1);
      heapfyDown(list, 0, end - 1);
    }
  }


  private static <T extends Comparable<T>> void heapfyDown(List<T> list, int start, int end){
    int walk = start;
    int leftChild = Heaps.leftChild(walk), rightChild = Heaps.rightChild(walk);
    while(
      walk < end && 
      ( 
        (leftChild < end && greater(list.get(leftChild), list.get(walk))) || 
        (rightChild < end && greater(list.get(rightChild), list.get(walk)))
      )
    ){
      // swap with child 
      final int betterChild = 
        leftChild < end && 
        (rightChild >= end || greater(list.get(leftChild), list.get(rightChild))) 
        ? leftChild : 
          rightChild ;
      swap(list, walk, betterChild);
      walk = betterChild;
      leftChild = Heaps.leftChild(walk);
      rightChild = Heaps.rightChild(walk);
    }
  }

```

4. selection sort (选择排序)

```java

  public static <T extends Comparable<T>> void selection(List<T> list){
    for(int i=0; i < list.size() - 1; i++){
      // find min element between i and list.size
      int min = i;
      for(int j=i + 1; j < list.size(); j++){
        if(list.get(j).compareTo(list.get(min)) < 0){
          min = j;
        }
      }
      if(min != i) swap(list, min, i);
    }
  }

```

5. insert sort (插入排序)

```java

  public static <T extends Comparable<T>>  void insertion(List<T> list){
    for(int i=1; i < list.size(); i++){
      int walk = i;
      while(walk > 0 && list.get(walk).compareTo(list.get(walk - 1)) < 0 && walk < list.size()){
        swap(list, walk, walk - 1);
        walk--;
      }
    }
  }

```

6. merge sort (归并排序)

```java

  public static <T extends Comparable<T>> void merge(List<T> list){
    doMergeSort(list, 0, list.size());
  }

  private static <T extends Comparable<T>> void doMergeSort(List<T> list, int start, int end){
    // 
    if(end - start <= 1) return;
    final int mid = (start + end) / 2;
    doMergeSort(list, start, mid);
    doMergeSort(list, mid, end);

    // do sort
    for(int i=0; i<end; i++){
      // use insertion sort 
      insertionSort(list, start, end);
    }
  } 

```
7. counting sort (计数排序)

```java

  public static void counting2(List<Integer> list){
    if(list.isEmpty()) return;
    final int[] maxAndMin = maxAndmin(list);
    final int max = list.get(maxAndMin[0]);
    final int min = list.get(maxAndMin[1]);
    final int range = max - min + 1;
    final int[] counts = new int[range];
    for(int el : list){
      counts[el - min] += 1;
    }

    for(int i=1; i < counts.length; i++){
      counts[i] += counts[i - 1];
    }

    final Integer[] origin = list.toArray(new Integer[0]);
    for(int el : origin){
      list.set(--counts[el - min], el);
    }
  }

```

8. bucket sort (桶排序)

```java

  public static void bucket(double[] ls, int n){
    final List<List<Double>> buckets = Stream.generate(() -> new ArrayList<Double>()).limit(n).collect(Collectors.toList());
    for(double el : ls){
      final int location = (int)(el * n);
      List<Double> bucket = buckets.get(location);
      if(Objects.isNull(bucket)) buckets.set(location, (bucket = new ArrayList<>()));
      insertInOrder(bucket, el, (a , b) -> a > b);
    }

    final List<Double> sorted = buckets.stream().flatMap(bucket -> bucket.stream()).collect(Collectors.toList());
    for(int i=0; i < sorted.size(); i++){
      ls[i] = sorted.get(i);
    }
  }

```

9. radix sort (基数排序)

```java

  public static void radix(int[] arr){
    final int[] maxAndMin = maxAndMin(arr);
    final int max = arr[maxAndMin[0]];
    for(int exp=1; max/exp > 0; exp *= 10){
      counting(arr, exp, max, maxAndMin[1]);
    }
  }

  static void counting(int[] arr, int n, int max, int min){
    final int[] counts = new int[10]; 
    for(int el : arr){
      int indexInCounts = (el / n) % 10;
      counts[indexInCounts]++;
    }
    for(int i=1; i<10; i++) counts[i] += counts[i - 1];
    final int[] copy = Arrays.copyOf(arr, arr.length);
    for(int i=arr.length - 1; i >= 0; i--){
      int indexInCounts = (copy[i] / n) % 10;
      arr[--counts[indexInCounts]] = copy[i];
    } 
  }

```

10. shell-sort (希尔排序)

```java

  public static <T extends Comparable<T>> void shell(List<T> array){
    final int length = array.size();
    int gap = 1;
    while(gap < length / 3){
      gap = 3 * gap + 1;
    }

    for(; gap > 0; gap /= 3){
      for(int i = gap; i < length; i++){
        int j;
        T temp = array.get(i);
        for(j = i; j >= gap && less(temp, array.get(j -gap)); j -= gap){
          array.set(j, array.get(j - gap));
        }
        array.set(j, temp);
      }
    }
  }

```

按照时间复杂度大致分为3类：

  时间复杂度 O(n^2) ：选泡插：选择排序、冒泡排序、插入排序

  时间复杂度 O(nlogn) ：快归希堆：快速排序、归并排序、希尔排序、堆排序

  时间复杂度 O(n) ：桶计基：桶排序、计数排序、基数排序

| algorithm | avg | best | worst | space |  sort-way | is stable? |
| -- | -- | -- | -- | -- | -- | -- |
| bubble  | $O(n ^ 2)$| $O(n)$ | $O(n ^ 2)$ | $O(1)$ | In-place | true |
| select  | $O(n ^ 2)$| $O(n ^ 2)$ | $O(n ^ 2)$ | $O(1)$ | In-place | false |
| insert  | $O(n ^ 2)$| $O(n)$ | $O(n ^ 2)$ | $O(1)$ | In-place | true |
| shell   | $O(n \log n)$| $O(n \log^2n)$ | $O(n \log ^ 2n)$ | $O(1)$ | In-place | false |
| merge   | $O(n \log n)$| $O(n \log n)$ | $O(n \log n)$ | $O(n)$ | Out-place | true |
| quick   | $O(n \log n)$| $O(n \log n)$ | $O(n ^ 2)$ | $O(\log n)$ | In-place | false |
| heap    | $O(n \log n)$| $O(n \log n)$ | $O(n \log n)$ | $O(1)$ | In-place | false |
| counting| $O(n + k)$| $O(n + k)$ | $O(n + k)$ | $O(k)$ | Out-place | true |
| bucket  | $O(n + k)$| $O(n + k)$ | $O(n ^ 2)$ | $O(n + k)$ | Out-place | true |
| radix   | $O(n  k)$| $O(n  k)$ | $O(n k)$ | $O(n + k)$ | Out-place | true |


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

30. shiftGrid

给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。

每次「迁移」操作将会引发下述活动：

位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
请你返回 k 次迁移操作后最终得到的 二维网格。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/shift-2d-grid
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

31. reverseString (反转字符串)

*swap(i, len - i - 1)*

32. reverseList (反转链表)

给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

```java

  public ListNode reverseList(ListNode head) {
    ListNode walk = head;
    ListNode temp = new ListNode();
    while(Objects.nonNull(walk)){
      ListNode next = temp.next;
      temp.next = walk;
      walk = walk.next;
      temp.next.next = next;
    }
    return temp.next;
  }

```

33. moveZeroes ( 移动零 )

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。

34. isPowerOfThree 3的幂

给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。

整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/power-of-three
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


*int 能表示的3的幂的最大值为1162261467*

35. removeElements (移除链表元素)

给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。

*链表迭代*

36. isSubsequence 判断子序列

给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

进阶：

如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/is-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*双指针*

37. reverseVowels (反转字符串中的元音字母)

给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。

元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。

38. toHex (数字转换为十六进制数)

给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。

注意:

十六进制中所有字母(a-f)都必须是小写。
十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
给定的数确保在32位有符号整数范围内。
不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/convert-a-number-to-hexadecimal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

39. distanceBetweenBusStops ( 公交站间的距离)

环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。

环线上的公交车都可以按顺时针和逆时针的方向行驶。

返回乘客从出发点 start 到目的地 destination 之间的最短距离。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/distance-between-bus-stops
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

40. canBeIncreasing 删除一个元素使数组严格递增

给你一个下标从 0 开始的整数数组 nums ，如果 恰好 删除 一个 元素后，数组 严格递增 ，那么请你返回 true ，否则返回 false 。如果数组本身已经是严格递增的，请你也返回 true 。

数组 nums 是 严格递增 的定义为：对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/remove-one-element-to-make-the-array-strictly-increasing
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

41. isPalindrome (回文链表)

给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

*快慢指针 + 反转链表*

42. validMountainArray 有效的山脉数组

44. sumOfLeftLeaves (左叶子之和)

给定二叉树的根节点 root ，返回所有左叶子之和。

45. arrayRankTransform (数组序号转换)

给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。

序号代表了一个元素有多大。序号编号的规则如下：

序号从 1 开始编号。
一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
每个数字的序号都应该尽可能地小。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/rank-transform-of-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

46. numUniqueEmails (独特的电子邮件地址)

每个 有效电子邮件地址 都由一个 本地名 和一个 域名 组成，以 '@' 符号分隔。除小写字母之外，电子邮件地址还可以含有一个或多个 '.' 或 '+' 。

例如，在 alice@leetcode.com中， alice 是 本地名 ，而 leetcode.com 是 域名 。
如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名中没有点的同一地址。请注意，此规则 不适用于域名 。

例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。
如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件。同样，此规则 不适用于域名 。

例如 m.y+name@email.com 将转发到 my@email.com。
可以同时使用这两个规则。

给你一个字符串数组 emails，我们会向每个 emails[i] 发送一封电子邮件。返回实际收到邮件的不同地址数目。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/unique-email-addresses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*Set*

47. XorOperation （数组亦或）

48. fizzBuzz (Fizz Buzz)

给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：

answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
answer[i] == "Fizz" 如果 i 是 3 的倍数。
answer[i] == "Buzz" 如果 i 是 5 的倍数。
answer[i] == i （以字符串形式）如果上述条件全不满足。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/fizz-buzz
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

49. MyStack

 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。

实现 MyStack 类：

void push(int x) 将元素 x 压入栈顶。
int pop() 移除并返回栈顶元素。
int top() 返回栈顶元素。
boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 

注意：

你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/implement-stack-using-queues
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

47. multiply 字符串相乘

给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。

 

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/multiply-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

48. findAnagrams(找到字符串中所有字母异位词)

给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

 

示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

49. MyCalendar

记录一个有意思的答案(差分数组+TreeMap)

```java
class MyCalendarTwo {
    TreeMap<Integer, Integer> cnt;

    public MyCalendarTwo() {
        cnt = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        int ans = 0;
        int maxBook = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(maxBook, ans);
            if (maxBook > 2) {
                cnt.put(start, cnt.getOrDefault(start, 0) - 1);
                cnt.put(end, cnt.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/my-calendar-ii/solution/wo-de-ri-cheng-an-pai-biao-ii-by-leetcod-wo6n/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

50. pruneTree (二叉树剪枝)

给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。

返回移除了所有不包含 1 的子树的原二叉树。

节点 node 的子树为 node 本身加上所有 node 的后代。

 

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/binary-tree-pruning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

51. MyCalendar 

(实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。

当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。

日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end 。

实现 MyCalendar 类：

MyCalendar() 初始化日历对象。
boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
 

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/my-calendar-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。)

52. sequenceReconstruction (重建序列)

给定一个长度为 n 的整数数组 nums ，其中 nums 是范围为 [1，n] 的整数的排列。还提供了一个 2D 整数数组 sequences ，其中 sequences[i] 是 nums 的子序列。
检查 nums 是否是唯一的最短 超序列 。最短 超序列 是 长度最短 的序列，并且所有序列 sequences[i] 都是它的子序列。对于给定的数组 sequences ，可能存在多个有效的 超序列 。

例如，对于 sequences = [[1,2],[1,3]] ，有两个最短的 超序列 ，[1,2,3] 和 [1,3,2] 。
而对于 sequences = [[1,2],[1,3],[1,2,3]] ，唯一可能的最短 超序列 是 [1,2,3] 。[1,2,3,4] 是可能的超序列，但不是最短的。
如果 nums 是序列的唯一最短 超序列 ，则返回 true ，否则返回 false 。
子序列 是一个可以通过从另一个序列中删除一些元素或不删除任何元素，而不改变其余元素的顺序的序列。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/ur2n8P
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*拓扑排序*

53. combinationSum2 (组合总和 II)

给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用 一次 。

注意：解集不能包含重复的组合。 

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*回溯*

54. cloneGraph (拷贝图)

给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。

图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。

class Node {
    public int val;
    public List<Node> neighbors;
}

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/clone-graph
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

55. partition (分隔链表)

给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

你应当 保留 两个分区中每个节点的初始相对位置。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/partition-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

56. setZeroes (矩阵置零)

给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。

57. CBTInserter (完全二叉树插入器)

完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。

设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。

实现 CBTInserter 类:

CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
CBTInserter.get_root() 将返回树的头节点。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/complete-binary-tree-inserter
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

58. combine (组合)

给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。

*回溯(递归)+剪枝*

59. merge (合并区间)

以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

60. searchMatrix (搜索二维矩阵)

编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/search-a-2d-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*二分查找*

61. compress (压缩字符串)

给你一个字符数组 chars ，请使用下述算法压缩：

从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：

如果这一组长度为 1 ，则将字符追加到 s 中。
否则，需要向 s 追加字符，后跟这一组的长度。
压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。

请在 修改完输入数组后 ，返回该数组的新长度。

你必须设计并实现一个只使用常量额外空间的算法来解决此问题。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/string-compression
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*双指针*

62. fractionAddition (分数加减运算)

给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 

这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/fraction-addition-and-subtraction
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

63. rob (打家劫舍)

你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*动态规划*

64. canBeEqual (通过翻转子数组使两个数组相等)

给你两个长度相同的整数数组 target 和 arr 。每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。

如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

65. flatten (二叉树展开为链表)

给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*先序遍历*

66. getWinner (找出数组游戏的赢家)

给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。

每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。

返回赢得比赛的整数。

题目数据 保证 游戏存在赢家。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-the-winner-of-an-array-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

67. maxLevelSum (最大层内元素和)

给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。

请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

68. minDeletions (字符频次唯一的最小删除次数)

如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。

给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。

字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/minimum-deletions-to-make-character-frequencies-unique
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

69. construct (建立四叉树)

给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。

你需要返回能表示矩阵的 四叉树 的根结点。

注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。

四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：

val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
}
我们可以按以下步骤为二维区域构建四叉树：

如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
使用适当的子网格递归每个子节点。


如果你想了解更多关于四叉树的内容，可以参考 wiki 。

四叉树格式：

输出为使用层序遍历后四叉树的序列化形式，其中 null 表示路径终止符，其下面不存在节点。

它与二叉树的序列化非常相似。唯一的区别是节点以列表形式表示 [isLeaf, val] 。

如果 isLeaf 或者 val 的值为 True ，则表示它在列表 [isLeaf, val] 中的值为 1 ；如果 isLeaf 或者 val 的值为 False ，则表示值为 0 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/construct-quad-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

70. maxEqualRowsAfterFlips (按列翻转得到最大值等行数)

给定 m x n 矩阵 matrix 。

你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。）

返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows
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

11. maxSlidingWindow (滑动窗口最大值)

给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/sliding-window-maximum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*优先队列*

12. skiplist 跳表
不使用任何库函数，设计一个 跳表 。

跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。

例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作：


Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons

跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。

了解更多 : https://en.wikipedia.org/wiki/Skip_list

在本题中，你的设计应该要包含这些函数：

bool search(int target) : 返回target是否存在于跳表中。
void add(int num): 插入一个元素到跳表。
bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/design-skiplist
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

13. bfTraverse (按公因数计算最大组件大小)

给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图：

有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记；
只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。
返回 图中最大连通组件的大小 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/largest-component-size-by-common-factor
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*dfs*

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