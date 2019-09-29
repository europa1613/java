package com.test.favorite.genres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*Favorite Genres
Given a map Map<String, List<String>> userMap, where the key is a username and the value is a list of user's songs. 
Also given a map Map<String, List<String>> genreMap, where the key is a genre and the value is a list of songs belonging to this genre. 
The task is to return a map Map<String, List<String>>, where the key is a username and the value is a list of the user's favorite genres. 
Favorite genre is a genre with the most song.

Example :
	Input:
	
		userMap = {  
		   "David": ["song1", "song2", "song3", "song4", "song8"],
		   "Emma":  ["song5", "song6", "song7"]
		},
		
		genreMap = {  
		   "Rock":    ["song1", "song3"],
		   "Dubstep": ["song7"],
		   "Techno":  ["song2", "song4"],
		   "Pop":     ["song5", "song6"],
		   "Jazz":    ["song8", "song9"]
		}
		
	Output: 
		{  
		   "David": ["Rock", "Techno"],
		   "Emma":  ["Pop"]
		}
		
Explanation: 
	David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
	Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
*/
public class FavoriteGenres {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		Map<String, List<String>> result = getFavGenres(getUserMap(), genreMap());
		System.out.println("---------------------: " + (System.currentTimeMillis() - begin));
		System.out.println(result);
	}

	private static Map<String, List<String>> getFavGenres(Map<String, List<String>> userMap,
			Map<String, List<String>> genreMap) {
		Map<String, List<String>> result = new HashMap<>();

		// STEP 1: Replace all songs with their corresponding genres
		Map<String, List<String>> userGenresReplaceSongs = new HashMap<>();
		userMap.forEach((k, v) -> {
			userGenresReplaceSongs.put(k, getGenresBySongs(v, genreMap));
		});

		// STEP 2: Group repeating genres with their count/rank
		Map<String, Map<String, Long>> userToGroupedGenres = new HashMap<>();
		userGenresReplaceSongs.forEach((name, genres) -> {
			System.out.println(name + ":" + genres);
			Map<String, Long> map = genres	.stream()
											.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			System.out.println(map);
			userToGroupedGenres.put(name, map);
		});

		// STEP 3: Get Top Genres - if top value is multiple get all with same count
		userToGroupedGenres.forEach((k, v) -> {
			result.put(k, getTopGenres(v));
		});

		return result;
	}

	private static List<String> getTopGenres(Map<String, Long> v) {
		List<String> res = new ArrayList<>();
		Long topRank = (Long) v	.values()
								.toArray()[0];
		v.forEach((genre, rank) -> {
			if (topRank == rank) {
				res.add(genre);
			}
		});
		return res;
	}

	private static List<String> getGenresBySongs(List<String> v, Map<String, List<String>> genreMap) {
		List<String> genres = new ArrayList<>();
		v.forEach(song -> {
			genreMap.forEach((k, s) -> {
				if (s.contains(song)) {
					genres.add(k);
				}
			});
		});
		return genres;
	}

	public static Map<String, List<String>> getUserMap() {
		Map<String, List<String>> userMap = new HashMap<>();

		userMap.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8", "song9"));
		userMap.put("Emma", Arrays.asList("song5", "song6", "song7", "song8", "song9"));

		return userMap;
	}

	public static Map<String, List<String>> genreMap() {
		Map<String, List<String>> map = new HashMap<>();

		map.put("Rock", Arrays.asList("song1", "song3"));
		map.put("Dubstep", Arrays.asList("song7"));
		map.put("Techno", Arrays.asList("song2", "song4"));
		map.put("Pop", Arrays.asList("song5", "song6"));
		map.put("Jazz", Arrays.asList("song8", "song9"));

		return map;
	}

}
