package com.java.streams;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

public class A014LongAccumulator {

	public static void main(String[] args) {
		A014LongAccumulator obj = new A014LongAccumulator();
		obj.execute();
	}

	private void execute() {
		// Generalized version of LongAdder
		LongBinaryOperator op = (x, y) -> 2 * x + y;
		LongAccumulator accumulator = new LongAccumulator(op, 1L);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10)
		.forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

		stop(executor);
		System.out.println(accumulator.getThenReset()); // => 2539
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
