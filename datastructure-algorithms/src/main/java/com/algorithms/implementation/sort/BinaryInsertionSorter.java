package com.algorithms.implementation.sort;

import com.algorithms.interfaces.ListSorter;

public class BinaryInsertionSorter implements ListSorter {

	@Override
	public void sortList(int[] list) {
		for (int i = 1; i <= list.length - 1; i++) {
			int left = 0;
			int right = i;

			while (left < right) {
				int middle = (left + right) / 2;
				if (list[i] >= list[middle]) {
					left = middle + 1;
				} else {
					right = middle;
				}
			}
			for (int j = i; j > left; j--) {
				swap(list, j);

			}

		}
	}

	private void swap(int[] list, int j) {
		int k = list[j];
		list[j] = list[j - 1];
		list[j - 1] = k;
	}
}
