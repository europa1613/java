package com.test.cellsstate.ndays;

/* Cell State After N Days
Eight houses, represented as cells, are arranged in a straight line. 
Each day every cell competes with its adjacent cells (neighbors). 
An integer value 1 represents an active cell and a value of 0 represents an inactive cell. 
If the neighbors on both the sides of a cell are either active or inactive, the cell becomes inactive on the next day; 
otherwise the cell becomes active. 
The two cells on each end have a single adjacent cell, so assume that the unoccupied space on the opposite side is an inactive cell. 
Even after updating the cell state, consider its previous state when updating the state of other cells. 
The state information of all cells should be updated simultaneously.
Write an algorithm to output the state of the cells after the given number of days.

Input
	The input to the function/method consists of two arguments:
	states, a list of integers representing the current state of cells;
	days, an integer representing the number of days.

Output
	Return a list of integers representing the state of the cells after the given number of days.

Examples 1
	Input:
		[1, 0, 0, 0, 0, 1, 0, 0], 1

Output:
		0 1 0 0 1 0 1 0

Examples 2
	Input:
		[1, 1, 1, 0, 1, 1, 1, 1], 2

	Output:
		0 0 0 0 0 1 1 0*/

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.*;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public List<Integer> cellCompete(int[] states, int days) {
		List<Integer> result = this.findState(states, days);

		System.out.println("result:" + result);

		return result;
	}
	// METHOD SIGNATURE ENDS

	private List<Integer> findState(int[] states, int days) {
		int leftMost = 0;
		int rightMost = 0;
		System.out.println("days:" + days + "; states: " + Arrays.toString(states));
		while (days > 0) {
			int[] copy = Arrays.copyOf(states, states.length);
			for (int i = 0; i < states.length; i++) {
				int j = i - 1;
				int k = i + 1;

				int prev = i == 0 ? leftMost : copy[j];
				int current = copy[i];
				int next = i == states.length - 1 ? rightMost : copy[k];

				if (prev == next) {
					states[i] = 0;
				} else {
					states[i] = 1;
				}

			}

			--days;
			// findState(states, --days);
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < states.length; i++) {
			result.add(states[i]);
		}

		return result;

	}
}