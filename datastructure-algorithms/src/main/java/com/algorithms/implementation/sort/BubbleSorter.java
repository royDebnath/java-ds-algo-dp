package com.algorithms.implementation.sort;

import com.algorithms.interfaces.ListSorter;

public class BubbleSorter implements ListSorter {

	@Override
	public void sortList(int[] list) {
		boolean didSwap = false;
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j + 1] < list[j]) {
					swap(list, j);
					didSwap = true;
				}
			}
			if (!didSwap) {
				break;
			}
		}
	}

	private void swap(int[] list, int i) {
		int k = list[i];
		list[i] = list[i + 1];
		list[i + 1] = k;
	}

}
