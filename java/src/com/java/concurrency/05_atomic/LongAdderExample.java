package com.java.concurrency.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class LongAdderExample {

	public static void main(String[] args) {
		LongAdderExample obj = new LongAdderExample();
		obj.execute();
	}

	private void execute() {
		// Preferable over Atomic Numbers
		// Used as counters across the multiple threads
		LongAdder adder = new LongAdder();
		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 1000)
		.forEach(i -> executor.submit(adder::increment));

		stop(executor);

		System.out.println(adder.sumThenReset()); // => 1000
		System.out.println(adder.sum());
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
