package com.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = {20, 35, -15, 7, 55, 1, -22};
		
		for(int length = array.length - 1; length > 0; length--) {
			for(int i = 0; i < length; i++) {
				if(array[i] > array[i+1]) {
					swap(array, i,  i+1);
				}
			}
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	public static void swap(int[] array, int i, int j) {
		if( i== j) {
			return;
		} else {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		
	}

}
