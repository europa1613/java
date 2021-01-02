package com.test.kthlarget.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class KThLargest {

	public static void main(String[] args) {
		System.out.println(findLargest(new int[] { 2, 4, 8, 6 }, 2));

	}

	public static int findLargest(int[] numbers, int k) {

		int n = numbers.length;
		if (numbers == null || n == 0 || k > n) {
			return 0;
		}

		TreeSet<Integer> set = new TreeSet<>();

		List<Integer> list = new ArrayList<>(2);
		for (int i = 0; i < n; i++) {
			if (set.isEmpty() || set.size() <= k) {
				set.add(numbers[i]);
				continue;
			}
			addMaxToSet(set, numbers[i]);
		}

		return (int) set.toArray()[0];
	}

	private static void addMaxToSet(TreeSet<Integer> set, int i) {
		Iterator<Integer> iterator = set.iterator();
		if (set.pollFirst() < i) {
			iterator.remove();
			set.add(i);
		}
	}

}
