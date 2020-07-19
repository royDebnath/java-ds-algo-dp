package com.patterns.creational.factory.impl.types;

import com.patterns.creational.factory.interfaces.Shape;

public class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}