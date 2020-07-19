package com.patterns.creational.abstractfactory.impl.types;

import com.patterns.creational.abstractfactory.interfaces.Shape;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}