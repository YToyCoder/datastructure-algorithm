package com.learn.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LevelOrder {

	public List<List<Integer>> levelOrder(TreeNode root) {
		if(Objects.isNull(root)) return List.of();
		List<List<Integer>> ordered = new ArrayList<>();
		List<TreeNode> store = new LinkedList<>();
		store.add(root);
		int size;
		while(!store.isEmpty()) {
			size = store.size();
			List<Integer> level = new ArrayList<>();
			for(int i=0; i<size; i++) {
				TreeNode node = store.remove(0);
				if(Objects.nonNull(node.left)) store.add(node.left);
				if(Objects.nonNull(node.right)) store.add(node.right);
				level.add(node.val);
			}
			ordered.add(level);
		}
		return ordered;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
