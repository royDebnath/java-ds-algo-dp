package com.programs.numerics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinChange {
	/*
	 * write a program to find all pairs of integers whose sum is equal to a
	 * given number. For example if input integer array is {2, 6, 3, 9, 11} and
	 * given sum is 9, output should be {6,3}.
	 */

	public static void main(String args[]) {
		Integer[] numbers = { 2, 4, 3, 5, 7, 8, 9 };
		int sum = 7;
		List<Integer> Numbers = Arrays.asList(numbers);
		Collections.sort(Numbers);
		for (int i : Numbers) {
			if (Numbers.contains(sum - i) && i <= (sum / 2) && i != (sum - i)) {
				System.out.print((sum - i) + " & ");
				System.out.println(+i);
			}
			/*
			 * The condition i<=(sum/2) is required to prevent double repetition
			 * of pairs (2 & 5) and (5 & 2). The condition i!=(sum-i) is
			 * required to prevent same number in paring. (For example, if your
			 * sum is 8, then if you don't use this condition, you will also get
			 * pair (4,4) ).
			 */
		}
	}

}
