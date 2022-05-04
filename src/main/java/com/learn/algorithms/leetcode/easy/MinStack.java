package com.learn.algorithms.leetcode.easy;

import java.util.Stack;

class MinStack {
	Stack<Integer> stack = new Stack<>();
	Stack<Node> mins = new Stack<>();
	public MinStack() {
	}
	
	public void push(int val) {
		stack.push(val);
		if(mins.empty() || (mins.peek().val > val)){
			mins.push(new Node(stack.size() - 1, val));
		}
	}
	
	public void pop() {
		stack.pop();
		if(mins.peek().loc == stack.size())
			mins.pop();
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return mins.peek().val;
	}
	private static class Node{
		int loc;
		int val;

		public Node(int l, int v){
			loc = l;
			val = v;
		}
	}
}
