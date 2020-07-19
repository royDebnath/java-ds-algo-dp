package com.programs.numerics;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		int n, a = 0, b = 0, c = 1;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter value of n:");
		n = s.nextInt();
		System.out.print("Fibonacci Series:");
		for (int i = 1; i <= n; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.print(a + " ");
		}
		s.close();
	}

	public static int fibonacci(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		return fibonacci(number - 1) + fibonacci(number - 2);
	}

}
