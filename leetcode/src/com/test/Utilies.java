package com.test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Utilies {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays	.stream(nums)
									.boxed()
									.collect(Collectors.toList()));
	}

}
