package com.patterns.structural.decorator.impl;

import com.patterns.structural.decorator.abstracts.Car;
import com.patterns.structural.decorator.concrete.BasicCar;
import com.patterns.structural.decorator.concrete.LuxuryCar;
import com.patterns.structural.decorator.concrete.SportsCar;

public class DecoratorPatternTest {

	public static void main(String[] args) {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println("\n*****");

		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}

}