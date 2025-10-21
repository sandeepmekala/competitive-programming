package com.java.concurrency.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InvokeAllExample {

	public static void main(String[] args) {
		List<Callable<String>> callables = Arrays.asList(
				() -> "task1",
				() -> "task2",
				() -> "task3");

		ExecutorService executorService = Executors.newWorkStealingPool();
		try {
			executorService.invokeAll(callables)
			.stream()
			.map((future) -> {
				try{
					return future.get();
				}catch(Exception e){
					throw new IllegalStateException(e);
				}
			})
			.forEach(System.out::println);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdown(); //comment this while testin above code
		System.out.println();


		List<Callable<String>> callables2 = Arrays.asList(
				callable("task1", 2),
				callable("task2", 1),
				callable("task3", 3));
		ExecutorService executorService2 = Executors.newWorkStealingPool();
		try {
			String result = executorService2.invokeAny(callables2);
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executorService2.shutdown(); //comment this while testin above code
	}

	static Callable<String> callable(String result, long sleepSeconds){
		return ()->{
			TimeUnit.SECONDS.sleep(sleepSeconds);
			return result;
		};
	}

}
