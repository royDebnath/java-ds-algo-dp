package com.datastructure.array;

import java.util.Arrays;

public class MwayMerging {

	public static void main(String[] args) {
		int[] intArray1 = new int[] { 9, 12, 15, 16, 19, 87, 98 };
		int[] intArray2 = new int[] { 7, 9, 12, 34, 56, 87, 98, 99, 100, 101, 103, 106 };
		int[] intArray3 = new int[] { 1, 23, 34 };
		int[] intArray4 = new int[] { 1, 2, 3, 4, 5, 6 };

		mWayMerge(new int[][] { intArray1, intArray2, intArray3, intArray4 });
	}

	private static void mWayMerge(int[][] arrays) {
		// The Final Merged Array Length
		int resultArrayLength = getResultArrayLength(arrays);

		// Total Number of Input Arrays
		int noOfArrays = arrays.length;

		// Holds the cursor position of each array
		int[] cursorPositions = new int[noOfArrays];

		// The Final Merged Array
		int[] resultArray = new int[resultArrayLength];

		// Keeps track of the result array index
		int resultArrayCounter = 0;

		for (int i = 0; i < resultArrayLength; i++) {
			int cursorToIncrement = 0;
			int arrayIdCounter = 0;
			int nextArrayId = 1;
			if (cursorPositions[arrayIdCounter] >= arrays[arrayIdCounter].length) { // If the array we start with is
				break;															    // completely traversed in course of
			}																	    // the calculation
				
			int min = arrays[arrayIdCounter][cursorPositions[arrayIdCounter]];
			while (arrayIdCounter < noOfArrays) {
				if (nextArrayId == noOfArrays) {
					break;
				}
				if (cursorPositions[nextArrayId] < arrays[nextArrayId].length
						&& arrays[nextArrayId][cursorPositions[nextArrayId]] <= arrays[arrayIdCounter][cursorPositions[arrayIdCounter]]) {
					min = arrays[nextArrayId][cursorPositions[nextArrayId]];
					cursorToIncrement = nextArrayId;
					arrayIdCounter++;
				}
				nextArrayId++;
			}
			resultArray[i] = min;
			resultArrayCounter++;
			cursorPositions[cursorToIncrement]++;

		}

		for (int i = 0; i < noOfArrays; i++) {
			if (arrays[i].length > cursorPositions[i]) {
				int extraCounter = cursorPositions[i];
				for (int j = extraCounter; j < arrays[i].length; j++) {
					resultArray[resultArrayCounter] = arrays[i][extraCounter];
					resultArrayCounter++;
					extraCounter++;
				}
			}
		}
		Arrays.stream(resultArray).forEach(element -> System.out.println(element));

	}

	private static int getResultArrayLength(int[][] arrays) {
		int resultArrayLength = 0;
		for (int i = 0; i < arrays.length; i++) {
			resultArrayLength += arrays[i].length;
		}
		return resultArrayLength;
	}

}
