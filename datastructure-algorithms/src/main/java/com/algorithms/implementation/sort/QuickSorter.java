package com.algorithms.implementation.sort;

import com.algorithms.interfaces.ListSorter;

public class QuickSorter implements ListSorter {
	private int[] numbers;

	@Override
	public void sortList(int[] values) {
		// check for empty or null array
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		quickSort(numbers, 0, numbers.length - 1);
	}

	private void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int partitionIndex = partition(arr, start, end);
			quickSort(arr, start, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}

	int partition(int arr[], int start, int end) {
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

	private void exchange(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}