package com.theory.basics.multithreading;

import java.util.ArrayList;
import java.util.List;

/*We use wait () and notify () or notifyAll () method mostly for inter-thread communication.
 *  One thread is waiting after checking a condition e.g. 
 *  In Producer Consumer example Producer Thread is waiting if buffer is full and 
 *  Consumer thread notify Producer thread after he creates a space in buffer by 
 *  consuming an element. calling notify() or notifyAll() issues a notification to
 *   a single or multiple thread that a condition has changed and 
 *   once notification thread leaves synchronized block , all the threads 
 *   which are waiting fight for object lock on which they are waiting and 
 *   lucky thread returns from wait() method after re-acquiring the lock and proceed further. 
 *   Let’s divide this whole operation in steps to see a possibility of race condition between wait () and notify () method in Java,
 *    we will use Produce Consumer thread example to understand the scenario better:

   1. The Producer thread tests the condition (buffer is full or not) and confirms that it must wait (after finding buffer is full).
   2. The Consumer thread sets the condition after consuming an element from buffer.
   3. The Consumer thread calls the notify () method; this goes unheard since the Producer thread is not yet waiting.
   4. The Producer thread calls the wait () method and goes into waiting state.

So due to race condition here we potential lost a notification and 
if we use buffer or just one element Produce thread will be waiting forever and your program will hang.

Now let's think how does this potential race condition get resolved? This race condition is resolved by 
using synchronized keyword and locking provided by java. In order to call the wait (), notify () or notifyAll () methods in Java,
 we must have obtained the lock for the object on which we're calling the method. 
 Since the wait () method in Java also releases the lock prior to waiting and 
 re-acquires the lock prior to returning from the wait () method, we must use this lock to 
 ensure that checking the condition (buffer is full or not) and setting the condition (taking element from buffer) 
 is atomic which can be achieved by using synchronized method or block in Java.
*/

public class ThreadWaitNotify {
	public static void main(String[] args) {
		List<Integer> taskQueue = new ArrayList<Integer>();
		int MAX_CAPACITY = 5;
		Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
		Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
		tProducer.start();
		tConsumer.start();
	}

}

class Producer implements Runnable {

	List<Integer> taskQueue;
	int MAX_CAPACITY;

	public Producer(List<Integer> taskQueue, int mAX_CAPACITY) {
		this.taskQueue = taskQueue;
		MAX_CAPACITY = mAX_CAPACITY;
	}

	public void run() {
		int counter = 0;
		while (true) {
			try {
				produce(counter++);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void produce(int i) throws InterruptedException {
		// synchronized on object taskQueue. The lock
		// held will be on any operation on
		// taskQueue and for a notification on this
		// lock to obtain lock on this object again
		synchronized (taskQueue) {
			while (taskQueue.size() == MAX_CAPACITY) {
				
					System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: "
							+ taskQueue.size());
					taskQueue.wait(); // This will release the lock on taskQueue
										// object and other operation can be
										// performed on taskQueue
				}
			

			Thread.sleep(1000);
			taskQueue.add(i);
			System.out.println("Produced: " + i);
			taskQueue.notifyAll();
		}

	}
}

class Consumer implements Runnable {

	List<Integer> taskQueue;

	public Consumer(List<Integer> taskQueue) {
		this.taskQueue = taskQueue;
	}

	public void run() {
		while (true) {
			try {
				consume();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {
		synchronized (taskQueue) {
			while (taskQueue.isEmpty()) {
					System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: "
							+ taskQueue.size());
					taskQueue.wait();
			}
			Thread.sleep(1000);
			int i = (Integer) taskQueue.remove(0);
			System.out.println("Consumed: " + i);
			taskQueue.notifyAll();// This will notify all the threads waiting to
									// obtain a lock on taskQueue
		}

	}
}