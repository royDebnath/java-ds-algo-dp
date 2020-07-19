package com.theory.basics.general;

/* With encapsulation, a class is able to maintain certain invariants about its internal data.
An invariant is a property or truth that is maintained even after the data is modified. For
example, imagine that we are designing a new Animal class, and we have the following
design requirements:
■ Each animal has a non‐ null , non‐empty species field
■ Each animal has an age field that is greater than or equal to zero 

The goal of designing our Animal class would be to make sure that we never arrive at
an instance of Animal that violates one of these properties. By using private instance
members along with getter and setter methods that validate the input data, we can ensure
that these invariants remain true.
*/
class Animal2 {
	// Fields are declared private
	private String species;
	private int age;

	public Animal2(String species) {/*
									 * a non‐default constructor has been added
									 * that requires a species value and uses
									 * the setter method to validate the input
									 */
		this.setSpecies(species);
	}

	public String getSpecies() {
		return species;
	}

	public int getAge() {
		return age;
	}

	/*
	 * setSpecies() and setAge() methods now validate the input and throw an
	 * exception if one of our invariants is violated.
	 */
	public void setSpecies(String species) {
		if (species == null || species.trim().length() == 0) {
			throw new IllegalArgumentException("Species is required");
		}
		this.species = species;
	}

	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Age cannot be a negative number");
		}
		this.age = age;
	}
}

public class _017_Encapsulation {

}
