package edu.java.java8.li07.concurrency;

import java.util.concurrent.TimeUnit;

public class A001BasicThreadWithRunnable {

	public static void main(String[] args) {
		
		Runnable task = () -> {
			try {
				String threadName = Thread.currentThread().getName();
				System.out.println("Hello1, "+threadName);
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Hello2, "+threadName);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		//executing the runnable on main thread, it will treate it as just a function call. Won't create new thread.
		task.run();
		
		Thread thread = new Thread(task);
		thread.start();
		System.out.println("Done!");
	}

}
