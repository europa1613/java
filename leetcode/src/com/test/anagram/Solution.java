package com.test.anagram;

import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		char[] input = s.toCharArray();
		char[] test = t.toCharArray();
		Arrays.sort(input);
		Arrays.sort(test);
		boolean result = true;
		for (int i = 0; i < input.length; i++) {
			if (input[i] != test[i]) {
				return false;
			}
		}
		return result;
	}
}