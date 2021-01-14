package com.programs.array;

import java.util.Arrays;

public class RotateArrayByOneBit {
	public static void main(String[] args) {
		int[] intArray = new int[] { 13, 9, 1, 5, 3, 7, 6, 12, 2, 14, 4 };
		int[] rotateArray = rotateArray(intArray, 2);
		Arrays.stream(rotateArray).forEach(System.out::println);
	}
	
	private static int[] rotateArray(int[] intArray, int rotationFactor) {
		int length = intArray.length;
		int[] backupArray = new int[rotationFactor];
		for (int i = 0; i < rotationFactor; i++) {
			backupArray[i] = intArray[length - rotationFactor + i];
		}
		int[] rotatedArray = new int[length];
		for (int i = 0; i < length - rotationFactor; i++) {
			rotatedArray[i + rotationFactor] = intArray[i];
		}
		for (int i = 0; i < backupArray.length; i++) {
			rotatedArray[i] = backupArray[i];
		}
		return rotatedArray;
	}
}
