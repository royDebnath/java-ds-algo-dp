package com.theory.basics.general;

class HeavyAnimal {
}

class Hippo extends HeavyAnimal {
}

class Elephant extends HeavyAnimal {
}

interface Mother {
}

public class _002_InstanceOfConcept {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		HeavyAnimal hippo = new Hippo();
		boolean b1 = hippo instanceof Hippo; // true
		boolean b2 = hippo instanceof HeavyAnimal; // true
		boolean b3 = hippo instanceof Elephant; // false
		boolean b4 = hippo instanceof Object; // true
		Hippo nullHippo = null;
		boolean b5 = nullHippo instanceof Object; // false

		Hippo anotherHippo = new Hippo();
		//boolean b5 = anotherHippo instanceof Elephant; // DOES NOT COMPILE

		/*
		 * The compilation check only applies when instanceof is called on a
		 * class. When checking whether an object is an instanceof an interface,
		 * Java waits until runtime to do the check. The reason is that a
		 * subclass could implement that interface and the compiler wouldn’t
		 * know it. There is no way for Hippo to be a subclass of Elephant. For
		 * example, suppose that you have an interface Mother and Hippo does not
		 * implement it:
		 */

		boolean b6 = hippo instanceof Mother;

		/*
		 * Hippo does not implement Mother. The compiler allows the statement
		 * because there could later be a class such as this:
		 * 
		 * class MotherHippo extends Hippo implements Mother { }
		 * 
		 * The compiler knows an interface could be added, so the instanceof
		 * statement could be true for some subclasses, whereas there is no
		 * possible way to turn a Hippo into an Elephant because Hippo already
		 * extends HeavyAnimal and it cannot extend any other class but can very
		 * well implement any number of interface
		 * 
		 * The instanceof operator is commonly used to determine if an instance
		 * is a subclass of a particular object before applying an explicit
		 * cast. For example, consider a method that takes as input an Animal
		 * reference and performs an operation based on that animal’s type:
		 *
		 * public void feedAnimal(Animal animal) { 
		 * 		if(animal instanceof Cow) {
		 * 			((Cow)animal).addHay(); } 
		 * 		else if(animal instanceof Bird) {
		 * 			((Bird)animal).addSeed(); } 
		 * 		else if(animal instanceof Lion) {
		 * 			((Lion)animal).addMeat(); }
		 * 		else { 
		 * 			throw new  RuntimeException("Unsupported animal"); 
		 * 		} 
		 * }
		 *
		 */
		
	}
}
