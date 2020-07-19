package com.algorithms.implementation.sort;

import com.algorithms.interfaces.ListSorter;

public class MergeSorter implements ListSorter {

	@Override
	public void sortList(int[] list) {
		mergeSort(list, list.length);
	}

	private void mergeSort(int[] list, int lengthArray) {
		if (lengthArray < 2) {
		return;
		}
			int mid = lengthArray / 2;
			int leftLength = mid;
			int rightLength = lengthArray - mid;
			int[] leftArray = new int[leftLength];
			int[] rightArray = new int[rightLength];

			for (int i = 0; i < leftLength; i++) {
				leftArray[i] = list[i];
			}
			for (int i = mid; i < lengthArray; i++) {
				rightArray[i-mid] = list[i];
			}
			mergeSort(leftArray, mid);
			mergeSort(rightArray,lengthArray-mid);
			merge(leftArray, rightArray, list);
		}
	

	private void merge(int[] leftArray, int[] rightArray, int[] list) {
		int leftIndex = 0;
		int rightIndex = 0;
		int targetIndex = 0;
		while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
			if (leftArray[leftIndex] < rightArray[rightIndex]) {
				list[targetIndex] = leftArray[leftIndex];
				leftIndex++;
				targetIndex++;
			} else {
				list[targetIndex] = rightArray[rightIndex];
				rightIndex++;
				targetIndex++;
			}
		}
		while (leftIndex < leftArray.length) {
			list[targetIndex] = leftArray[leftIndex];
			leftIndex++;
			targetIndex++;
		}
		while (rightIndex < rightArray.length) {
			list[targetIndex] = rightArray[rightIndex];
			rightIndex++;
			targetIndex++;
		}
	}
}
