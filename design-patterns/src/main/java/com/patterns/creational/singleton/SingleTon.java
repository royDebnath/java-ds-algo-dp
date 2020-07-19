package com.patterns.creational.singleton;

/*
 * This pattern involves a single class which is responsible to create an object 
 * while making sure that only single object gets created. This class provides a 
 * way to access its only object which can be accessed directly without need to 
 * instantiate the object of the class.

Implementation
We're going to create a SingleObject class. SingleObject class have its constructor
 as private and have a static instance of itself.

SingleObject class provides a static method to get its static instance to outside world.
 SingletonPatternDemo, our demo class will use SingleObject class to get a SingleObject object.
 * 
 * */
class Singleton {
	private volatile static Singleton _instance;// if we don't make _instance
												// volatile, as another thread
												// can * see a half initialized
												// instance of Singleton. This
												// is only necessary if you have
												// a mutable singleton field in
												// a multi-threaded system.

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (_instance == null) { // Single Checked
			synchronized (Singleton.class) { // This line will be reached only
												// once for first time instance
												// creation. So cost of
												// synchronization only once
				if (_instance == null) { // Double Checked
					_instance = new Singleton();
				}
			}
		}
		return _instance;
	}
}
