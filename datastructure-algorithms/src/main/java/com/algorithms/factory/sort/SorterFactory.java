package com.algorithms.factory.sort;

import com.algorithms.constants.SortingType;
import com.algorithms.implementation.sort.BinaryInsertionSorter;
import com.algorithms.implementation.sort.BubbleSorter;
import com.algorithms.implementation.sort.InsertionSorter;
import com.algorithms.implementation.sort.MergeSorter;
import com.algorithms.implementation.sort.QuickSorter;
import com.algorithms.implementation.sort.SelectionSorter;
import com.algorithms.interfaces.ListSorter;

public class SorterFactory {

	public static ListSorter getSorter(SortingType sortingType) {

		if (sortingType == SortingType.INSERTION) {
			return new InsertionSorter();
		}
		else if (sortingType == SortingType.BINARYINSERTION) {
			return new BinaryInsertionSorter();
		}
		else if (sortingType == SortingType.SELECTION) {
			return new SelectionSorter();
		}
		else if (sortingType == SortingType.BUBBLE) {
			return new BubbleSorter();
		}
		else if (sortingType == SortingType.MERGE) {
			return new MergeSorter();
		}
		
		else if (sortingType == SortingType.QUICK) {
			return new QuickSorter();
		}
		return null;

	}

}
