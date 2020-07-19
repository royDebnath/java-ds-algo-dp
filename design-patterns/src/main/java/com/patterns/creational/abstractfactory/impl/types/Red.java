package com.patterns.creational.abstractfactory.impl.types;

import com.patterns.creational.abstractfactory.interfaces.Color;

public class Red implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}