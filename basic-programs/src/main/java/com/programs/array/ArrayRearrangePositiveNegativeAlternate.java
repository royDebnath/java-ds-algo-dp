package com.programs.array;

import java.util.*;

public class ArrayRearrangePositiveNegativeAlternate {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = s.nextInt();
		rearrange(a);
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
	}

	public static void rotateright(int a[], int l, int r) {
		int temp = a[r];
		for (int i = r; i > l; i--) {
			a[i] = a[i - 1];
		}
		a[l] = temp;
	}

	public static void rearrange(int a[]) {
		int n = a.length;
		int i = 0, j = 0;
		while (i < n) {
			if (i % 2 == 0) // even index should have positive element
			{
				if (a[i] > 0) // already positive
					i++;
				else // for negative
				{
					j = i + 1;
					while (j < n) // finding next positive
					{
						if (a[j] > 0)
							break;
						j++;
					}
					rotateright(a, i, j); // making even index positive
					i++;
				}
			} else // odd index should have negative element
			{
				if (a[i] < 0) // already negative
					i++;
				else // for positive
				{
					j = i + 1;
					while (j < n) // finding next negative
					{
						if (a[j] < 0)
							break;
						j++;
					}
					rotateright(a, i, j); // making odd index negative
					i++;
				}
			}
		}
	}
}
