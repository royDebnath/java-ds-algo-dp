package com.theory.java8.basics.general;

import java.util.ArrayList;

import java.util.List;

@FunctionalInterface
interface Condition {
	boolean test(String s);
}

public class FunctionalInterfaceToLambda {
	public static void main(String agrs[]) {

		List<String> list = new ArrayList<>();
		list.add("axxx");
		list.add("byyy");
		list.add("czzz");

		/*
		 * Condition condition = new Condition() { public boolean test(String s)
		 * {
		 * 
		 * if (s.contains("x")) { return true; } return false; } };
		 */

		printOnlywithX(list, s -> s.contains("x"));
		list.stream().filter(s -> s.contains("x")).map(String::toUpperCase).forEach(System.out::println);
	}

	private static void printOnlywithX(List<String> list, Condition condition) {
		for (String l : list) {
			if (condition.test(l)) {
				System.out.print(l);
			}
		}
	}
}