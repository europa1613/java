package com.test.k.nearest.postoffices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*K Nearest Post Offices
Find the k post offices located closest to you, given your location and a list of locations of all post offices available.
Locations are given in 2D coordinates in [X, Y], where X and Y are integers.
Euclidean distance is applied to find the distance between you and a post office.
Assume your location is [m, n] and the location of a post office is [p, q], 
the Euclidean distance between the office and you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
K is a positive integer much smaller than the given number of post offices. from aonecode.com

e.g.
Input
you: [0, 0]
post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
k = 3

Output from aonecode.com
[[-1, 2], [0, 3], [4, 3]] */

public class KNearestPostOffices {

	public static void main(String[] args) {
		int[] you = new int[] { 0, 0 };
		int[][] postOffices = new int[][] { { 0, 3 }, { -16, 5 }, { -1, 2 }, { 4, 3 }, { 10, -2 }, { -5, -9 } };
		int k = 3;

		int[][] result = kNearest(you, postOffices, k);
		System.out.println(Arrays.deepToString(result));

	}

	private static int[][] kNearest(int[] you, int[][] postOffices, int k) {

		int m = you[0];
		int n = you[1];
		List<DistanceMap> distances = new ArrayList<>();

		for (int i = 0; i < postOffices.length; i++) {
			int[] office = postOffices[i];
			int p = office[0];
			int q = office[1];
			double distance = Math.sqrt((m - p) * (m - p) + (n - q) * (n - q));
			distances.add(new DistanceMap(distance, office));

		}

		List<DistanceMap> result = distances.stream()
											.sorted((o1, o2) -> {
												int ret = 0;
												double d1 = o1.getDistance();
												double d2 = o2.getDistance();
												if (d1 < d2) {
													ret = -1;
												} else if (d1 > d2) {
													ret = 1;
												}
												return ret;
											})
											.limit(k)
											.collect(Collectors.toList());
		int[][] res = new int[k][2];
		for (int i = 0; i < result.size(); i++) {
			res[i] = result	.get(i)
							.getOffice();
		}

		return res;
	}

}

class DistanceMap {
	double distance;
	int[] office;

	public DistanceMap(double distance, int[] office) {
		super();
		this.distance = distance;
		this.office = office;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int[] getOffice() {
		return office;
	}

	public void setOffice(int[] office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "DistanceMap [distance=" + distance + ", office=" + Arrays.toString(office) + "]";
	}

}
