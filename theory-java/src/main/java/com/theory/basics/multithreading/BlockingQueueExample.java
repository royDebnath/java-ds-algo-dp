package com.theory.basics.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * Java BlockingQueue implementations are thread-safe. 
 * All queuing methods are atomic in nature and
 * use internal locks or other forms of concurrency control.
 * Java BlockingQueue interface is part of java collections framework 
 * and it’s primarily used for implementing producer consumer problem. 
 * We don’t need to worry about waiting for the space to be available for
 * producer or object to be available for consumer in BlockingQueue because 
 * it’s handled by implementation classes of BlockingQueue.
 * Java provides several BlockingQueue implementations such as 
 * ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, SynchronousQueue etc.
 * 
 * While implementing producer consumer problem in BlockingQueue, 
 * we will use ArrayBlockingQueue implementation. Following are some important methods you should know.
 * 
 * put(E e): This method is used to insert elements to the queue. If the queue is full, it waits for the space to be available.
 * E take(): This method retrieves and remove the element from the head of the queue. If queue is empty it waits for the element to be available.
 * 
 * */
public class BlockingQueueExample {
	volatile static BlockingQueue<Message> queue;

	public static void main(String[] args) throws InterruptedException {
		// Creating BlockingQueue of size 10
		queue = new ArrayBlockingQueue<>(10);

		// starting producer to produce messages in queue
		Thread producer = new Thread(() -> {
			// produce messages
			for (int i = 0; i < 5; i++) {
				Message msg = new Message("" + i);
				try {
					Thread.sleep(500);
					queue.put(msg);
					System.out.println("Produced " + msg.getMsg());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// adding exit message
			Message msg = new Message("exit");
			System.out.println("Producer " + msg.getMsg());
			try {
				queue.put(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		// starting consumer to consume messages from queue
		Thread consumer = new Thread(() -> {
			try {
				// consuming messages until exit message is received
				while (true) {
					Thread.sleep(1500);
					System.out.println("Consumed " + queue.take().getMsg());

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		consumer.start();
		producer.start();

		System.out.println("Producer and Consumer has been started");
	}

}

class Message {
	private String msg;

	public Message(String str) {
		this.msg = str;
	}

	public String getMsg() {
		return msg;
	}

}