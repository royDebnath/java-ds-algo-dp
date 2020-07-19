package com.programs.strings;

public class StringRemoveGivenCharacter {

	public static String remove(String word, char unwanted) {
		StringBuilder sb = new StringBuilder();
		char[] letters = word.toCharArray();
		for (char c : letters) {
			if (c != unwanted) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	// Recursive
	public static String removeRecursive(String word, char unwanted) {
		int index = word.indexOf(unwanted);
		if (index == -1) {
			return word;
		}
		return removeRecursive(word.substring(0, index) + word.substring(index + 1, word.length()), unwanted);
	}

}
