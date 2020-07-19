package com.algorithms.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.algorithms.constants.SortingType;
import com.algorithms.factory.sort.SorterFactory;
import com.algorithms.interfaces.ListSorter;

public class QuickSorterTest {

	@Test
	public void test() {
		int[] intList = { 5, 2, 4, 6, 1, 3 };
		int[] sortedIntList = { 1, 2, 3, 4, 5, 6 };
		ListSorter sorter = SorterFactory.getSorter(SortingType.QUICK);
		sorter.sortList(intList);
		assertArrayEquals(intList, sortedIntList);
	}

}
