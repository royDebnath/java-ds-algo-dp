package com.programs.array;

public class ArrayQuickSelectKthLargest {

	public static void main(String args[]) {
		int[] intList = { 5, 2, 4, 6, 1, 3 };

		quickSelect(intList, 0, intList.length - 1, 2);
	}

	private static void quickSelect(int[] arr, int start, int end, int k) {
		if (start < end) {
			int partitionIndex = partition(arr, start, end);
			if (partitionIndex == k) {
				System.out.println("kth largest element : " + arr[partitionIndex]);
			} else if (partitionIndex < k - 1) {
				quickSelect(arr, start, partitionIndex - 1, k);
			} else {
				quickSelect(arr, partitionIndex + 1, end, k);
			}
		}
	}

	static int partition(int arr[], int start, int end) {
		int partitionIndex = start;
		int pivot = arr[end];
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				exchange(arr, i, partitionIndex);
				partitionIndex++;
			}
		}
		exchange(arr, partitionIndex, end);
		return partitionIndex;
	}

	private static void exchange(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
