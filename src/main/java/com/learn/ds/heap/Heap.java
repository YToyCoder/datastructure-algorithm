package com.learn.ds.heap;

public interface Heap<T> {
	
    /**
     * 查看最顶上的元素
     * @return elem {index = 0}
     */
    T peek();

    /**
     * 取出最顶上的元素
     * @return elem {index = 0}
     */
    T poll();

    /**
     * 向堆里面添加一个值
     * @param value
     */
    void add(T value);

    /**
     * 用于区分大根堆和小根堆
     * @param first
     * @param second
     * @return if max heap return item(index=first) > item(index=second),
     * else return item(index=first) < item(index=second)
     * else if right is out of range
     */
    boolean correctOrder(int first, int second);

    /**
     * 交换两个位置的元素
     * @param first
     * @param second
     */
    void swap(int first, int second);

    /**
     * 判断是否存在左孩子
     * @param current
     * @return current * 2 + 1 < len
     */
    boolean hasLeftChild(int current);

    /**
     * 判断是否存在右孩子
     * @param current
     * @return current * 2 + 2 < len
     */
    boolean hasRightChild(int current);

    /**
     * 判断是否存在父节点
     * @param current
     * @return if has parent return true, else false
     */
    boolean hasParent(int current);

    /**
     * 堆的大小
     * @return size
     */
    int size();
}
