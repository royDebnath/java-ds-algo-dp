package com.programs.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayCheckDuplicate {

	/*
	 * brute force way of checking if array contains duplicates in Java
	 * comparing each element to all other elements of array complexity on order
	 * of O(n^2) not advised in production
	 */
	public static boolean bruteforce(String[] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (input[i].equals(input[j]) && i != j) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * detect duplicate in array by comparing size of List and Set since Set
	 * doesn't contain duplicate, size must be less for an array which contains
	 * duplicates
	 */
	public static boolean checkDuplicateUsingSet(String[] input) {
		List<String> inputList = Arrays.asList(input);
		Set<String> inputSet = new HashSet<>(inputList);
		if (inputSet.size() < inputList.size()) {
			return true;
		}
		return false;
	}

	/*
	 * Since Set doesn't allow duplicates add() return false if we try to add
	 * duplicates into Set and this property can be used to check if array
	 * contains duplicates in Java
	 */
	public static boolean checkDuplicateUsingAdd(String[] input) {
		Set<String> tempSet = new HashSet<>();
		for (String str : input) {
			if (!tempSet.add(str)) {
				return true;
			}
		}
		return false;
	}

}
