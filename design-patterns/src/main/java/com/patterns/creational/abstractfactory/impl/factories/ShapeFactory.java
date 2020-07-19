package com.patterns.creational.abstractfactory.impl.factories;

import com.patterns.creational.abstractfactory.impl.types.Rectangle;
import com.patterns.creational.abstractfactory.impl.types.Square;
import com.patterns.creational.abstractfactory.interfaces.AbstractFactory;
import com.patterns.creational.abstractfactory.interfaces.Color;
import com.patterns.creational.abstractfactory.interfaces.Shape;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {

		if (shapeType == null) {
			return null;
		}

		if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();

		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}

		return null;
	}

	@Override
	public Color getColor(String color) {
		return null;
	}
}