package com.theory.basics.multithreading;
public class EvenOdd implements Runnable {

	private static int count = 0;
	public static void main(String[] args) throws InterruptedException {

		count = 10;

		EvenOdd obj = new EvenOdd();
		Thread even = new Thread(obj, "Even");
		Thread odd = new Thread(obj, "Odd");

		even.start();
		odd.start();

	}

	@Override
	public void run() {

	
		String name = Thread.currentThread().getName();
		for (int i = 0; i <= count; i++) {
			if (name.equals("Even")) {
				if (i % 2 == 0)
					System.out.println(name + " - " + i);
			} else {
				if (i % 2 != 0)
					System.out.println(name + " - " + i);

			}

		}

	}
}