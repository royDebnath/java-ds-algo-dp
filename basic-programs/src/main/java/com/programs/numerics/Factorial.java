package com.programs.numerics;

public class Factorial {

	public static int factorialIterative(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			int result = 1;
			for (int i = 1; i <= n; i++) {
				result = result * i;
			}
			return result;
		}
	}

	public static int factorialRecursion(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorialRecursion(n - 1);
		}
	}

	public static int factorial(int n) {
		System.out.println("Calculating : F(" + n + ")");
		if (n == 0) {
			int x = 1;
			System.out.println("Done : F(0)" + "-->" + x);

			return 1;
		}
		int next=n-1;
		int f = n * factorial(next);
		System.out.println("Done : F(" + n + ")" + "-->" + f+" ("+n+"*factorial("+next+")");
		return f;
	}

}
