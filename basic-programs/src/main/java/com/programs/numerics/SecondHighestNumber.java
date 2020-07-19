package com.programs.numerics;

import java.util.Arrays;

public class SecondHighestNumber {
	public static int secondHighest(int[] numbers) {
		int max1, max2;
		max1 = max2 = 0;
		for (int number : numbers) {
			if (number > max1) {
				max2 = max1;
				max1 = number;
			} else if (number > max2) {
				max2 = number;
			}
		}
		return max2;
	}

	public static void topTwo2(int[] numbers) {
		Arrays.sort(numbers);

		System.out.println(numbers[numbers.length - 2]);
		System.out.println(numbers[numbers.length - 1]);

	}

}
