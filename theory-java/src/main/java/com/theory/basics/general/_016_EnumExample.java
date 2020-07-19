package com.theory.basics.general;

enum CoffeeSize {
	BIG, HUGE, OVERWHELMING
} // this cannot be
	// private or protected

class Coffee {
	CoffeeSize size;
}

class Coffee2 { // Enum inside a class
	enum CoffeeSize {
		BIG, HUGE, OVERWHELMING
	}

	CoffeeSize size;
}

/*
 * The most important thing to remember is that enums are not Strings or ints!
 * Each of the enumerated CoffeeSize types is actually an instance of
 * CoffeeSize. In other words, BIG is of type CoffeeSize. Think of an enum as a
 * kind of class that looks something (but not exactly) like this:
 * 
 * Conceptual example of how you can think about enums
 */
class CoffeeSizeConceptualEnumClass {
	
	CoffeeSizeConceptualEnumClass(String enumName, int index) {
		// Constructor stuff here
	}
	public static final CoffeeSizeConceptualEnumClass BIG = new CoffeeSizeConceptualEnumClass("BIG", 0);
	public static final CoffeeSizeConceptualEnumClass HUGE = new CoffeeSizeConceptualEnumClass("HUGE", 1);
	public static final CoffeeSizeConceptualEnumClass OVERWHELMING = new CoffeeSizeConceptualEnumClass("OVERWHELMING", 2);

}


enum CoffeeSizeWithConstructor {
	// 8, 10 & 16 are passed to the constructor
	BIG(8), HUGE(10), OVERWHELMING(16);
	CoffeeSizeWithConstructor(int ounces) { // constructor
		this.ounces = ounces;
	}

	private int ounces; // an instance variable

	public int getOunces() {
		return ounces;
	}
}

public class _016_EnumExample {
	public static void main(String[] args) {
		Coffee drink = new Coffee();
		drink.size = CoffeeSize.BIG; // enum outside class

		Coffee2 drink2 = new Coffee2();
		drink2.size = Coffee2.CoffeeSize.BIG; // enclosing class
		// name required

		//enum CoffeeSize{BIG,HUGE,OVERWHELMING} // WRONG! Cannot
		// declare enums
		// in methods
	}
}
