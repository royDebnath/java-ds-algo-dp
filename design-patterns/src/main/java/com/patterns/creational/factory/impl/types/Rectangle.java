package com.patterns.creational.factory.impl.types;

import com.patterns.creational.factory.interfaces.Shape;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}