package com.java.concurrency.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class A004Timeouts {

	public static void main(String[] args) {
		// Since, call to the get method blocks main thread, we can user timeouts
		ExecutorService executorService = Executors.newFixedThreadPool(1);

		Future<Integer> future = executorService.submit(() -> {
			TimeUnit.SECONDS.sleep(10);
			return 123;
		});

		try {
			future.get(1, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println(e);
		}
		executorService.shutdownNow();
	}

}
