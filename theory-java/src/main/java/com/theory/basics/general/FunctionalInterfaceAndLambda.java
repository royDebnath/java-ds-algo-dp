package com.theory.basics.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.theory.support.Person;

public class FunctionalInterfaceAndLambda {

	static List<Person> personList;

	static Map<Integer, Person> idPersonMap;

	public static void main(String args[]) {
		setup();

		System.out.println("\n===========Implementation With Anonymous Class================\n");

		printWithCondition(personList, new Condition() {
			public boolean test(Person person) {
				return person.getLastname().startsWith("R");
			}
		});

		System.out.println("\n===========Implementation With Predicate and Consumer================\n");
		/*
		 * Java already provides an interface like Condition which we wrote as
		 * this is a common scenario.
		 * 
		 * public interface Predicate<T> { public boolean test(T t); }
		 * 
		 * Here is an example using predicate using lambda.
		 * 
		 */
		Predicate<Person> predicate = person -> person.getLastname().startsWith("R");
		Consumer<Person> consumer = person -> System.out.println(person.toString());
		printWithConditionUsingPredicate(personList, predicate, consumer);

		System.out.println("\n===========Implementation With Direct Lambda Expression================\n");

		printWithCondition(personList, person -> person.getLastname().startsWith("R"));

		
		
		
		System.out.println("\n===========Sorting By Implementing Comparator================\n");

		System.out.println("\n===========Before Sorting : ");
		personList.forEach(person -> System.out.println(person.getFirstname()));

		Collections.sort(personList, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getFirstname().compareTo(p2.getFirstname());
			}
		});

		System.out.println("\n===========After Sorting : ");
		personList.forEach(person -> System.out.println(person.getFirstname()));

		
		
		
		System.out.println("\n===========Sorting By Passing Lambda Expression================\n");
		
		System.out.println("\n===========Before Sorting : ");
		personList.forEach(person -> System.out.println(person.getFirstname()));

		Collections.sort(personList, (p1, p2) -> p1.getFirstname().compareTo(p2.getFirstname()));//As Comparator is a FunctionalInterface, the implementation can be replaced by lambda.
		
		System.out.println("\n===========After Sorting : ");
		personList.forEach(person -> System.out.println(person.getFirstname()));


	}

	private static void setup() {
		personList = new ArrayList<>();
		personList.add(new Person("Nitin", "Agarwal", 29));
		personList.add(new Person("Debnath", "Roy", 29));
		personList.add(new Person("Pranoy", "Roy", 29));
		personList.add(new Person("Pallab", "Karmakar", 29));

		idPersonMap = new HashMap<>();
		idPersonMap.put(001, new Person("Nitin", "Agarwal", 29));
		idPersonMap.put(002, new Person("Debu", "Roy", 29));
		idPersonMap.put(002, new Person("Pranoy", "Roy", 29));
		idPersonMap.put(003, new Person("Pallab", "Karmakar", 29));

	}

	/**
	 * The second argument of type Condition is a functional interface with one
	 * method test(). The implementation of test is provided by a lambda
	 * expression while calling as described below:
	 * 
	 * printWithCondition(personList, person ->
	 * person.getLastname().startsWith("R"));
	 * 
	 * 
	 */
	static void printWithCondition(List<Person> pList, Condition c) {
		for (Person p : pList) {
			if (c.test(p)) { // test() method accepts Person object and returns
								// boolean value as implemented in the lambda.
				System.out.println("Inside printWithCondition : " + p.toString());
			}
		}
	}

	/**
	 * Functional interface with one method accepting object of type Person and
	 * returning boolean. All the lambdas implementing this interface has to
	 * accept Person object and return boolean.
	 *
	 */
	@FunctionalInterface
	interface Condition {
		boolean test(Person p);
	}

	/**
	 * Implemented the predicate and consumer by lambda expression while calling
	 */
	static void printWithConditionUsingPredicate(List<Person> pList, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		for (Person p : pList) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}

	}

}
