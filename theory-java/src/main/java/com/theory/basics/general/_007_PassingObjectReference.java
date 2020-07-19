package com.theory.basics.general;

import java.awt.Dimension;

class Foo {
	String name;

	void setName(String name) {
		this.name = name;
	}
}

public class _007_PassingObjectReference {

	public static void main(String[] args) {
		Dimension d = new Dimension(5, 10);
		_007_PassingObjectReference por = new _007_PassingObjectReference();
		System.out.println("Before modify() d.height = " + d.height);
		por.modify(d);
		System.out.println("After modify() d.height = " + d.height);

		por.bar();
	}

	/*
	 * When you pass an object variable into a method, you must keep in mind
	 * that you're passing the object reference, and not the actual object
	 * itself. Remember that a reference variable holds bits that represent (to
	 * the underlying VM) a way to get to a specific object in memory (on the
	 * heap). More importantly, you must remember that you aren't even passing
	 * the actual reference variable, but rather a copy of the reference
	 * variable. A copy of a variable means you get a copy of the bits in that
	 * variable, so when you pass a reference variable, you're passing a copy of
	 * the bits representing how to get to a specific object. In other words,
	 * both the caller and the called method will now have identical copies of
	 * the reference; thus, both will refer to the same exact (not a copy)
	 * object on the heap.
	 * 
	 * Notice when the Dimension object is passed to the modify() method, any
	 * changes to the object that occur inside the method are being made to the
	 * object whose reference was passed. In the preceding example, reference
	 * variables d and dim both point to the same object.
	 * 
	 * 
	 */
	void modify(Dimension dim) {
		dim.height = dim.height + 1;
		System.out.println("dim = " + dim.height);
	}

	/*
	 * The called method can't change the caller's variable, although for object
	 * reference variables, the called method can change the object the variable
	 * referred to. What's the difference between changing the variable and
	 * changing the object? For object references, it means the called method
	 * can't reassign the caller's original reference variable and make it refer
	 * to a different object or null.
	 */
	void bar() {
		Foo f = new Foo();
		f.setName("Foo");
		System.out.println(f.name);
		doStuff(f);
		System.out.println(f.name);
	}

	void doStuff(Foo g) {
		g.setName("Boo"); // g, the copy of reference variable f, points to the
							// same object hence changes name to "Boo"
		g = new Foo();
		/*
		 * reassigning g does not reassign f! At the end of the bar() method,
		 * two Foo objects have been created: one referenced by the local
		 * variable f and one referenced by the local (argument) variable g.
		 * Because the doStuff() method has a copy of the reference variable, it
		 * has a way to get to the original Foo object, for instance to call the
		 * setName() method. But the doStuff() method does not have a way to get
		 * to the f reference variable. So doStuff() can change values within
		 * the object f refers to, but doStuff() can't change the actual
		 * contents (bit pattern) of f. In other words, doStuff() can change the
		 * state of the object that f refers to, but it can't make f refer to a
		 * different object!
		 * 
		 */
		g.setName("Hoo"); // This does not have any effect on the object f
							// refers to, it still prints "Boo"
	}

}
