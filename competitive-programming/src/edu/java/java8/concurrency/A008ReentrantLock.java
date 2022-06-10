package edu.java.java8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class A008ReentrantLock {

	public static void main(String[] args) {
		A008ReentrantLock obj = new A008ReentrantLock();
		obj.execute();
	}
	
	private void execute() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10000)
		.forEach(i -> executor.submit(this::increment));
		System.out.println(count);
		stop(executor);
		
		
		ExecutorService executor2 = Executors.newFixedThreadPool(2);
		ReentrantLock lock = new ReentrantLock();
		executor2.submit(() -> {
			lock.lock();
			try{
				sleep(1);
			}finally{
				lock.unlock();
			}
		});
		
		executor2.submit(() ->{
		    System.out.println("Locked: " + lock.isLocked());
		    System.out.println("Held by me: " + lock.isHeldByCurrentThread());
		    boolean locked = lock.tryLock();					//when thread calls lock method, thread will be paused. But tryLock will not block the current thread.
		    System.out.println("Lock acquired: " + locked);
		});
		stop(executor2);
	}
	
	int count = 0;
	ReentrantLock lock = new ReentrantLock();
	void increment() {
		lock.lock();
		try{
			count = count + 1;
		}finally{
			lock.unlock();
		}		
	}
	
	public void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }
	
	public void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
