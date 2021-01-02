package com.binarysearchtree;

public class Tree {
	TreeNode root;

	public void insert(int value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			root.insert(value);
		}
	}

	public void traverseInOrder() {
		if (root != null) {
			root.traverseInOrder();
		}
	}

	public void traversePreOrder() {
		if (root != null) {
			root.traversePreOrder();
		}
	}

	public void traversePostOrder() {
		if (root != null) {
			root.traversePostOrder();
		}
	}

	public TreeNode get(int value) {
		if (root != null) {
			return root.get(value);
		}
		return null;
	}

	public TreeNode min() {
		if (root != null) {
			return root.min();
		}
		return null;
	}

	public TreeNode max() {
		if (root != null) {
			return root.max();
		}
		return null;
	}
}
