package com.theory.basics.multithreading;

/**
 * * Java program to create a deadlock by imposing circular wait. * @author
 * WINDOWS 8
 */
public class ThreadDeadlock {
	/* * This method request two locks, first String and then Integer */
	public void method1() {
		synchronized (String.class) {
			System.out.println("Aquired lock on String.class object");
			synchronized (Integer.class) {
				System.out.println("Aquired lock on Integer.class object");
			}
		}
	}

	/*
	 * * This method also requests same two lock but in exactly Opposite order
	 * i.e. first Integer and then String. This creates potential deadlock, if
	 * one thread holds String lock and other holds Integer lock and they wait
	 * for each other, forever.
	 */
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
 * If method1() and method2() both will be called by two or many threads , there
 * is a good chance of deadlock because if thread 1 acquires lock on Sting
 * object while executing method1() and thread 2 acquires lock on Integer object
 * while executing method2() both will be waiting for each other to release lock
 * on Integer and String to proceed further which will never happen.
 */