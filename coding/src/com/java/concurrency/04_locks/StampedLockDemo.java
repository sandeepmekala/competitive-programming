package com.java.concurrency.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class A010StampedLock {

	public static void main(String[] args) {
		A010StampedLock obj = new A010StampedLock();
		obj.execute();
	}

	int count = 0;
	private void execute() {
		// StampedLock don't implement reentrant characteristics
		// Returns stamp, which can be used to unlock and lock validity
		// Supports another kind of locking mode "optimistic locking"
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Map<String, String> map = new HashMap<>();
		StampedLock lock = new StampedLock();

		executor.submit(() -> {
			long stamp = lock.writeLock();
			try {
				sleep(1);
				map.put("foo", "bar");
			} finally {
				lock.unlockWrite(stamp);
			}
		});

		Runnable readTask = () -> {
			long stamp = lock.readLock();
			try {
				System.out.println(map.get("foo"));
				sleep(1);
			} finally {
				lock.unlockRead(stamp);
			}
		};

		executor.submit(readTask);
		executor.submit(readTask);

		stop(executor);

		System.out.println();
		ExecutorService executor2 = Executors.newFixedThreadPool(2);
		StampedLock lock2 = new StampedLock();

		// If already write lock is available, stamp will be 0
		// In contrast to normal read lock optimistic read lock doesn't block other
		// threads to obtain write lock
		// If other threads aquires write lock, optimistic read lock will become invalid
		executor2.submit(() -> {
			long stamp = lock2.tryOptimisticRead();
			try {
				System.out.println("Optimistic Lock Valid: " + lock2.validate(stamp));
				sleep(1);
				System.out.println("Optimistic Lock Valid: " + lock2.validate(stamp));
				sleep(2);
				System.out.println("Optimistic Lock Valid: " + lock2.validate(stamp));
			} finally {
				lock2.unlock(stamp);
			}
		});

		executor2.submit(() -> {
			long stamp = lock2.writeLock();
			try {
				System.out.println("Write Lock acquired");
				sleep(2);
			} finally {
				lock2.unlock(stamp);
				System.out.println("Write done");
			}
		});

		stop(executor2);

		System.out.println();
		ExecutorService executor3 = Executors.newFixedThreadPool(2);
		StampedLock lock3 = new StampedLock();

		count = 0;
		executor3.submit(() -> {
			long stamp = lock3.readLock();
			try {
				if (count == 0) {
					stamp = lock3.tryConvertToWriteLock(stamp);
					if (stamp == 0L) {
						System.out.println("Could not convert to write lock");
						stamp = lock3.writeLock();
					}
					count = 23;
				}
				System.out.println(count);
			} finally {
				lock3.unlock(stamp);
			}
		});

		stop(executor3);
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
