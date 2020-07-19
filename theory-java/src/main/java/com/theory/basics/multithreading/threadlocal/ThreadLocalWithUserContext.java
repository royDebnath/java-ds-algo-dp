package com.theory.basics.multithreading.threadlocal;

public class ThreadLocalWithUserContext implements Runnable {

	private static ThreadLocal<Context> userContext = new ThreadLocal<>();

	// We can construct an instance of the ThreadLocal by using the
	// withInitial() static method and passing a supplier to it:
	ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1); // java 8
																			
	private Integer userId;
	private UserRepository userRepository = new UserRepository();

	@Override
	public void run() {
		String userName = userRepository.getUserNameForUserId(userId);
		userContext.set(new Context(userName));
		System.out.println("thread context for given userId: " + userId + " is: " + userContext.get());
	}
}

/*
 * We can rewrite our example to store the user Context instance using a
 * ThreadLocal. Each thread will have its own ThreadLocal instance.
 * 
 * When using ThreadLocal we need to be very careful because every ThreadLocal
 * instance is associated with a particular thread. In our example, we have a
 * dedicated thread for each particular userId and this thread is created by us
 * so we have full control over it.
 * 
 * The run() method will fetch the user context and store it into the
 * ThreadLocal variable using the set() method:
 */

/*
 * Do not use ThreadLocal with ExecutorService If we want to use an
 * ExecutorService and submit a Runnable to it, using ThreadLocal will yield
 * non-deterministic results – because we do not have a guarantee that every
 * Runnable action for a given userId will be handled by the same thread every
 * time it is executed.
 * 
 * Because of that, our ThreadLocal will be shared among different userIds.
 * That’s why we should not use a TheadLocal together with ExecutorService. It
 * should only be used when we have full control over which thread will pick
 * which runnable action to execute.
 */
