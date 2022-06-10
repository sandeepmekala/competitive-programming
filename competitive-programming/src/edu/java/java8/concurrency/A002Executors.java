package edu.java.java8.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class A002Executors {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<?> future = executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hi, "+threadName);
		});
		
		try {
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("Tasks interrupted :"+e.getMessage());
		} finally{
			if(!executor.isTerminated()){
				System.out.println("close running tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}
		
	}

}
