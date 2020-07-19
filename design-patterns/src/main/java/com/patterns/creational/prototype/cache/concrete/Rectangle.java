package com.patterns.creational.prototype.cache.concrete;

import com.patterns.creational.prototype.cache.abstracts.Shape;

public class Rectangle extends Shape {

	public Rectangle() {
		type = "Rectangle";
	}

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}

	
	//Overriding the abstract's clone if we do not trust the super.clone() of shape
	@Override
	public Rectangle clone() {
		Rectangle cloneRec = new Rectangle();
		cloneRec.setId(this.getId());
		return cloneRec;
	}
}