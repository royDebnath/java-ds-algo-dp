package com.patterns.creational.abstractfactory.impl;

import com.patterns.creational.abstractfactory.interfaces.AbstractFactory;
import com.patterns.creational.abstractfactory.interfaces.Color;
import com.patterns.creational.abstractfactory.interfaces.Shape;

/*
 * In Abstract Factory pattern an interface is responsible for creating a factory of related objects without explicitly specifying their classes. Each generated factory can give the objects as per the Factory pattern.

Implementation
We are going to create a Shape and Color interfaces and concrete classes implementing these interfaces. We create an abstract factory class AbstractFactory as next step. Factory classes ShapeFactory and ColorFactory are defined where each factory extends AbstractFactory. A factory creator/generator class FactoryProducer is created.

AbstractFactoryPatternDemo, our demo class uses FactoryProducer to get a AbstractFactory object. It will pass information (CIRCLE / RECTANGLE / SQUARE for Shape) to AbstractFactory to get the type of object it needs. It also passes information (RED / GREEN / BLUE for Color) to AbstractFactory to get the type of object it needs.
 * */
public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {

		// get shape factory
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

		// get an object of Shape Circle
		Shape shape1 = shapeFactory.getShape("CIRCLE");

		// call draw method of Shape Circle
		shape1.draw();

		// get an object of Shape Rectangle
		Shape shape2 = shapeFactory.getShape("RECTANGLE");

		// call draw method of Shape Rectangle
		shape2.draw();

		// get an object of Shape Square
		Shape shape3 = shapeFactory.getShape("SQUARE");

		// call draw method of Shape Square
		shape3.draw();

		// get color factory
		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

		// get an object of Color Red
		Color color1 = colorFactory.getColor("RED");

		// call fill method of Red
		color1.fill();

		// get an object of Color Green
		Color color2 = colorFactory.getColor("Green");

		// call fill method of Green
		color2.fill();

		// get an object of Color Blue
		Color color3 = colorFactory.getColor("BLUE");

		// call fill method of Color Blue
		color3.fill();
	}
}