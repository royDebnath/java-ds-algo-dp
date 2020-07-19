package com.algorithms.unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.algorithms.constants.SearchingType;
import com.algorithms.factory.search.SearchingFactory;
import com.algorithms.interfaces.ListSearcher;

public class BinarySearcherTest {

	@Test
	public void test() {
		int[] intList = {1,3,6,9,11,24,46,54,67,86,91,99};
		ListSearcher searcher = SearchingFactory.getSearcher(SearchingType.BINARY);
		int keyIndex = searcher.searchList(intList, 86);
		assertEquals(keyIndex, 9);
	}

}
