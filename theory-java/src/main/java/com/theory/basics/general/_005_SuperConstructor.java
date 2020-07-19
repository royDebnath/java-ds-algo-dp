package com.theory.basics.general;

//If you want a no-arg constructor and you've typed any other constructor(s) into your class code,
//the compiler won't provide the no-arg constructor (or any other constructor) for you. 
//In other words, if you've typed in a constructor with arguments, you won't have a no-arg constructor unless you type it in yourself!
class Animals {
	//Animals(){}
	Animals(String s) {

	}
}

// The below code does not even compile. Implicit super constructor Animal() is
// undefined for default constructor. Must define an explicit constructor
// if your superclass does not have a no-arg constructor, then in your subclass
// you will not be able to use the default constructor supplied by the compiler.

/*
class Horse extends Animals {

}
*/

// For the same reason below code also does not compile.
// It cannot find the default super() constructor.

/*
class Dogs extends Animals {
	Dogs() {
		super();
	}
}
*/

// The below code runs just fine as it calls the super the way it is defined in
// parent Animal class.
class Cat extends Animals {
	Cat(String s) {
		super(s);
	}
}

public class _005_SuperConstructor {

}
