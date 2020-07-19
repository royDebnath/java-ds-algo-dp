package com.theory.basics.multithreading;

public class EvenOddWaitNotify {

	public static void main(String[] args) {

		PrintEvenOdd p1 = new PrintEvenOdd(0);
		PrintEvenOdd p2 = new PrintEvenOdd(1);

		Thread t1 = new Thread(p1, "Even");
		Thread t2 = new Thread(p2, "Odd");
		t1.start();
		t2.start();
	}
}

class PrintEvenOdd implements Runnable {
	int remainder;
	int MAX_SIZE = 10;
	static int counter = 0;
	static Object lock = new Object();

	PrintEvenOdd(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (counter < MAX_SIZE) {
			synchronized (lock) {
				while (counter % 2 != remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : " + counter);
				counter++;
				lock.notifyAll();
			}
		}

	}

}
