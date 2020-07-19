package com.programs.strings;

import java.util.Stack;

public class StringBalance {

	static boolean isBalanced = false;

	public static void main(String[] args) {
		String s = "[{()()}]";
		System.out.println(checkBalanced(s));
	}

	private static boolean checkBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();
		Character normalOpen = '(';
		Character normalClose = ')';
		Character curlyOpen = '{';
		Character curlyClose = '}';
		Character squareOpen = '[';
		Character squareClose = ']';

		for (Character item : s.toCharArray()) {
			if (item == normalOpen || item == curlyOpen || item == squareOpen) {
				stack.push(item);
			}

			if ((item == normalClose || item == curlyClose || item == squareClose)
					&& !isMatchingPair(stack.pop(), item)) {
				return false;
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	static boolean isMatchingPair(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}
}
