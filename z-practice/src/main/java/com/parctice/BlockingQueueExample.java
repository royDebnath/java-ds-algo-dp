package com.parctice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
		
		Thread t1 = new Thread(() -> {
			int count = 0;
			while (true) {
				try {
					Thread.sleep(500);
					int element = count++;
					queue.put(element);
					System.out.println("Produced : " + element);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});
		
		Thread t2 = new Thread(() -> {
			try {
				while (true) {
					Thread.sleep(1000);
					System.out.println("Consumed : " + queue.take());
				}
			} catch (InterruptedException e) {
			}

		});
		t1.start();
		t2.start();

	}

}