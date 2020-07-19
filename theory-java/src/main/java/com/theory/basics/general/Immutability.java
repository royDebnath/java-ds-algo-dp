package com.theory.basics.general;

public class Immutability {

	class Point {
		private int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}

	// ...
	public final class ImmutableCircle {
		private final Point center; // Although we do not provide setters for
									// Point through this class but still it can
									// be modified if we use the same reference
									// in the constructor as Point has setter
									// methods and that can be invoked once we
									// get a reference. Hence create new in
									// constructor
		private final double radius;

		public ImmutableCircle(Point center, double radius) {
			// we create new object here because it shouldn't be changed
			this.center = new Point(center.getX(), center.getY());
			this.radius = radius;
		}

		public Point getCenter() {
			return center;
		}

		public double getRadius() {
			return radius;
		}

	}

	/*
	 * The standard recipe for an immutable class is as follows: 
	 * 
	 * All propertiesmust be set in the constructor(s) or factory method(s). 
	 * There should be no setters. If it is necessary to include setters for 
	 * interface compatibility reasons, they should either do nothing or throw an
	 * exception. 
	 * 
	 * All properties should be declared as private and final. 
	 * 
	 * For all properties that are references to mutable types: the property should
	 * be initialized with a deep copy of the value passed via the constructor,
	 * and the property's getter should return a deep copy of the property
	 * value. 
	 * 
	 * The class should be declared as final to prevent someone creating
	 * a mutable subclass of an immutable class. 
	 * 
	 * A couple of other things to note: 
	 * Immutability does not prevent object from being nullable; e.g. null
	 * can be assigned to a String variable. If an immutable classes properties
	 * are declared as final, instances are inherently thread-safe. This makes
	 * immutable classes a good building block for implementing multi-threaded
	 * applications.
	 * 
	 * 
	 */
}
