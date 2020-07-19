package com.algorithms.implementation.sort;

import com.algorithms.interfaces.ListSorter;

public class SelectionSorter implements ListSorter {

	@Override
	public void sortList(int[] list) {

		for (int i = 0; i < list.length; i++) {
			int j = i + 1;
			while (j < list.length) {
				if (list[j] < list[i]) {
					swap(list, i, j);
				}
				j++;
			}
		}
	}

	private void swap(int[] list, int i, int j) {
		int k = list[i];
		list[i] = list[j];
		list[j] = k;
	}

}
