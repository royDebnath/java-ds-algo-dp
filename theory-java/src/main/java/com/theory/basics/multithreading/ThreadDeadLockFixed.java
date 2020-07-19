package com.theory.basics.multithreading;

public class ThreadDeadLockFixed {
	/**
	 * Both method are now requesting lock in same order, first Integer and then
	 * String. You could have also done reverse e.g. first String and then
	 * Integer, both will solve the problem, as long as both method are
	 * requesting lock in consistent order.
	 */
	public void method1() {
		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object");
			synchronized (String.class) {
				System.out.println("Aquired lock on String.class object");
			}
		}
	}

	public void method2() {
		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object");
			synchronized (String.class) {
				System.out.println("Aquired lock on String.class object");
			}
		}
	}
}
/*
 * Now there would not be any deadlock because both methods are accessing lock
 * on Integer and String class literal in same order. So, if thread A acquires
 * lock on Integer object , thread B will not proceed until thread A releases
 * Integer lock, same way thread A will not be blocked even if thread B holds
 * String lock because now thread B will not expect thread A to release Integer
 * lock to proceed further.
 */