package edu.java.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

//Executors
//Callables and Futures
//Timeouts
//Invoke All
//Scheduled Executors

//Synchronized
//Lock: ReentrantLock
//Lock: ReadWriteLock
//Lock: StampedLock
//Semaphores

//AtomicInteger
//LongAdder
//LongAccumulator
//ConcurrentMap
//ConcurrentHashMap
public class Concurrency {
	public static void main(String args[]){
		Concurrency concurrency = new Concurrency();
		concurrency.start();
	}
	public void start(){
		Runnable task = () -> {
			try {
				String threadName = Thread.currentThread().getName();
				System.out.println("Hello, "+threadName);
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Hello2, "+threadName);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		//executing the runnable on main thread
		//task.run();
		
		Thread thread = new Thread(task);
		thread.start();
		System.out.println("Done!");
		
		//Executors -------------------------------------------------
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hi, "+threadName);
		});
		
		try {
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("Tasks interrupted");
		} finally{
			if(!executor.isTerminated()){
				System.out.println("close running tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}
		
		//Executors -------------------------------------------------
		
		// Callables and Futures ------------------------------------
		//Callable is also a function interface
		//But instead of void they return a value compare to Runnable
		Callable<Integer> task2 = () -> {
			TimeUnit.SECONDS.sleep(1);
			return 123;
		};
		
		//Since executor service submit doesn't wait for the results of the task we use Future to hold the results
		//Calling get method blocks the current thread until the task is finished and return the result
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<Integer> future = executorService.submit(task2);
		System.out.println("is future done? "+future.isDone());
		Integer result = null;
		try {
			result = future.get();
		}  catch (InterruptedException | ExecutionException e) {}
		System.out.println("is future done? "+future.isDone());
		System.out.println("result: "+result);
		executorService.shutdownNow();
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {}
		// Callables and Futures ------------------------------------
		
		// Timeouts -------------------------------------------------
		//Since call the get mothod blocks main thread, we can user timeouts
		ExecutorService executorService2 = Executors.newFixedThreadPool(1);
		Future<Integer> future2 = executorService2.submit(() -> {
			TimeUnit.SECONDS.sleep(10);
			return 123;
		});
		try {
			future2.get(1, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println(e);
		}
		executorService2.shutdownNow();
		// Timeouts -------------------------------------------------
		
		// Invoke All -------------------------------------------------
		List<Callable<String>> callables = Arrays.asList(
				() -> "task1",
				() -> "task2",
				() -> "task3");
		
		ExecutorService executorService3 = Executors.newWorkStealingPool();
		try {
			executorService3.invokeAll(callables)
			.stream()
			.map((future4)	 -> {
				try{
					return future4.get();
				}catch(Exception e){
					throw new IllegalStateException(e);
				}
			})
			.forEach(System.out::println);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService3.shutdown(); //comment this while testin above code
		// Invoke All -------------------------------------------------
		
		// Invoke Any -------------------------------------------------
		List<Callable<String>> callables2 = Arrays.asList(
				callable("task1", 2),
				callable("task2", 1),
				callable("task3", 3));
		ExecutorService executorService4 = Executors.newWorkStealingPool();
		try {
			String result1 = executorService4.invokeAny(callables2);
			System.out.println(result1);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executorService4.shutdown(); //comment this while testin above code
		// Invoke Any -------------------------------------------------
		
		// Scheduled Executors ----------------------------------------
		ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(1);
		Runnable task1 = () -> System.out.println("Scheduling: "+System.nanoTime());
		ScheduledFuture<?> future1 = executor1.schedule(task1, 3, TimeUnit.SECONDS);
		try {
			TimeUnit.MILLISECONDS.sleep(1337);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long remainingDelay = future1.getDelay(TimeUnit.MILLISECONDS);
		System.out.printf("Remaining Delay: %s ms\n", remainingDelay);
		executor1.shutdown(); //comment this while testin above code
		
		ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);
		Runnable task3 = () -> System.out.println("Scheduling: "+System.nanoTime());
		int initialDelay = 0;
		int period = 1;
		executor2.scheduleAtFixedRate(task3, initialDelay, period, TimeUnit.SECONDS);
		executor2.shutdown(); //comment this while testin above code
		
		ScheduledExecutorService executor3 = Executors.newScheduledThreadPool(1);
		Runnable task4 = () -> {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Scheduling: "+System.nanoTime());
			} catch (InterruptedException e) {
				System.err.println("task interrupted");
			}
		};
		executor3.scheduleWithFixedDelay(task4, 0, 1, TimeUnit.SECONDS);
		executor3.shutdown(); //comment this while testin above code
		// Scheduled Executors ----------------------------------------
		
		// Synchronized -----------------------------------------------
		ExecutorService executor5 = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10000).forEach(i -> executor5.submit(this::increment));
		System.out.println(count);
		stop(executor5);
		
		ExecutorService executor6 = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10000).forEach(i -> executor6.submit(this::incrementSync));
		System.out.println(count2);
		stop(executor6);
		// Synchronized -----------------------------------------------
		// Lock: ReentrantLock -----------------------------------------------
		ExecutorService executor7 = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10000).forEach(i -> executor7.submit(this::increment3));
		System.out.println(count3);
		stop(executor7);
		
		ExecutorService executor8 = Executors.newFixedThreadPool(2);
		ReentrantLock lock2 = new ReentrantLock();
		executor8.submit(() -> {
			lock2.lock();
			try{
				sleep(1);
			}finally{
				lock2.unlock();
			}
		});
		executor8.submit(() ->{
		    System.out.println("Locked: " + lock2.isLocked());
		    System.out.println("Held by me: " + lock2.isHeldByCurrentThread());
		    boolean locked = lock2.tryLock();								//when thread calls lock method, thread will be paused. But tryLock will not block the current thread.
		    System.out.println("Lock acquired: " + locked);
		});
		stop(executor8);
		// Lock: ReentrantLock -----------------------------------------------
		
		// Lock: ReadWriteLock -----------------------------------------------
		ExecutorService executor9 = Executors.newFixedThreadPool(2);
		Map<String, String> map1 = new HashMap<>();
		ReadWriteLock lock3 = new ReentrantReadWriteLock();

		executor9.submit(() -> {
		    lock3.writeLock().lock();
		    try {
		        sleep(1);
		        map1.put("foo", "bar");
		    } finally {
		        lock3.writeLock().unlock();
		    }
		});
		
		Runnable readTask = () -> {
		    lock3.readLock().lock();
		    try {
		        System.out.println(map1.get("foo"));
		        sleep(1);
		    } finally {
		        lock3.readLock().unlock();
		    }
		};

		executor9.submit(readTask);
		executor9.submit(readTask);

		stop(executor9);
		// Lock: ReadWriteLock -----------------------------------------------

		// Lock: StampedLock -----------------------------------------------
		// StampedLock don't implement reentrant characteristics
		// Returns stamp, which can be used to unlock and lock validitiy
		// Supports another kind of locking mode "optimistic locking"
		ExecutorService executor10 = Executors.newFixedThreadPool(2);
		Map<String, String> map10 = new HashMap<>();
		StampedLock lock10 = new StampedLock();

		executor10.submit(() -> {
		    long stamp = lock10.writeLock();
		    try {
		        sleep(1);
		        map10.put("foo", "bar");
		    } finally {
		        lock10.unlockWrite(stamp);
		    }
		});

		Runnable readTask10 = () -> {
		    long stamp = lock10.readLock();
		    try {
		        System.out.println(map10.get("foo"));
		        sleep(1);
		    } finally {
		        lock10.unlockRead(stamp);
		    }
		};

		executor10.submit(readTask10);
		executor10.submit(readTask10);

		stop(executor10);
		
		printBorder();
		ExecutorService executor11 = Executors.newFixedThreadPool(2);
		StampedLock lock = new StampedLock();

		// If already write lock is available, stamp will be 0
		// In contrast to normal read lock optimistic read lock doesn't block other threads to obtain write lock
		// If other threads aquires write lock, optimistic read lock will become invalid
		executor11.submit(() -> {
		    long stamp = lock.tryOptimisticRead();
		    try {
		        System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
		        sleep(1);
		        System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
		        sleep(2);
		        System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
		    } finally {
		        lock.unlock(stamp);
		    }
		});

		executor11.submit(() -> {
		    long stamp = lock.writeLock();
		    try {
		        System.out.println("Write Lock acquired");
		        sleep(2);
		    } finally {
		        lock.unlock(stamp);
		        System.out.println("Write done");
		    }
		});

		stop(executor11);
		
		printBorder();
		ExecutorService executor12 = Executors.newFixedThreadPool(2);
		StampedLock lock12 = new StampedLock();

		count = 0;
		executor12.submit(() -> {
		    long stamp = lock12.readLock();
		    try {
		        if (count == 0) {
		            stamp = lock12.tryConvertToWriteLock(stamp);
		            if (stamp == 0L) {
		                System.out.println("Could not convert to write lock");
		                stamp = lock12.writeLock();
		            }
		            count = 23;
		        }
		        System.out.println(count);
		    } finally {
		        lock12.unlock(stamp);
		    }
		});

		stop(executor12);
		// Lock: StampedLock -----------------------------------------------
		
		// Semaphores -----------------------------------------------
		// Locks usually grant exclusive access to a resource
		// Semaphores limit concurrent access to certain parts of application
		printBorder();
		ExecutorService executor13 = Executors.newFixedThreadPool(10);

		Semaphore semaphore = new Semaphore(5);

		Runnable longRunningTask = () -> {
		    boolean permit = false;
		    try {
		        permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
		        if (permit) {
		            System.out.println("Semaphore acquired");
		            sleep(5);
		        } else {
		            System.out.println("Could not acquire semaphore");
		        }
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    } finally {
		        if (permit) {
		            semaphore.release();
		        }
		    }
		};

		IntStream.range(0, 10)
		    .forEach(i -> executor13.submit(longRunningTask));

		stop(executor13);
		// Semaphores -----------------------------------------------
		
		// AtomicInteger -----------------------------------------------
		// Atomic classed make heavy use of Compare and Swap(CAS), an atamic instruction directly supported by most modern processors
		// Prefer Atomic classes over locks
		printBorder();
		//incrementAndGet
		AtomicInteger atomicInt = new AtomicInteger(0);
		ExecutorService executor14 = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000)
		    .forEach(i -> executor14.submit(atomicInt::incrementAndGet));
		stop(executor14);
		System.out.println(atomicInt.get()); 
		
		//updateAndGet
		AtomicInteger atomicInt15 = new AtomicInteger(0);
		ExecutorService executor15 = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000)
		    .forEach(i -> {
		        Runnable task15 = () ->
		            atomicInt15.updateAndGet(n -> n + 2);
		        executor15.submit(task15);
		    });
		stop(executor15);
		System.out.println(atomicInt15.get());
		
		//accumulateAndGet
		AtomicInteger atomicInt16 = new AtomicInteger(0);
		ExecutorService executor16 = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000)
		    .forEach(i -> {
		        Runnable task16 = () ->
		            atomicInt16.accumulateAndGet(i, (n, m) -> n + m);
		        executor16.submit(task16);
		    });
		stop(executor16);
		System.out.println(atomicInt16.get());    // => 499500
		// AtomicInteger -----------------------------------------------
		
		// LongAdder -----------------------------------------------
		// Preferable over Atomic Numbers
		// Used as counters across the multiple threads
		printBorder();
		
		LongAdder adder = new LongAdder();
		ExecutorService executor17 = Executors.newFixedThreadPool(2);

		IntStream.range(0, 1000)
		    .forEach(i -> executor17.submit(adder::increment));

		stop(executor17);

		System.out.println(adder.sumThenReset());   // => 1000
		System.out.println(adder.sum());
		// LongAdder -----------------------------------------------
		
		// LongAccumulator -----------------------------------------------
		// Generalized version of LongAdder
		printBorder();
		LongBinaryOperator op = (x, y) -> 2 * x + y;
		LongAccumulator accumulator = new LongAccumulator(op, 1L);
		ExecutorService executor18 = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10)
		    .forEach(i -> executor18.submit(() -> accumulator.accumulate(i)));
		stop(executor18);
		System.out.println(accumulator.getThenReset());     // => 2539
		// LongAccumulator -----------------------------------------------
		
		// ConcurrentMap -----------------------------------------------
		printBorder();
		ConcurrentMap<String, String> map2 = new ConcurrentHashMap<>();
		map2.put("foo", "bar");
		map2.put("han", "solo");
		map2.put("r2", "d2");
		map2.put("c3", "p0");
		
		map2.forEach((key, value) -> System.out.println(key+"="+value));
		
		String value1 = map2.putIfAbsent("c3", "p1");
		System.out.println(value1);    // p0
		
		String value2 = map2.getOrDefault("hi", "there");
		System.out.println(value2);    // there
		
		map2.replaceAll((key, value) -> "r2".equals(key) ? "d3" : value);
		System.out.println(map2.get("r2"));    // d3
		
		map2.compute("foo", (key, value) -> value + value);
		System.out.println(map2.get("foo"));   // barbar
		
		map2.merge("foo", "boo", (oldVal, newVal) -> newVal + " was " + oldVal);
		System.out.println(map2.get("foo"));   // boo was foo
		// ConcurrentMap -----------------------------------------------
		
		// ConcurrentHashMap -----------------------------------------------
		printBorder();
		System.out.println(ForkJoinPool.getCommonPoolParallelism());
		
		ConcurrentHashMap<String, String> map3 = new ConcurrentHashMap<>();
		map3.put("foo", "bar");
		map3.put("han", "solo");
		map3.put("r2", "d2");
		map3.put("c3", "p0");
		
		//ForEach
		map3.forEach(1, (key, value) ->
	    System.out.printf("key: %s; value: %s; thread: %s\n",
	        key, value, Thread.currentThread().getName()));
		
		//Search
		//As soon as a non-null value is returned, furhter processing is suppressed
		String result1 = map3.search(1, (key, value) -> {
		    System.out.println(Thread.currentThread().getName());
		    if ("foo".equals(key)) {
		        return value;
		    }
		    return null;
		});
		System.out.println("Result: " + result1);
		
		//Reduce
		String result2 = map3.reduce(1,
			    (key, value) -> {
			        System.out.println("Transform: " + Thread.currentThread().getName());
			        return key + "=" + value;
			    },
			    (s1, s2) -> {
			        System.out.println("Reduce: " + Thread.currentThread().getName());
			        return s1 + ", " + s2;
			    });

			System.out.println("Result: " + result2);
		// ConcurrentHashMap -----------------------------------------------
		
	}
	
	// Invoke Any -------------------------------------------------	
	Callable<String> callable(String result, long sleepSeconds){
		return ()->{
			TimeUnit.SECONDS.sleep(sleepSeconds);
			return result;
		};
	}
	// Invoke Any -------------------------------------------------
	
	// Synchronized -----------------------------------------------
	int count = 0;
	void increment() {
	    count = count + 1;
	}
	int count2 = 0;
	/*synchronized void incrementSync() {
	    count2 = count2 + 1;
	}*/
	void incrementSync() {
	    synchronized (this) {
	    	count2 = count2 + 1;
	    }
	}
	// Synchronized -----------------------------------------------
	
	// Lock: ReentrantLock -----------------------------------------------
	int count3 = 0;
	ReentrantLock lock = new ReentrantLock();
	void increment3() {
		lock.lock();
		try{
			count3 = count3 + 1;
		}finally{
			lock.unlock();
		}		
	}
	// Lock: ReentrantLock -----------------------------------------------
	
	//Utils
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
    private void printBorder(){
    	System.out.println("--------------------------------------------------------");
    }
}
