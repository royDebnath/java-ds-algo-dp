package com.patterns.structural.decorator.concrete;

import com.patterns.structural.decorator.abstracts.Car;

public class BasicCar implements Car {

	@Override
	public void assemble() {
		System.out.print("Basic Car.");
	}

}