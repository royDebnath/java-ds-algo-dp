package com.patterns.structural.decorator.concrete;

import com.patterns.structural.decorator.abstracts.Car;
import com.patterns.structural.decorator.abstracts.CarDecorator;

public class SportsCar extends CarDecorator {

	public SportsCar(Car c) {
		super(c);
	}

	@Override
	public void assemble(){
		super.assemble();
		System.out.print(" Adding features of Sports Car.");
	}
}