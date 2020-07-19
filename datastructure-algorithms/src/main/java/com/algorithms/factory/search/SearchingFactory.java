package com.algorithms.factory.search;

import com.algorithms.constants.SearchingType;
import com.algorithms.implementation.search.BinarySearcher;
import com.algorithms.implementation.search.RecursiveBinarySearcher;
import com.algorithms.interfaces.ListSearcher;

public class SearchingFactory {

	public static ListSearcher getSearcher(SearchingType searchingType) {

		if (searchingType == SearchingType.BINARY) {
			return new BinarySearcher();
		}
		else if(searchingType == SearchingType.RECURSIVEBINARY) {
			return new RecursiveBinarySearcher();
		}
		return null;
	}
}
