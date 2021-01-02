package com.binarysearchtree;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Tree tree = new Tree();
		List<Integer> values = Arrays.asList(25, 20, 15, 27, 30, 29, 26, 22, 32);
		for (int value : values) {
			tree.insert(value);
		}

		tree.traverseInOrder();
		System.out.println();
		
		tree.traversePreOrder();
		System.out.println();
		
		tree.traversePostOrder();
		System.out.println();

		System.out.println(tree.get(27));
		System.out.println(tree.get(22));
		System.out.println(tree.get(17));
		System.out.println(tree.get(25));
		
		System.out.println();
		System.out.println(tree.min());
		System.out.println(tree.max());
	}

}
