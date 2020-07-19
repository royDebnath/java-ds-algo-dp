package com.theory.basics.general;

class Animal {
	static void doStuff() {
		System.out.print("Animal \n");
	}
}

class Dog extends Animal {
	static void doStuff() { // it's a redefinition,
		// not an override
		System.out.print("Dog \n");
	}

}

public class _006_StaticMethod {
	public static void main(String[] args) {
		Animal[] a = { new Animal(), new Dog(), new Animal() };
		for (int x = 0; x < a.length; x++) {
			a[x].doStuff(); // invoke the static method. Refered by object
							// reference not by classname which is allowed but
							// not recommended. This loop prints only "Animal"
							// becuase the doStuff() method is static and
							// invoked from class level which is Animal here as
							// the reference is being sourced for an array of
							// type Animal
		}
		Dog.doStuff(); // invoke using the class name. Prints "Dog" As expected.
		
	}
}
