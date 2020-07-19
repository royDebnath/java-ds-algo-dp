package com.theory.basics.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

class SynchronizedCounter {
	/*
	 * Atomic operations are performed in a single unit of task without
	 * interference from other operations. Atomic operations are necessity in
	 * multi-threaded environment to avoid data inconsistency. One way to make
	 * Counter safe from thread interference is to make its methods
	 * synchronized, as in SynchronizedCounter:
	 */
	private int c = 0;

	public synchronized void increment() {
		c++;
	}

	public synchronized void decrement() {
		c--;
	}

	public synchronized int value() {
		return c;
	}

}

class AtomicCounter {
	//AtomicInteger allows us to prevent thread interference without resorting to synchronization
	
	private AtomicInteger c = new AtomicInteger(0);

	public void increment() {
		c.incrementAndGet();
	}

	public void decrement() {
		c.decrementAndGet();
	}

	public int value() {
		return c.get();
	}

}

public class AtomicVariables {

	public static void main(String args[]) {
		SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
		synchronizedCounter.increment();
		System.out.println(synchronizedCounter.value());

		AtomicCounter atomicCounter = new AtomicCounter();
		atomicCounter.increment();
		System.out.println(atomicCounter.value());

	}

}
