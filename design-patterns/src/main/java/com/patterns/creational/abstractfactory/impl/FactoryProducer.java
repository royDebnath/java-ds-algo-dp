package com.patterns.creational.abstractfactory.impl;

import com.patterns.creational.abstractfactory.impl.factories.ColorFactory;
import com.patterns.creational.abstractfactory.impl.factories.ShapeFactory;
import com.patterns.creational.abstractfactory.interfaces.AbstractFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {

		if (choice.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory();

		} else if (choice.equalsIgnoreCase("COLOR")) {
			return new ColorFactory();
		}

		return null;
	}
}