package com.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] intArray = new int[] { 13, 9, 1, 5, 3, 7, 6, 12, 2, 14, 4 };
		insertionSort1(intArray);
		Arrays.stream(intArray).forEach(i -> System.out.println(i));
	}

	private static void insertionSort(int[] intArray) {
		for (int i = 1; i < intArray.length;) {
			int j = i - 1;
			int key = intArray[i];
			while (j >= 0 && intArray[j] > key) {
				intArray[j + 1] = intArray[j];
				j--;
			}
			intArray[j + 1] = key;
			i++;
		}

	}

	private static void insertionSort1(int[] intArray) {
		for (int i = 1; i < intArray.length;) {
			int j = i - 1;
			int key = intArray[i];
			for (; j >= 0 && intArray[j] > key; j--) {
				intArray[j + 1] = intArray[j];
			}
			intArray[j + 1] = key;
			i++;
		}
	}

}
