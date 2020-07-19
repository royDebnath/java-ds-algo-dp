package com.theory.basics.general;

interface HasTail {
	public boolean isTailStriped();
}

class Primate {
	public boolean hasHair() {
		return true;
	}
}

class Lemur extends Primate implements HasTail {
	public int age = 10;

	public boolean isTailStriped() {
		return false;
	}
}

class Bird {
}

class Fish {
}

class Rodent {
}

class Capybara extends Rodent {
}

public class _003_PolymorphicReference {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Lemur lemur = new Lemur();
		System.out.println(lemur.age);

		HasTail hasTail = lemur;
		System.out.println(hasTail.isTailStriped());

		Primate primate = lemur;
		System.out.println(primate.hasHair());

		/*
		 * only one object, Lemur, is created and referenced. The ability of the
		 * Lemur object to be passed as an instance of an interface it
		 * implements, HasTail, as well as an instance of one of its
		 * superclasses, Primate, is the nature of polymorphism. If you use a
		 * variable to refer to an object, then only the methods or variables
		 * that are part of the variable’s reference type can be called without
		 * an explicit cast. For example, the following snippets of code will
		 * not compile:
		 */
		  HasTail hasTail1 = new Lemur(); 
		  //System.out.println(hasTail1.age); // DOES NOT COMPILE
		   
		  Primate primate1 = lemur;
		  //System.out.println(primate.isTailStriped()); // DOES NOT COMPILE
		  
		 /* In this example, the reference hasTail has direct access only to
		 * methods defined with the HasTail interface; therefore, it doesn’t
		 * know that the variable age is part of the object. Likewise, the
		 * reference primate has access only to methods defined in the Primate
		 * class, and it doesn’t have direct access to the isTailStriped()
		 * method.
		 */
		  Primate primate2 = lemur; 
		  //Lemur lemur2 = primate2; // DOES NOT COMPILE
		  Lemur lemur3 = (Lemur)primate2; 
		  System.out.println(lemur3.age);
		 
		 /* In this example, we first try to convert the primate reference back
		 * to a lemur reference, lemur2, without an explicit cast. The result is
		 * that the code will not compile. In the second example, though, we
		 * explicitly cast the object to a subclass of the object Primate, and
		 * we gain access to all the methods available to the Lemur class. Here
		 * are some basic rules to keep in mind when casting variables: 1.
		 * Casting an object from a subclass to a superclass doesn’t require an
		 * explicit cast. 2. Casting an object from a superclass to a subclass
		 * requires an explicit cast. 3. The compiler will not allow casts to
		 * unrelated types. 4. Even when the code compiles without issue, an
		 * exception may be thrown at runtime if the object being cast is not
		 * actually an instance of that class.
		 * 
		 * 
		 */

		Fish fish = new Fish();

		//Bird bird = (Fish)bird; // DOES NOT COMPILE

		// Casting is not without its limitations. Even though two classes share
		// a related hierarchy,
		// that doesn’t mean an instance of one can automatically be cast to
		// another. Here’s an
		// example:

		Rodent rodent = new Rodent();
		Capybara capybara = (Capybara) rodent; // Throws ClassCastException at
		// runtime

		/*
		 * This code creates an instance of Rodent and then tries to cast it to
		 * a subclass of Rodent, Capybara. Although this code will compile
		 * without issue, it will throw a ClassCastException at runtime since
		 * the object being referenced is not an instance of the Capybara class.
		 * As you may recall from Chapter 1, you can use the instanceof operator
		 * prior to casting the object to avoid throwing ClassCastException at
		 * runtime:
		 */
		
		if(rodent instanceof Capybara) {
			Capybara capybara2 = (Capybara)rodent; //never reaches this line as rodent is not an instance of Capybara
			}

	}
}
