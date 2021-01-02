package com.binarysearch;

public class BinarySearch {

	public static void main(String[] args) {

		int[] array = { -22, -15, 1, 7, 20, 35, 55 };

		System.out.println(iterativeSearch(array, 35));
		System.out.println(iterativeSearch(array, -15));
		System.out.println(iterativeSearch(array, 888));
		System.out.println(iterativeSearch(array, 7));

		System.out.println(recursiveSearch(array, 35));
		System.out.println(recursiveSearch(array, -15));
		System.out.println(recursiveSearch(array, 888));
		System.out.println(recursiveSearch(array, 7));
	}

	public static int iterativeSearch(int[] array, int value) {
		int start = 0;
		int end = array.length;

		while (start < end) {
			int mid = (start + end) / 2;
			if (array[mid] == value) {
				return mid;
			} else if (value < array[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}

	public static int recursiveSearch(int[] array, int value) {
		return recursiveSearch(array, 0, array.length, value);
	}

	public static int recursiveSearch(int[] array, int start, int end, int value) {
		if (start >= end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (value == array[mid]) {
			return mid;
		} else if (value < array[mid]) {
			return recursiveSearch(array, start, mid, value);
		} else {
			return recursiveSearch(array, mid + 1, end, value);
		}
	}

}
