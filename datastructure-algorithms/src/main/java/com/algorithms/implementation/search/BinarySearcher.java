package com.algorithms.implementation.search;

import com.algorithms.interfaces.ListSearcher;

public class BinarySearcher implements ListSearcher {

	@Override
	public int searchList(int[] intList, int key) {

		int left = 0;
		int right = intList.length - 1;

		while (left <= right) {
			int middle = (left + right) / 2;
			if (key == intList[middle]) {
				return middle;
			} else if (key < intList[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return -1;
	}
}
