package com.test.movie.duration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*You are on a flight and wanna watch two movies during this flight. 
You are given int[] movie_duration which includes all the movie durations. 
You are also given the duration of the flight which is d in minutes. 
Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min). 
Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.

e.g. 
Input
movie_duration: [90, 85, 75, 60, 120, 150, 125]
d: 250

Output from aonecode.com
[90, 125]
90min + 125min = 215 is the maximum number within 220 (250min - 30min)*/

public class MovieDuration {

	public static void main(String[] args) {
		//{ 90, 100, 85, 75, 60, 120, 150, 125 } - 100, 120
		//{ 90, 65, 85, 75, 60, 120, 150, 125 } - 65, 150 
		//{ 90, 85, 75, 60, 120, 150, 125 } - 90, 125
		int[] selectedMovies = selectedMovies(new int[] { 90, 100, 85, 75, 60, 120, 150, 125 }, 250, 30);
		List<Integer> list = IntStream	.of(selectedMovies)
										.boxed()
										.collect(Collectors.toList());
		System.out.println(list);
		//Integer.MIN_VALUE;
		
		//Arrays.sort(selectedMovies);
	}

	public static int[] selectedMovies(int[] movies, int d, int offset) {

		int threshold = d - offset;
		int res1 = 0;
		int res2 = 0;
		int totalLength = 0;
		for (int i = 0; i < movies.length; i++) {
			for (int j = i + 1; j < movies.length; j++) {
				if (totalLength <= movies[i] + movies[j] && movies[i] + movies[j] <= threshold) {
					if (totalLength == movies[i] + movies[j]) {
						if (res1 < movies[i] || res2 < movies[j]) {
							res1 = movies[i];
							res2 = movies[j];
						}
					} else {
						res1 = movies[i];
						res2 = movies[j];
					}
					totalLength = movies[i] + movies[j];
				}
			}
		}

		return new int[] { res1, res2 };
	}
}
