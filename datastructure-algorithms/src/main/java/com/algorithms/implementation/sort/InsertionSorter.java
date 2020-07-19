package com.algorithms.implementation.sort;

import com.algorithms.interfaces.ListSorter;

/*
 * 1. If it is the first element, it is already sorted.
 * 2. Pick the next element.
 * 3. Compare with all the elements in sorted sub-list.
 * 4. Shift all the the elements in sorted sub-list that is greater than the value to be sorted.
 * 5. Insert the value.
 * 6. Repeat until list is sorted.
 * 
 * https://www.youtube.com/watch?v=f-f50FjS_jA
 * 
 */

public class InsertionSorter implements ListSorter {

	@Override
	public void sortList(int[] intList) {

		for (int i = 1; i < intList.length; i++) {
			int key = intList[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one
			 * position ahead of their current position
			 */
			while (j >= 0 && key < intList[j]) {
				intList[j + 1] = intList[j];
				j = j - 1;
			}
			intList[j + 1] = key;
		}
	}
}
