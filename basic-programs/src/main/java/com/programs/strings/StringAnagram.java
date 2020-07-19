package com.programs.strings;

import java.util.Arrays;

public class StringAnagram {
	public boolean isAnagramSorted(String firstWord, String secondWord) {
		char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
		char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
		Arrays.sort(word1);
		Arrays.sort(word2);
		return Arrays.equals(word1, word2);
	}

	/*
	 * String Anagram: not sort method
	 * 
	 * In this method, we go on checking each character of first string is
	 * present in second string. If it is present, we remove that character from
	 * second string and proceed to next character. If any character of first
	 * string is not present in second string, we break the loop and conclude
	 * that strings are not anagrams.
	 * 
	 */

	static void isAnagramNotSorted(String s1, String s2) {
		// Removing white spaces from s1 and s2 and changing case to lower

		String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();

		String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();

		// Initially setting status as true

		boolean status = true;

		if (copyOfs1.length() != copyOfs2.length()) {
			// Setting status as false if copyOfs1 and copyOfs2 doesn't have
			// same length

			status = false;
		} else {
			// Converting copyOfs1 to char array

			char[] s1ToArray = copyOfs1.toCharArray();

			// Checking whether each character of s1ToArray is present in
			// copyOfs2

			for (char c : s1ToArray) {
				int index = copyOfs2.indexOf(c);

				if (index != -1) {
					// If character is present in copyOfs2, removing that char
					// from copyOfs2

					copyOfs2 = copyOfs2.substring(0, index) + copyOfs2.substring(index + 1, copyOfs2.length());
				} else {
					// If character is not present in copyOfs2, setting status
					// as false and breaking the loop

					status = false;

					break;
				}
			}
		}

		// Output

		if (status) {
			System.out.println(s1 + " and " + s2 + " are anagrams");
		} else {
			System.out.println(s1 + " and " + s2 + " are not anagrams");
		}
	}

}
