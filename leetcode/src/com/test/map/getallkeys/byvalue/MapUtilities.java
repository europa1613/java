package com.test.map.getallkeys.byvalue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtilities {

	/*
	 * Get the all the keys associated with given Value V from map
	 */
	static <K, V> List<K> getAllKeysForValue(Map<K, V> mapOfWords, V value) {
		List<K> listOfKeys = null;

		// Check if Map contains the given value
		if (mapOfWords.containsValue(value)) {
			// Create an Empty List
			listOfKeys = new ArrayList<>();

			// Iterate over each entry of map using entrySet
			for (Map.Entry<K, V> entry : mapOfWords.entrySet()) {
				// Check if value matches with given value
				if (entry	.getValue()
							.equals(value)) {
					// Store the key from entry to the list
					listOfKeys.add(entry.getKey());
				}
			}
		}
		// Return the list of keys whose value matches with given value.
		return listOfKeys;
	}

	public static void main(String[] args) {

		// Create a Map of words and thier frequency count
		HashMap<String, Integer> mapOfWords = new HashMap<String, Integer>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2992252982491002380L;

			{
				put("John", 25);
				put("at", 2);
				put("from", 10);
				put("is", 5);
				put("the", 2);
				put("hello", 1);
				put("break", 25);
			}
		};

		// Get the list of keys whose value matches with given value.
		List<String> listOfKeys = MapUtilities.getAllKeysForValue(mapOfWords, 2);

		System.out.println(listOfKeys);

	}
}