package com.learn.algorithms.leetcode.easy;

import java.util.List;
import java.util.Objects;

import java.util.LinkedList;

public class MaxDepth {
	public int maxDepth(Node root) {
		if(Objects.isNull(root)) return 0;
		LinkedList<Node> store = new LinkedList<>();
		store.add(root);
		int size ;
		int dep = 0;
		while(!store.isEmpty()){
			size = store.size();
			for(int i=0; i<size; i++){
				Node n = store.removeFirst();
				store.addAll(n.children);
			}
			dep++;
		}
    return dep;
	}

	class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
	}
}
