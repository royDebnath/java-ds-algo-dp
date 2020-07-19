package com.parctice;

import java.util.Arrays;
import java.util.List;

public class Ltest {
	public static void main(String[] args) {

		String s = "debnath";
		List<Integer> roll = Arrays.asList(1, 2, 3);
		System.out.println(rollTheString(s, roll));
	}

	public static String rollTheString(String s, List<Integer> roll) {
		for(int i : roll){
			 s = fwdCharacters(s, i);
			}
		return s;
	}

	private static String fwdCharacters(String s, int tillIndex) {
		String newString = "";
		char[] charArray = s.toCharArray();
		for (int i = 0; i <= tillIndex; i++) {
			char nextChar = ++charArray[i];
			newString += nextChar;
		}
		for (int i = tillIndex + 1; i < charArray.length; i++) {
			newString += charArray[i];
		}
		return newString;
	}
}
