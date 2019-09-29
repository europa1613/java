package com.test.median.twosortedarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays	.stream(nums1)
							.boxed()
							.collect(Collectors.toList()));
		list.addAll(Arrays	.stream(nums2)
							.boxed()
							.collect(Collectors.toList()));

		/*
		 * double average = list .stream() .mapToInt(item -> item.intValue()) .average()
		 * .orElse(0)
		 */;

		List<Integer> list2 = list	.stream()
									.sorted()
									.collect(Collectors.toList());
		double res;
		if (list2.size() % 2 == 0) {
			int position = list2.size() / 2;
			res = (list2.get(position) + Double.valueOf(list2.get(position - 1))) / 2;

		} else {
			int position = list2.size() / 2;
			res = list2.get(position);
		}

		return res;

	}
}