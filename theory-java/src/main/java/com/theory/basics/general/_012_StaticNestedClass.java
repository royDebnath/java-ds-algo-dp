package com.theory.basics.general;

/*
 * The final type of nested class is not an inner class. 
 * A static nested class is a static class defined at the member level. 
 * It can be instantiated without an object of the enclosing class, 
 * so it can’t access the instance variables without an explicit object of the enclosing class. 
 * For example, new OuterClass().var allows access to the instance variable var.
	
In other words, it is like a regular class except for the following:
■■ The nesting creates a namespace because the enclosing class name must be used to refer to it.
■■ It can be made private or use one of the other access modifiers to encapsulate it.
■■ The enclosing class can refer to the fields and methods of the static nested class.

 * */
public class _012_StaticNestedClass {
	static class Nested {
		private int price = 6;
	}

	public static void main(String[] args) {
		Nested nested = new Nested();
		System.out.println(nested.price);
	}

}

/*Importing a static Nested Class

import bird.Toucan.Beak; // regular import ok

And since it is static, alternatively you can use a static import:

import static bird.Toucan.Beak;

Java treats the static nested class as if it were a namespace.
	
*/
