package com.theory.basics.general;

public class VariableArguments {
	static void varargsMethod(String... strings) {
		for (String s : strings) {
			System.out.println(s);
		}
	}

	static void varargsMethodWithNormalArgument(int i, String... strings) {
		System.out.println("Non-Vararg Argument" + i);
		for (String s : strings) {
			System.out.println(s);
		}
	}

	static void varargsMethodPrimitiveArgument(int... integers) {
		for (int i : integers) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		varargsMethod("One Argument");
		varargsMethod("First Argument", "Second Argument", "Third Argument");
		varargsMethod(); // No argument

		varargsMethodWithNormalArgument(2, "Hello");
		varargsMethodWithNormalArgument(2); // Zero varargs is fine. no error

		varargsMethodPrimitiveArgument(1, 2, 3);

	}
}
/*
 * Rules:
 * 
 * 1 : There can be only one variable argument in a method 
 * 2 : The variable argument has to be the last argument
 * 
 */
