package com.learn.ds.stack;

public interface Stack<T> {
	/**
	 * element size remain in stack
	 * @return element size
	 */
	int size();

	/**
	 * 将元素放入栈
	 * example:
	 * 	0 1 2 <- 3
	 * 	0 1 2 3
	 * @param val
	 */
	void push(T val);

	/**
	 * 查看栈顶元素
	 * 3 4 6 9
	 *       top -> 9
	 * 3 4 6 9
	 * @return top
	 */
	T peek();

	/**
	 * 将栈顶元素弹出
	 * 3 4 6 9
	 * 			top -> 9
	 * 3 4 6
	 * @return top
	 */
	T pop();
}
