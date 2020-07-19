package com.theory.basics.general;

/* Autoboxing is the process by which a primitive type is automatically encapsulated (boxed)
 *  into its equivalent type wrapper whenever an object of that type is needed. 
 *  There is no need to explicitly construct an object. Auto-unboxing is the process by which
 *  the value of a boxed object is automatically extracted (unboxed) from a type wrapper when its value is needed. 
 *  There is no need to call a method such as intValue( ) or doubleValue( ).
*/
public class AutoBoxingUnBoxing {
	public static void main(String[] args) {
		Integer iOb = 100; // autobox an int
		new Integer(100); // Explicit Boxing
		int i = iOb; // auto-unbox
		i = iOb.intValue(); // Explicit Unboxing
		System.out.println(i);
	}
}
