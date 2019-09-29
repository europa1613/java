package com.test.longest.substring;

import java.util.HashSet;
import java.util.Set;

class Solution {

	public static void main(String[] args) {
		int substring = lengthOfLongestSubstring("abcabcbb");
		System.out.println(substring);
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	public static int lengthOfLongestSubstring(String s) {

		char[] chars = s.toCharArray();
		System.out.println(chars);
		Set<Character> set = new HashSet<>();
		int res = 1;
		for (int i = 0; i < chars.length; i++) {
			if (set.add(chars[i])) {
				++res;
			} else {
				res = res > 1 ? res : 1;
			}
		}
		System.out.println(set);
		return res - 1;
	}
}