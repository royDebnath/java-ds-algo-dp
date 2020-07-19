package com.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] intArray = new int[] { 13, 9, 1, 5, 3, 7, 6, 12, 2, 14, 4 };
		selectionSort(intArray);
		Arrays.stream(intArray).forEach(i -> System.out.println(i));
	}

	private static void selectionSort(int[] intArray) {
		int length = intArray.length;
		for (int j = 0; j < intArray.length;j++) {
			int smallestIndex = j;
			for (int i = j; i < length - 1; i++) {
				if (intArray[i + 1] < intArray[smallestIndex]) {
					smallestIndex = i + 1;
				}
			}
			swap(intArray, j, smallestIndex);
		}
	}

	private static void swap(int[] intArray, int j, int smallestIndex) {
		int temp = intArray[j];
		intArray[j] = intArray[smallestIndex];
		intArray[smallestIndex] = temp;
	}
}
