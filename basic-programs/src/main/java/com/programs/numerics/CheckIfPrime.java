package com.programs.numerics;

public class CheckIfPrime {
	/*
	 * 
	 * If a number n is not a prime, it can be factored into two factors a and b:
	 * n = axb
     * If both a and b were greater than the square root of n, axb would be greater than n.
     * So at least one of those factors must be less than or equal to the square root of n, 
     * and to check if n is prime, we only need to test for factors less than or equal to the square root.
     * 
     * The square root of 100 is 10. Let's say a x b = 100, for various pairs of a and b.
     * If a == b, then they are equal, and are the square root of 100, exactly. Which is 10.
     * If one of them is less than 10, the other has to be greater. For example, 5 x 20 == 100. 
     * One is greater than 10, the other is less than 10.
     * Thinking about a x b, if one of them goes down, the other must get bigger to compensate, 
     * so the product stays at 100. They pivot around the square root.
	 * 
	 * */
	public static boolean isPrime(int n) {
	       if (n <= 1) {
	           return false;
	       }
	       for (int i = 2; i < Math.sqrt(n); i++) {
	           if (n % i == 0) {
	               return false;
	           }
	       }
	       return true;
	   }
	}

