package com.java.java8new.li07.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class A003CollableAndFuture {

	public static void main(String[] args) {
		// Callable is also a function interface similar like Runnable. But instead of
		// void they return a value.
		Callable<Integer> task = () -> {
			TimeUnit.SECONDS.sleep(1);
			return 123;
		};

		// Since executor service submit doesn't wait for the results of the task we use
		// Future to hold the results
		// Calling get method blocks the current thread until the task is finished and
		// return the result
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<Integer> future = executorService.submit(task);
		
		System.out.println("is future done? " + future.isDone());
		
		Integer result = null;
		try {
			result = future.get();
		} catch (InterruptedException | ExecutionException e) {
		}
		
		System.out.println("is future done? " + future.isDone());
		System.out.println("result: " + result);
		
		executorService.shutdownNow();
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
		}
	}

}
