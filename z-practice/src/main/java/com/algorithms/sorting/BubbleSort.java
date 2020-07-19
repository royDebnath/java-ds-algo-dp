package com.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] intArray = new int[] { 13, 9, 1, 5, 3, 7, 6, 12, 2, 14, 4, 19, 20, 21};	
		bubbleSort(intArray);
		Arrays.stream(intArray).forEach(i -> System.out.println(i));

		int[] intArray1 = new int[] { 13, 9, 1, 5, 3, 7, 6, 12, 2, 14, 4, 19, 20, 21 };
		bubbleSortOptimized(intArray1);
		Arrays.stream(intArray1).forEach(i -> System.out.println(i));
	}

	private static void bubbleSort(int[] intArray) {
		int length = intArray.length;
		int passCount = 0;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (intArray[j] > intArray[j + 1]) {
					swap(intArray, j);
				}
			}
			passCount++;
		}
		System.out.println("Number of Pass : " + passCount);
	}

	private static void bubbleSortOptimized(int[] intArray) {
		int length = intArray.length;
		int passCount = 0;
		for (int i = 0; i < length - 1; i++) {
			boolean didSwap = false;
			for (int j = 0; j < length - i - 1; j++) {
				if (intArray[j] > intArray[j + 1]) {
					swap(intArray, j);
					didSwap = true;
				}
			}
			if (!didSwap) {
				break;
			}
			passCount++;
		}
		System.out.println("Number of Pass : " + passCount);
	}

	private static void swap(int[] intArray, int i) {
		int temp = intArray[i];
		intArray[i] = intArray[i + 1];
		intArray[i + 1] = temp;

	}

}
