package com.programs.numerics;

public class CheckIfPalindrome {

	private void checkPalindrome(int num) {
		int reverse = 0;
		while (num > 0) {
			int remainder = num % 10;
			reverse = reverse * 10 + remainder;
			num = num / 10;
		}
		if (reverse == num)
			System.out.println(num + " is a Palindrome Number");
		else
			System.out.println(num + " is not a Palindrome Number");

	}
}
