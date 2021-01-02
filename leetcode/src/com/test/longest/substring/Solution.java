package com.test.longest.substring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

class Solution {

	public static void main(String[] args) {
		int substring = lengthOfLongestSubstring("abcabcbb");
		System.out.println(substring);
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		
		LinkedList<Integer> list = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>();
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
		}
		Collection<Integer> values = map.values();
		for(Integer value: values) {
			
		}
		Set<String> keys = map.keySet();
		
		TreeSet<Integer> ints = new TreeSet<>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		Iterator<Integer> iterator = ints.iterator();
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		System.out.println(ints);
		
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