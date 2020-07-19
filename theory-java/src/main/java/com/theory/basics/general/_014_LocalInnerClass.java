package com.theory.basics.general;

/*A local inner class is a nested class defined within a method. 
 * Like local variables, a local inner class declaration does not exist until the method is invoked,
 *  and it goes out of scope when the method returns. 
 *  This means that you can create instances only from within the method. 
 *  Those instances can still be returned from the method. This is just how local variables work.
 *   Local inner classes have the following properties:
 
■ They do not have an access specifier.
■ They cannot be declared static and cannot declare static fields or methods.
■ They have access to all fields and methods of the enclosing class.
■ They do not have access to local variables of a method unless those variables are final or effectively final.

The compiler is generating a class file from your inner class. A separate class has no way to refer to local variables. 
If the local variable is final ,Java can handle it by passing it to the constructor of the inner class
or by storing it in the class file. If it weren’t effectively final, these tricks wouldn’t work because the value could 
change after the copy was made. Up until Java 7, the programmer actually had to type the final keyword. In Java 8, 
the “effectively final” concept was introduced. If the code could still compile with the keyword final inserted before 
the local variable, the variable is effectively final.
*/

class Outer {
	private int length = 5;

	public void calculate() {
		final int width = 20;
		class Inner {
			public void multiply() {
				System.out.println(length * width);
			}
		}
		Inner inner = new Inner();
		inner.multiply();
	}
}

public class _014_LocalInnerClass {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.calculate();
	}
}
