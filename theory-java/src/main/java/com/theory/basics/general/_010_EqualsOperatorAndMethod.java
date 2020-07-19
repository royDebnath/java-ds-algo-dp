package com.theory.basics.general;

import com.theory.support.Budgie;

/*
The equals() Method in Class Object
The equals() method in class Object works the same way that the == operator works. If two references point to
the same object, the equals() method will return true. If two references point to different objects,
even if they have the same values, the method will return false.

The equals() Method in Class String 
The equals() method in class String has been overridden. When the equals() method is used to compare two strings, 
it will return true if the strings have the same value, and it will return false if the strings have different values. 
For String's equals() method, values ARE case sensitive.
 */
public class _010_EqualsOperatorAndMethod {
	public static void main(String[] args) {

		Budgie b1 = new Budgie();
		Budgie b2 = new Budgie();
		Budgie b3 = b1;
		String s1 = "Bob";
		String s2 = "Bob";
		String s3 = "bob"; // lower case "b"
		System.out.println(b1.equals(b2)); // false, different objects
		System.out.println(b1.equals(b3)); // true, same objects
		System.out.println(s1.equals(s2)); // true, same values
		System.out.println(s1.equals(s3)); // false, values are case sensitive
	}

}
