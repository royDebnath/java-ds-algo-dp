package com.programs.array;

import java.util.Arrays;

/**
 * * Java Program to reverse array in place. Time complexity is O(n) 
 * *You cannot use additional buffer but one or two
 * variables are fine. *
 */
public class ArrayReverseInPlace {
  public static void main(String args[]) {
    String[] names = { "John", "Jammy", "Luke" };
    System.out.println("original array: " + Arrays.toString(names));
    // reversing array with three elements
    reverse(names);
    System.out.println("reversed array: " + Arrays.toString(names));
    String[] test = { "John" };
    System.out.println("original array: " + Arrays.toString(test));
    // testing reverse array function with array of just one element
    reverse(test);
    System.out.println("reversed array: " + Arrays.toString(test));
  }

  /** * Java Method to reverse String array in place */
  public static void reverse(String[] array) {
    if (array == null || array.length < 2) {
      return;
    }
    for (int i = 0; i < array.length / 2; i++) {
      String temp = array[i];
      array[i] = array[array.length - 1 - i];
      array[array.length - 1 - i] = temp;
    }
  }

}
