package edu.java.java8.li07.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class A007Synchronized {

	public static void main(String[] args) {
		A007Synchronized obj = new A007Synchronized();
		obj.execute();
	}

	private void execute() {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 10000)
		.forEach(i -> executor.submit(this::increment));

		System.out.println(count);
		stop(executor);

		ExecutorService executor2 = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10000)
		.forEach(i -> executor2.submit(this::incrementSync));
		
		System.out.println(count2);
		stop(executor2);
	}

	int count = 0;
	void increment() {
		count = count + 1;
	}

	int count2 = 0;
	synchronized void incrementSync() {
		count2 = count2 + 1;
	}

	void incrementSync2() {
		synchronized (this) {
			count2 = count2 + 1;
		}
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
}
