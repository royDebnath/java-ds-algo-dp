package com.programs.strings;

import java.util.*;

public class StringReverse {
	public static void main(String args[]) {
		String original, reverse = "";
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a string to reverse");
		original = in.nextLine();

		int length = original.length();

		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + original.charAt(i);
		reverseRecursively(original);

		System.out.println("Reverse of entered string is: " + reverse);
		in.close();
	}

	public static String reverseRecursively(String str) {

		// base case to handle one char string and empty string
		if (str.length() < 2) {
			return str;
		}

		return reverseRecursively(str.substring(1)) + str.charAt(0);

	}
	
    /*
     * Java method to replace a String in place
     */
    public static String inPlaceReverse(final String input) {
        final StringBuilder builder = new StringBuilder(input);
        int length = builder.length();
        for (int i = 0; i < length / 2; i++) {
            final char current = builder.charAt(i);
            final int otherEnd = length - i - 1;
            builder.setCharAt(i, builder.charAt(otherEnd)); // swap
            builder.setCharAt(otherEnd, current);
        }

        return builder.toString();
    }
}
