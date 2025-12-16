package com.java.concurrency.collections;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreExample {
	public static void main(String[] args) {
		SemaphoreExample obj = new SemaphoreExample();
		obj.execute();
	}

	private void execute() {
		// Locks usually grant exclusive access to a resource
		// Semaphores limit concurrent access to certain parts of application
		ExecutorService executor = Executors.newFixedThreadPool(10);

		Semaphore semaphore = new Semaphore(5);

		Runnable longRunningTask = () -> {
			boolean permit = false;
			try {
				permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
				if (permit) {
					System.out.println("Semaphore acquired");
					sleep(5);
				} else {
					System.out.println("Could not acquire semaphore");
				}
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			} finally {
				if (permit) {
					semaphore.release();
					System.out.println("Semaphore released");
				}
			}
		};

		IntStream.range(0, 10)
		.forEach(i -> executor.submit(longRunningTask));

		stop(executor);
	}

	public void stop(ExecutorService executor) {
		try {
			executor.shutdown();
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("termination interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("killing non-finished tasks");
			}
			executor.shutdownNow();
		}
	}

	public void sleep(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
