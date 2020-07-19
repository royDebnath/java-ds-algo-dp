package com.parctice;

import java.util.ArrayList;
import java.util.List;

public class ProdConDemo {

	public static void main(String[] args) {
		List<Integer> taskQueue = new ArrayList<>();
		Producer producer = new Producer(taskQueue, 10);
		Consumer consumer = new Consumer(taskQueue);

		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		t1.start();
		t2.start();

	}

}

class Producer implements Runnable {

	List<Integer> taskQueue;
	int MAX_SIZE = 10;

	public Producer(List<Integer> taskQueue, int mAX_SIZE) {
		this.taskQueue = taskQueue;
		MAX_SIZE = mAX_SIZE;
	}

	@Override
	public void run() {
		int count = 0;
		try {
			while (true) {
				produce(count++);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void produce(int count) throws InterruptedException {
		synchronized (taskQueue) {
			while (taskQueue.size() == MAX_SIZE) {
				System.out.println("Queue is Full..Waiting for Consumer");
				taskQueue.wait();
			}
			Thread.sleep(1000);
			System.out.println("Produced : " + count);
			taskQueue.add(count);
			taskQueue.notifyAll();

		}

	}

}

class Consumer implements Runnable {

	List<Integer> taskQueue;

	public Consumer(List<Integer> taskQueue) {
		this.taskQueue = taskQueue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				consume();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void consume() throws InterruptedException {
		synchronized (taskQueue) {

			while (taskQueue.isEmpty()) {
				System.out.println("Queue is Empty..Waiting for Producer");
				taskQueue.wait();
			}
			Thread.sleep(1000);
			System.out.println("Consumed : " + taskQueue.get(0));
			taskQueue.remove(0);
			taskQueue.notifyAll();
		}

	}

}