package com.java.concurrency.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class A006ScheduledExecutors {

	public static void main(String[] args) {
		ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(1);
		Runnable task1 = () -> System.out.println("Scheduling: " + System.nanoTime());
		ScheduledFuture<?> future1 = executor1.schedule(task1, 1, TimeUnit.SECONDS);

		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long remainingDelay = future1.getDelay(TimeUnit.MILLISECONDS);
		System.out.printf("Remaining Delay: %s ms\n", remainingDelay);
		executor1.shutdown(); // comment this while testin above code


		ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);
		Runnable task2 = () -> System.out.println("Scheduling: " + System.nanoTime());
		int initialDelay = 5;
		int period = 1;
		executor2.scheduleAtFixedRate(task2, initialDelay, period, TimeUnit.SECONDS);
		executor2.shutdown(); // comment this while testin above code


		ScheduledExecutorService executor3 = Executors.newScheduledThreadPool(1);
		Runnable task3 = () -> {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Scheduling: " + System.nanoTime());
			} catch (InterruptedException e) {
				System.err.println("task interrupted");
			}
		};
		executor3.scheduleWithFixedDelay(task3, 1, 5, TimeUnit.SECONDS);
		executor3.shutdown(); // comment this while testin above code
	}

}
