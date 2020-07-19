package com.parctice;

public class pr1 {

	public static void main(String[] args) {

		System.out.println(factorial(4));

	}

	private static int factorial(int n) {
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
