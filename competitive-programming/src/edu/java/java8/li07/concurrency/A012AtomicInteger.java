package edu.java.java8.li07.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class A012AtomicInteger {

	public static void main(String[] args) {
		A012AtomicInteger obj = new A012AtomicInteger();
		obj.execute();
	}

	private void execute() {
		// Atomic classed make heavy use of Compare and Swap(CAS), an atomic instruction
		// directly supported by most modern processors
		// Prefer Atomic classes over locks
		// incrementAndGet
		AtomicInteger atomicInt = new AtomicInteger(0);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		IntStream.range(0, 1000)
		.forEach(i -> executor.submit(atomicInt::incrementAndGet));
		
		stop(executor);
		System.out.println(atomicInt.get());

		// updateAndGet
		AtomicInteger atomicInt2 = new AtomicInteger(0);
		ExecutorService executor2 = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000).forEach(i -> {
			Runnable task2 = () -> atomicInt2.updateAndGet(n -> n + 2);
			executor2.submit(task2);
		});
		stop(executor2);
		System.out.println(atomicInt2.get());

		// accumulateAndGet
		AtomicInteger atomicInt3 = new AtomicInteger(0);
		ExecutorService executor3 = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000).forEach(i -> {
			Runnable task3 = () -> atomicInt3.accumulateAndGet(i, (n, m) -> n + m);
			executor3.submit(task3);
		});
		stop(executor3);
		System.out.println(atomicInt3.get()); // => 499500
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
