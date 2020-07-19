package com.patterns.creational.abstractfactory.impl.factories;

import com.patterns.creational.abstractfactory.impl.types.Green;
import com.patterns.creational.abstractfactory.impl.types.Red;
import com.patterns.creational.abstractfactory.interfaces.AbstractFactory;
import com.patterns.creational.abstractfactory.interfaces.Color;
import com.patterns.creational.abstractfactory.interfaces.Shape;

public class ColorFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		return null;
	}

	@Override
	public Color getColor(String color) {

		if (color == null) {
			return null;
		}

		if (color.equalsIgnoreCase("RED")) {
			return new Red();

		} else if (color.equalsIgnoreCase("GREEN")) {
			return new Green();

		}

		return null;
	}
}