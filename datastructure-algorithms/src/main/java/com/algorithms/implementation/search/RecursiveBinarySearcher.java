package com.algorithms.implementation.search;

import com.algorithms.interfaces.ListSearcher;

public class RecursiveBinarySearcher implements ListSearcher {

	@Override
	public int searchList(int[] intList, int key) {
		return recursiveBinarySearch(intList, 0, intList.length - 1, key);

	}

	private int recursiveBinarySearch(int[] intList, int left, int right, int key) {
		if (right >= left) {
			int middleIndex = left + (right - left) / 2;
			if (intList[middleIndex] == key) {
				return middleIndex;
			} else if (key < intList[middleIndex]) {
			return	recursiveBinarySearch(intList, left, middleIndex - 1, key);
			} else {
				return recursiveBinarySearch(intList, middleIndex + 1, right, key);
			}
		}
		return -1;
	}

}
