package com.theory.basics.general;

public class _008_PassingPrimitiveVariable {
	public static void main(String[] args) {
		int a = 1;
		_008_PassingPrimitiveVariable ppv = new _008_PassingPrimitiveVariable();

		System.out.println("Before modify() a = " + a);
		ppv.modify(a);
		System.out.println("After modify() a = " + a);
	}

	/*
	 * If Java passes objects by passing the reference variable instead, does
	 * that mean Java uses pass-by-reference for objects? Not exactly, although
	 * you'll often hear and read that it does. Java is actually pass-by-value
	 * for all variables running within a single VM. Pass-by-value means
	 * pass-by-variable-value. And that means pass-by-copy-ofthe- variable!
	 * (There's that word copy again!) It makes no difference if you're passing
	 * primitive or reference variables; you are always passing a copy of the
	 * bits in the variable. So for a primitive variable, you're passing a copy
	 * of the bits representing the value. For example, if you pass an int
	 * variable with the value of 1, you're passing a copy of the bits
	 * representing 1. The called method then gets its own copy of the value to
	 * do with it what it likes. At the end of the method call the original
	 * value of the variable does not change because only a copy of the value
	 * was passed.
	 */
	void modify(int number) {
		number = number + 1;
		System.out.println("number = " + number);
	}

}
