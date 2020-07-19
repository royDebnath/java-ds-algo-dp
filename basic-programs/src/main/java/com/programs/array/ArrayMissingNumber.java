package com.programs.array;

import java.util.Arrays;

public class ArrayMissingNumber {
	/**
	 * Java method to find missing number in array of size n containing numbers
	 * from 1 to n only. can be used to find missing elements on integer array
	 * of numbers from 1 to 100 or 1 - 1000
	 */

	////////// Airthmetic Progression method
	private static int getMissingNumber(int[] numbers, int totalCount) {
		int expectedSum = totalCount * ((totalCount + 1) / 2);
		int actualSum = 0;
		for (int i : numbers) {
			actualSum += i;
		}
		return expectedSum - actualSum;
	}

	// Sort Search Method

	public static void main(String[] args) {
		int[] a = { 1, 7, 3, 5, 6, 8, 10, 9 };
		int l = a.length;
		int c = 1;

		// SORT THE ARRAY
		Arrays.sort(a);

		// CHECK FOR MISSING
		for (int i = 0; i < l; i++) {
			if (a[i] != c) {
				System.out.println(c + " " + "not present");
				c = c + 2;
			} else
				c++;

		}
	}
}
