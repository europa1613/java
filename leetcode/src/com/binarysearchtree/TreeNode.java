package com.binarysearchtree;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int value) {
		this.data = value;
	}

	public void insert(int value) {
		if (this.data == value) {
			return;
		} else if (value < this.data) {
			if (left == null) {
				left = new TreeNode(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new TreeNode(value);
			} else {
				right.insert(value);
			}
		}
	}

	public void traverseInOrder() {
		if (left != null) {
			left.traverseInOrder();
		}
		System.out.print(data + ", ");
		if (right != null) {
			right.traverseInOrder();
		}
	}

	public void traversePreOrder() {
		System.out.print(data + ", ");
		if (left != null) {
			left.traversePreOrder();
		}
		if (right != null) {
			right.traversePreOrder();
		}
	}

	public void traversePostOrder() {
		if (left != null) {
			left.traversePostOrder();
		}
		if (right != null) {
			right.traversePostOrder();
		}
		System.out.print(data + ", ");
	}

	public TreeNode get(int value) {
		if (data == value) {
			return this;
		}
		if (value < data) {
			if (left != null) {
				return left.get(value);
			}
		} else {
			if (right != null)
				return right.get(value);
		}

		return null;
	}

	public TreeNode min() {
		if (left != null) {
			return left.min();
		}
		return this;
	}

	public TreeNode max() {
		if (right != null) {
			return right.max();
		}
		return this;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}
}
