# Multithreading and Concurrency

## Table of Contents

### Part 1 | Threads, Processes, and Their Memory Model in Depth
- [1. Introduction to Multithreading & Concurrency](#1-introduction-to-multithreading--concurrency)
- [2. Process vs. Thread](#2-process-vs-thread)
- [3. Java Memory Model (JMM)](#3-java-memory-model-jmm)
- [4. Creating Threads in Java](#4-creating-threads-in-java)
- [5. Thread Lifecycle in Java](#5-thread-lifecycle-in-java)
- [6. Thread Methods](#6-thread-methods)
- [7. Multithreading Issues & Synchronization](#7-multithreading-issues--synchronization)
- [8. Volatile Keyword](#8-volatile-keyword)
- [9. Summary](#9-summary)

### Part 2 | Thread Creation, Thread Lifecycle, and Inter-Thread Communication
- [1. Creating Threads in Java](#1-creating-threads-in-java)
- [2. Thread Lifecycle in Java](#2-thread-lifecycle-in-java)
- [3. Inter-Thread Communication in Java](#3-inter-thread-communication-in-java)
- [4. Thread Methods for Communication](#4-thread-methods-for-communication)
- [5. Deadlock in Multithreading](#5-deadlock-in-multithreading)
- [6. Summary](#6-summary)

### Part 3 | Thread Joining, Daemon Thread, and Thread Priority
- [1. Thread Joining in Java (`join()` Method)](#1-thread-joining-in-java-join-method)
- [2. Daemon Threads in Java](#2-daemon-threads-in-java)
- [3. Thread Priority in Java](#3-thread-priority-in-java)
- [4. Summary](#4-summary)

### Part 4 | Locks and Conditions in Java | 🔒 ReentrantLock, ReadWriteLock, StampedLock, Semaphore
- [1. Why Use Locks Instead of `synchronized`?](#1-why-use-locks-instead-of-synchronized)
- [2. ReentrantLock (Basic Locking)](#2-reentrantlock-basic-locking)
- [3. ReadWriteLock (Optimized for Read-Heavy Operations)](#3-readwritelock-optimized-for-read-heavy-operations)
- [4. StampedLock (Improved ReadWriteLock)](#4-stampedlock-improved-readwritelock)
- [5. Semaphore (Thread Synchronization Control)](#5-semaphore-thread-synchronization-control)
- [6. Summary](#6-summary-1)

### Part 5 | Lock-Free Concurrency, Compare-and-Swap, Atomic & Volatile Variables
- [1. Volatile Variables in Java](#1-volatile-variables-in-java)
- [2. Compare-And-Swap (CAS) & Atomic Variables](#2-compare-and-swap-cas--atomic-variables)
- [3. Atomic Variables (Using `java.util.concurrent.atomic` Package)](#3-atomic-variables-using-javautilconcurrentatomic-package)
- [4. Other Atomic Classes in Java](#4-other-atomic-classes-in-java)
- [5. CAS (Compare-And-Swap) in Action](#5-cas-compare-and-swap-in-action)
- [6. Summary](#6-summary-2)

### Part 6 | Thread Pools in Java | ThreadPoolExecutor Framework
- [1. What is a Thread Pool?](#1-what-is-a-thread-pool)
- [2. Creating Thread Pools in Java](#2-creating-thread-pools-in-java)
- [3. Types of Thread Pools in Java (`Executors` Factory Methods)](#3-types-of-thread-pools-in-java-executors-factory-methods)
- [4. ThreadPoolExecutor - Custom Thread Pool](#4-threadpoolexecutor---custom-thread-pool)
- [5. Handling Task Rejections (`RejectedExecutionHandler`)](#5-handling-task-rejections-rejectedexecutionhandler)
- [6. Scheduled Thread Pool (`ScheduledThreadPoolExecutor`)](#6-scheduled-thread-pool-scheduledthreadpoolexecutor)
- [7. Summary](#7-summary)
- [8. Key Takeaways](#8-key-takeaways)

### Part 7 | Java 8 CompletableFuture | Future and Callable in Java
- [1. Introduction to Asynchronous Programming in Java](#1-introduction-to-asynchronous-programming-in-java)
- [2. Future and Callable (Java 5)](#2-future-and-callable-java-5)
- [3. CompletableFuture (Java 8)](#3-completablefuture-java-8)
- [4. Chaining Async Calls (`thenApply`, `thenAccept`)](#4-chaining-async-calls-thenapply-thenaccept)
- [5. Combining Multiple Futures](#5-combining-multiple-futures)
- [6. Running Multiple Futures in Parallel](#6-running-multiple-futures-in-parallel)
- [7. Exception Handling in CompletableFuture](#7-exception-handling-in-completablefuture)
- [8. Custom Thread Pool in CompletableFuture](#8-custom-thread-pool-in-completablefuture)
- [9. Summary](#9-summary-1)

### Java Thread Pools and ForkJoinPool
- [1. Introduction to Thread Pools](#1-introduction-to-thread-pools)
- [2. Types of Thread Pools in Java (`ExecutorService`)](#2-types-of-thread-pools-in-java-executorservice)
- [3. ForkJoinPool (Work-Stealing Pool)](#3-forkjoinpool-work-stealing-pool)
- [4. WorkStealingPool](#4-workstealingpool)
- [5. Comparing Thread Pools](#5-comparing-thread-pools)
- [6. Conclusion](#6-conclusion)

### Java ScheduledThreadPoolExecutor and Thread Termination
- [1. Introduction to ScheduledThreadPoolExecutor](#1-introduction-to-scheduledthreadpoolexecutor)
- [2. Creating a ScheduledThreadPoolExecutor](#2-creating-a-scheduledthreadpoolexecutor)
- [3. Scheduling Periodic Tasks](#3-scheduling-periodic-tasks)
- [4. Shutting Down Thread Pools](#4-shutting-down-thread-pools)
- [5. shutdown() vs shutdownNow() vs awaitTermination()](#5-shutdown-vs-shutdownnow-vs-awaittermination)
- [6. Complete Example](#6-complete-example)

### Java Virtual Threads vs Normal Threads | ThreadLocal in Java
- [1. Introduction to Java Virtual Threads (JDK 19/21)](#1-introduction-to-java-virtual-threads-jdk-1921)
- [2. Normal Threads vs Virtual Threads](#2-normal-threads-vs-virtual-threads)
- [3. Virtual Threads in ExecutorService](#3-virtual-threads-in-executorservice)
- [4. When to Use Normal vs Virtual Threads?](#4-when-to-use-normal-vs-virtual-threads)
- [5. ThreadLocal in Java](#5-threadlocal-in-java)
- [6. Summary](#6-summary-3)

### Lombok Features in Java
- [1. `val` and `var`](#1-val-and-var)
- [2. `@NonNull`](#2-nonnull)
- [3. `@Getter` and `@Setter`](#3-getter-and-setter)
- [4. `@ToString`](#4-tostring)
- [5. `@NoArgsConstructor`, `@AllArgsConstructor`, `@RequiredArgsConstructor`](#5-noargsconstructor-allargsconstructor-requiredargsconstructor)
- [6. `@EqualsAndHashCode`](#6-equalsandhashcode)
- [7. `@Data`](#7-data)
- [8. `@Value`](#8-value)
- [9. `@Builder`](#9-builder)
- [10. `@Cleanup`](#10-cleanup)

### Java 17: Sealed Classes and Interfaces
- [Key Concept](#key-concept)
- [How It Works](#how-it-works)
- [Rules for Subclasses](#rules-for-subclasses)
- [Important Conditions](#important-conditions)
- [Example Hierarchy](#example-hierarchy)
- [Benefits](#benefits)

---

## Part 1 | Threads, Processes, and Their Memory Model in Depth

---

### 1. Introduction to Multithreading & Concurrency

Multithreading in Java allows **multiple threads** to run **concurrently**, enabling parallel execution and efficient CPU utilization.

✔ **Thread = Lightweight process**
✔ **Concurrency = Multiple tasks appear to run simultaneously**
✔ **Parallelism = True simultaneous execution on multi-core CPUs**

#### Why Use Multithreading?

✔ **Better CPU Utilization** - Uses idle CPU time efficiently.
✔ **Faster Execution** - Parallel execution speeds up computations.
✔ **Better Responsiveness** - UI applications remain responsive.
✔ **Supports Asynchronous Processing** - Useful for I/O and network operations.

---

### 2. Process vs. Thread

| Feature               | Process                                   | Thread                                        |
| --------------------- | ----------------------------------------- | --------------------------------------------- |
| **Definition**        | A self-contained execution unit           | A lightweight execution unit within a process |
| **Memory Sharing**    | Each process has its own memory space     | Threads share memory within a process         |
| **Communication**     | Inter-process communication (IPC) is slow | Threads communicate faster via shared memory  |
| **Context Switching** | More expensive                            | Less expensive                                |
| **Creation Time**     | More time-consuming                       | Faster to create                              |

🔹 **Java applications run as a single process, and threads run inside that process.**

---

### 3. Java Memory Model (JMM)

#### How Threads Interact with Memory?

* Each **Thread** has its own **working memory (cache)**.
* All threads share the **main memory (Heap, Method Area, Static Memory, etc.).**
* **JMM ensures proper synchronization of shared memory**.

#### Java Memory Areas

```
┌──────────────────────────┐
│         Heap Memory      │  -> Shared memory for objects (accessible by all threads)
├──────────────────────────┤
│      Method Area         │  -> Stores class structures, static variables
├──────────────────────────┤
│   Stack Memory (Thread)  │  -> Each thread has its own stack
├──────────────────────────┤
│   PC Register (Thread)   │  -> Stores address of current instruction
├──────────────────────────┤
│    Native Method Stack   │  -> Native (non-Java) methods execution
└──────────────────────────┘
```

🔹 **Each thread has a separate Stack & PC Register, but shares the Heap.**

---

### 4. Creating Threads in Java

There are **two main ways** to create threads in Java:

#### 4.1 Extending the `Thread` Class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // Starts a new thread
    }
}
```

✔ **Easy to implement**
❌ **Cannot extend another class**

#### 4.2 Implementing `Runnable` Interface (Preferred)

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}
```

✔ **More flexible (can extend another class)**
✔ **Better for resource sharing**

---

### 5. Thread Lifecycle in Java

```
        NEW
          ↓
       RUNNABLE
      ↗       ↘
 WAITING   TIMED_WAITING
      ↘       ↙
      BLOCKED
          ↓
     TERMINATED
```

#### Thread States

| State              | Description                                        |
| ------------------ | -------------------------------------------------- |
| **NEW**            | Created but not started (`new Thread()`)           |
| **RUNNABLE**       | Eligible for execution (`start()`)                 |
| **BLOCKED**        | Waiting for a monitor lock                         |
| **WAITING**        | Waiting indefinitely for another thread (`wait()`) |
| **TIMED_WAITING** | Waiting for a fixed time (`sleep(1000)`)           |
| **TERMINATED**     | Thread execution is finished                       |

---

### 6. Thread Methods

| Method      | Description                                   |
| ----------- | --------------------------------------------- |
| `start()`   | Starts the thread (calls `run()`)             |
| `run()`     | Code executed by the thread                   |
| `sleep(ms)` | Pauses execution for `ms` milliseconds        |
| `join()`    | Waits for another thread to complete          |
| `yield()`   | Suggests thread scheduler to switch execution |
| `isAlive()` | Checks if thread is still running             |

#### Example of `sleep()` and `join()`

```java
class Example extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread running: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Example t1 = new Example();
        t1.start();
        t1.join(); // Main thread waits for t1 to complete
        System.out.println("Main thread finished");
    }
}
```

---

### 7. Multithreading Issues & Synchronization

#### 7.1 Race Condition (Shared Data Problem)

When multiple threads modify a shared resource simultaneously, unexpected results can occur.

```java
class Counter {
    int count = 0;
    void increment() {
        count++; // Not thread-safe!
    }
}

public class RaceConditionDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> { for (int i = 0; i < 1000; i++) counter.increment(); });
        Thread t2 = new Thread(() -> { for (int i = 0; i < 1000; i++) counter.increment(); });

        t1.start();
        t2.start();
        System.out.println(counter.count); // May give unpredictable output!
    }
}
```

#### 7.2 Synchronization to Fix Race Condition

```java
class Counter {
    int count = 0;
    synchronized void increment() { // Ensures thread safety
        count++;
    }
}
```

✔ **Ensures one thread at a time modifies `count`**
✔ **Prevents race conditions**

---

### 8. Volatile Keyword

* Ensures **visibility** of updates to variables across threads.
* Prevents **caching of variables** in thread-local memory.

```java
class Example {
    private volatile boolean running = true;

    void stop() {
        running = false; // Change is immediately visible to all threads
    }
}
```

✔ **Useful for flags and state variables**
❌ **Does NOT guarantee atomicity**

---

### 9. Summary

✔ **Threads allow parallel execution in Java**
✔ **Java Memory Model ensures proper synchronization**
✔ **Use `Thread` or `Runnable` to create threads**
✔ **Synchronization & `volatile` prevent concurrency issues**

---

## Part 2 | Thread Creation, Thread Lifecycle, and Inter-Thread Communication

---

### 1. Creating Threads in Java

There are **three main ways** to create a thread in Java:

#### 1.1 Extending the `Thread` Class

```java
class MyThread extends Thread {
    public void run() {  // Override run() method
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();  // Starts a new thread
    }
}
```

✔ **Simple implementation**
❌ **Cannot extend another class (Java does not support multiple inheritance)**

---

#### 1.2 Implementing `Runnable` Interface (Preferred)

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}
```

✔ **More flexible (can extend another class)**
✔ **Better for resource sharing**

---

#### 1.3 Using `Callable` and `Future` (Returns a Result)

```java
import java.util.concurrent.*;

class MyCallable implements Callable<Integer> {
    public Integer call() {
        return 42;  // Thread returns a result
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new MyCallable());
        System.out.println("Result: " + future.get()); // Waits for result
        executor.shutdown();
    }
}
```

✔ **Can return results**
✔ **Can throw checked exceptions**

---

### 2. Thread Lifecycle in Java

```
        NEW
          ↓
       RUNNABLE
      ↗       ↘
 WAITING   TIMED_WAITING
      ↘       ↙
      BLOCKED
          ↓
     TERMINATED
```

#### Thread States and Transitions

| State              | Description                                        |
| ------------------ | -------------------------------------------------- |
| **NEW**            | Created but not started (`new Thread()`)           |
| **RUNNABLE**       | Eligible for execution (`start()`)                 |
| **BLOCKED**        | Waiting for a monitor lock                         |
| **WAITING**        | Waiting indefinitely for another thread (`wait()`) |
| **TIMED_WAITING** | Waiting for a fixed time (`sleep(1000)`)           |
| **TERMINATED**     | Thread execution is finished                       |

#### Example of Lifecycle Methods

```java
class LifecycleExample extends Thread {
    public void run() {
        try {
            Thread.sleep(2000); // TIMED_WAITING
            System.out.println(Thread.currentThread().getName() + " is running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LifecycleExample t1 = new LifecycleExample();
        System.out.println("Thread State: " + t1.getState()); // NEW

        t1.start();
        System.out.println("Thread State: " + t1.getState()); // RUNNABLE

        Thread.sleep(100);
        System.out.println("Thread State: " + t1.getState()); // TIMED_WAITING
    }
}
```

---

### 3. Inter-Thread Communication in Java

Threads can communicate using **`wait()`, `notify()`, and `notifyAll()`**.

#### 3.1 `wait()` and `notify()` Example

```java
class SharedResource {
    private int value = 0;
    private boolean available = false;

    public synchronized void produce(int newValue) {
        while (available) { // Wait if value is not consumed
            try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        value = newValue;
        available = true;
        System.out.println("Produced: " + value);
        notify(); // Notify consumer
    }

    public synchronized void consume() {
        while (!available) { // Wait if no value is produced
            try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println("Consumed: " + value);
        available = false;
        notify(); // Notify producer
    }
}

class Producer extends Thread {
    private SharedResource resource;
    Producer(SharedResource r) { this.resource = r; }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.produce(i);
        }
    }
}

class Consumer extends Thread {
    private SharedResource resource;
    Consumer(SharedResource r) { this.resource = r; }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            resource.consume();
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        new Producer(resource).start();
        new Consumer(resource).start();
    }
}
```

#### Explanation

✔ `wait()` makes the thread **release lock and wait**.
✔ `notify()` wakes up **one waiting thread**.
✔ `notifyAll()` wakes up **all waiting threads**.

---

### 4. Thread Methods for Communication

| Method        | Description                                 |
| ------------- | ------------------------------------------- |
| `wait()`      | Makes a thread wait (releases lock)         |
| `notify()`    | Wakes up a single waiting thread            |
| `notifyAll()` | Wakes up all waiting threads                |
| `join()`      | Makes one thread wait for another to finish |

---

### 5. Deadlock in Multithreading

A **deadlock** occurs when two or more threads are **waiting for each other's lock**, resulting in an infinite wait.

#### Example of Deadlock

```java
class DeadlockExample {
    static final Object resource1 = new Object();
    static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1 locked resource1");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (resource2) {
                    System.out.println("Thread 1 locked resource2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2 locked resource2");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (resource1) {
                    System.out.println("Thread 2 locked resource1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

🔹 **Avoid deadlocks by acquiring locks in a consistent order.**

---

### 6. Summary

✔ **Threads can be created using `Thread`, `Runnable`, and `Callable`.**
✔ **Thread lifecycle includes NEW, RUNNABLE, WAITING, TIMED_WAITING, BLOCKED, and TERMINATED states.**
✔ **Inter-thread communication is achieved using `wait()`, `notify()`, and `notifyAll()`.**
✔ **Deadlocks occur when multiple threads hold locks in an inconsistent order.**

---

## Part 3 | Thread Joining, Daemon Thread, and Thread Priority

---

### 1. Thread Joining in Java (`join()` Method)

In Java, the `join()` method allows one thread to **wait for another thread to finish execution** before continuing.

#### 1.1 Basic Example of `join()`

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                Thread.sleep(500); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t1.join();  // Main thread waits until t1 finishes

        t2.start();
        t2.join();  // Main thread waits until t2 finishes

        System.out.println("Main thread execution completed!");
    }
}
```

#### Explanation

✔ `join()` makes the calling thread **wait** until the target thread completes.
✔ **Without `join()`**, threads may run in unpredictable order.
✔ Can use `join(time_in_ms)` to wait for a fixed time.

#### 1.2 Using `join(time_in_ms)`

```java
t1.join(1000); // Main thread waits for 1 second or until t1 finishes
```

---

### 2. Daemon Threads in Java

A **Daemon Thread** is a background thread that **runs indefinitely** but automatically terminates when all user threads finish execution.

#### 2.1 Creating a Daemon Thread

```java
class DaemonThreadExample extends Thread {
    public void run() {
        while (true) {
            System.out.println("Daemon Thread running...");
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    public static void main(String[] args) {
        DaemonThreadExample daemon = new DaemonThreadExample();
        daemon.setDaemon(true); // Setting the thread as Daemon
        daemon.start();

        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Main thread finished execution!");
    }
}
```

#### Explanation

✔ **Set daemon mode using `setDaemon(true)`** before `start()`.
✔ **Daemon threads run in the background**, usually for tasks like garbage collection, log monitoring, etc.
✔ If all user threads finish, **daemon threads terminate automatically**.

#### 2.2 Key Differences Between User & Daemon Threads

| User Thread                       | Daemon Thread                                        |
| --------------------------------- | ---------------------------------------------------- |
| Runs until execution is completed | Terminates when all user threads finish              |
| Used for main application logic   | Used for background tasks (e.g., garbage collection) |
| Does not stop automatically       | Stops automatically when JVM exits                   |

---

### 3. Thread Priority in Java

Every thread in Java has a **priority between 1 and 10**:

* **MIN_PRIORITY = 1**
* **NORM_PRIORITY = 5 (default)**
* **MAX_PRIORITY = 10**

Threads with **higher priority** get more CPU time, but **scheduling is still OS-dependent**.

#### 3.1 Setting and Getting Thread Priority

```java
class PriorityExample extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Priority: " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        PriorityExample t1 = new PriorityExample();
        PriorityExample t2 = new PriorityExample();
        PriorityExample t3 = new PriorityExample();

        t1.setPriority(Thread.MIN_PRIORITY);  // 1
        t2.setPriority(Thread.NORM_PRIORITY); // 5 (default)
        t3.setPriority(Thread.MAX_PRIORITY);  // 10

        t1.start();
        t2.start();
        t3.start();
    }
}
```

#### 3.2 Does Priority Guarantee Execution Order?

❌ **No!** Thread priority **affects scheduling but does not guarantee order**.
✔ **The actual scheduling depends on the OS and JVM.**

---

### 4. Summary

✔ `join()` makes a thread **wait until another thread finishes execution**.
✔ **Daemon threads run in the background** and stop automatically when user threads finish.
✔ **Thread priority affects scheduling** but does not guarantee execution order.

---

## Part 4 | Locks and Conditions in Java | 🔒 ReentrantLock, ReadWriteLock, StampedLock, Semaphore

---

### 1. Why Use Locks Instead of `synchronized`?

Java's `synchronized` keyword provides **implicit locking**, but it has limitations:
❌ **Blocking:** A thread acquiring a lock **blocks others** until it releases it.
❌ **No Try-Lock Mechanism:** No way to check if a lock is available before acquiring.
❌ **No Fairness Control:** No guarantee which waiting thread will acquire the lock next.

✅ **Java `Lock` API (java.util.concurrent.locks)** solves these issues by providing **explicit locking with more control**.

---

### 2. ReentrantLock (Basic Locking)

A **ReentrantLock** is similar to `synchronized`, but with additional features:
✔ Can attempt to acquire a lock **without blocking (`tryLock()`)**
✔ Supports **fairness policy** (FIFO scheduling)
✔ Allows **interruptible locks**

#### 2.1 ReentrantLock Example

```java
import java.util.concurrent.locks.*;

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void accessResource(String threadName) {
        lock.lock();  // Acquire the lock
        try {
            System.out.println(threadName + " accessing resource...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  // Release the lock
        }
    }
}

class MyThread extends Thread {
    SharedResource resource;

    MyThread(SharedResource resource, String name) {
        super(name);
        this.resource = resource;
    }

    public void run() {
        resource.accessResource(Thread.currentThread().getName());
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        MyThread t1 = new MyThread(resource, "Thread-1");
        MyThread t2 = new MyThread(resource, "Thread-2");

        t1.start();
        t2.start();
    }
}
```

🔹 **Key Features:**
✔ **Explicit Locking** → `lock.lock()` and `lock.unlock()`
✔ **Ensures only one thread enters the critical section**
✔ **Supports fairness:** `new ReentrantLock(true)` enables FIFO order

---

### 3. ReadWriteLock (Optimized for Read-Heavy Operations)

A **ReadWriteLock** allows multiple **readers** at the same time, but only **one writer**.
Useful in scenarios where **read operations are frequent but writes are rare**.

#### 3.1 ReadWriteLock Example

```java
import java.util.concurrent.locks.*;

class SharedData {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private int data = 0;

    public void readData(String threadName) {
        lock.readLock().lock();
        try {
            System.out.println(threadName + " reading data: " + data);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeData(String threadName, int value) {
        lock.writeLock().lock();
        try {
            System.out.println(threadName + " writing data: " + value);
            data = value;
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

public class ReadWriteLockExample {
    public static void main(String[] args) {
        SharedData resource = new SharedData();

        // Multiple readers
        new Thread(() -> resource.readData("Reader-1")).start();
        new Thread(() -> resource.readData("Reader-2")).start();

        // Single writer
        new Thread(() -> resource.writeData("Writer", 100)).start();
    }
}
```

🔹 **Key Features:**
✔ **Multiple threads can read at the same time (`readLock()`)**
✔ **Only one thread can write at a time (`writeLock()`)**
✔ **Improves performance for read-heavy applications**

---

### 4. StampedLock (Improved ReadWriteLock)

StampedLock is an **advanced version of ReadWriteLock**, optimized for performance:
✔ Supports **optimistic reading** (does not block writers if data is unchanged)
✔ **More efficient than ReadWriteLock** in high-performance applications

#### 4.1 StampedLock Example

```java
import java.util.concurrent.locks.*;

class SharedStampedData {
    private final StampedLock lock = new StampedLock();
    private int data = 0;

    public void readData(String threadName) {
        long stamp = lock.tryOptimisticRead();
        int readValue = data;
        if (!lock.validate(stamp)) {  // Check if the value changed
            stamp = lock.readLock();
            try { readValue = data; } finally { lock.unlockRead(stamp); }
        }
        System.out.println(threadName + " read: " + readValue);
    }

    public void writeData(String threadName, int value) {
        long stamp = lock.writeLock();
        try {
            data = value;
            System.out.println(threadName + " wrote: " + value);
        } finally {
            lock.unlockWrite(stamp);
        }
    }
}

public class StampedLockExample {
    public static void main(String[] args) {
        SharedStampedData resource = new SharedStampedData();

        new Thread(() -> resource.readData("Reader-1")).start();
        new Thread(() -> resource.writeData("Writer", 200)).start();
    }
}
```

🔹 **Key Features:**
✔ **Optimistic Read → Faster than normal `readLock()`**
✔ **Good for scenarios where reads are frequent and writes are rare**

---

### 5. Semaphore (Thread Synchronization Control)

A **Semaphore** is used to control the number of threads that can access a resource simultaneously.

#### 5.1 Semaphore Example

```java
import java.util.concurrent.*;

class SharedPrinter {
    private final Semaphore semaphore = new Semaphore(2); // Only 2 threads can access at a time

    public void print(String threadName) {
        try {
            semaphore.acquire();  // Acquire a permit
            System.out.println(threadName + " is printing...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(threadName + " finished printing.");
            semaphore.release();  // Release the permit
        }
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter();

        for (int i = 1; i <= 5; i++) {
            final int id = i;
            new Thread(() -> printer.print("Thread-" + id)).start();
        }
    }
}
```

🔹 **Key Features:**
✔ **Limits concurrent access to a resource**
✔ **Prevents too many threads from using a shared resource at the same time**

---

### 6. Summary

| Lock Type         | Best Use Case             | Key Features                                           |
| ----------------- | ------------------------- | ------------------------------------------------------ |
| **ReentrantLock** | General synchronization   | `lock()` & `unlock()`, fairness policy                 |
| **ReadWriteLock** | Read-heavy applications   | `readLock()` (multiple), `writeLock()` (one at a time) |
| **StampedLock**   | Optimized read-heavy apps | Optimistic reading (faster), `validate()` method       |
| **Semaphore**     | Limit concurrent access   | Controls no. of threads accessing a resource           |

---

## Part 5 | Lock-Free Concurrency, Compare-and-Swap, Atomic & Volatile Variables

Lock-based synchronization mechanisms (e.g., `synchronized`, `ReentrantLock`) can cause **performance issues** due to blocking and context switching. **Lock-free concurrency** techniques help improve efficiency by avoiding traditional locks.

---

### 1. Volatile Variables in Java

🔹 **What is `volatile`?**
A `volatile` variable in Java **ensures visibility** of updates across threads **but does not provide atomicity**.

#### 1.1 Problem Without `volatile` (Visibility Issue)

```java
class SharedResource {
    private boolean flag = false; // Not volatile

    public void setFlag() {
        flag = true;
    }

    public boolean getFlag() {
        return flag;
    }
}

public class VolatileIssueExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        new Thread(() -> {
            while (!resource.getFlag()) { }  // Loop may not exit due to caching
            System.out.println("Flag detected as true!");
        }).start();

        try { Thread.sleep(2000); } catch (InterruptedException e) { }
        resource.setFlag();  // Another thread updates flag
    }
}
```

🔹 **Why is there a problem?**
✔ The **JVM may cache** the `flag` variable, and other threads may **not see updates immediately**.

#### 1.2 Using `volatile` to Fix the Issue

```java
class SharedResource {
    private volatile boolean flag = false; // Volatile ensures visibility

    public void setFlag() {
        flag = true;
    }

    public boolean getFlag() {
        return flag;
    }
}
```

✔ **Ensures all threads see the latest value of `flag`**.
❌ **Does NOT guarantee atomicity for compound actions (`flag++` is NOT atomic!).**

---

### 2. Compare-And-Swap (CAS) & Atomic Variables

#### 2.1 What is CAS?

CAS (**Compare-And-Swap**) is a **lock-free** technique that:
1️⃣ Reads a value from memory.
2️⃣ Compares it with an expected value.
3️⃣ If the value is unchanged, updates it.
4️⃣ If changed, retries the operation.

🔹 Used in **Java's `java.util.concurrent.atomic` package** to provide **atomic operations without locking**.

---

### 3. Atomic Variables (Using `java.util.concurrent.atomic` Package)

Java provides **Atomic classes** to perform atomic operations using **CAS instead of locks**.

#### 3.1 AtomicInteger Example

```java
import java.util.concurrent.atomic.*;

class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet(); // Atomic operation
    }

    public int getValue() {
        return count.get();
    }
}

public class AtomicExample {
    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("Final count: " + counter.getValue()); // Always 2000
    }
}
```

✔ **Ensures thread safety without using `synchronized` or `ReentrantLock`**.

---

### 4. Other Atomic Classes in Java

| Atomic Class         | Description                                                               |
| -------------------- | ------------------------------------------------------------------------- |
| `AtomicInteger`      | Integer with atomic operations (`incrementAndGet()`, `decrementAndGet()`) |
| `AtomicLong`         | Long type atomic operations                                               |
| `AtomicBoolean`      | Boolean type atomic operations                                            |
| `AtomicReference<V>` | Atomic operations for an object reference                                 |

#### 4.1 AtomicReference Example

```java
import java.util.concurrent.atomic.*;

class SharedData {
    private AtomicReference<String> message = new AtomicReference<>("Hello");

    public void updateMessage(String newMsg) {
        message.set(newMsg);
    }

    public String getMessage() {
        return message.get();
    }
}

public class AtomicReferenceExample {
    public static void main(String[] args) {
        SharedData data = new SharedData();

        new Thread(() -> data.updateMessage("New Message")).start();
        new Thread(() -> System.out.println("Message: " + data.getMessage())).start();
    }
}
```

✔ **Ensures safe updates to an object reference in multithreading**.

---

### 5. CAS (Compare-And-Swap) in Action

#### 5.1 Using `compareAndSet()`

```java
import java.util.concurrent.atomic.*;

class CASCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void safeIncrement() {
        int oldValue, newValue;
        do {
            oldValue = count.get();  // Read current value
            newValue = oldValue + 1; // Calculate new value
        } while (!count.compareAndSet(oldValue, newValue)); // If unchanged, update
    }

    public int getValue() {
        return count.get();
    }
}

public class CASExample {
    public static void main(String[] args) {
        CASCounter counter = new CASCounter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.safeIncrement();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("Final count: " + counter.getValue()); // Always 2000
    }
}
```

🔹 **How it works:**
✔ **Reads value, calculates new value, then swaps if no other thread modified it.**
✔ **Retry mechanism** if another thread modified the value before the update.

---

### 6. Summary

| Concept           | Usage                             | Provides Thread Safety?   |
| ----------------- | --------------------------------- | ------------------------- |
| `volatile`        | Ensures visibility across threads | ✅ Yes (but NOT atomicity) |
| `AtomicInteger`   | Atomic operations for integers    | ✅ Yes (via CAS)           |
| `AtomicReference` | Atomic updates for objects        | ✅ Yes (via CAS)           |
| `compareAndSet()` | Lock-free atomic update mechanism | ✅ Yes (via CAS)           |

---

## Part 6 | Thread Pools in Java | ThreadPoolExecutor Framework

Thread creation is **expensive**, especially in applications requiring frequent task execution. Instead of creating a new thread each time, we use **Thread Pools**, which manage a fixed number of reusable threads.

---

### 1. What is a Thread Pool?

A **Thread Pool** is a pool of pre-instantiated, reusable threads that execute tasks, improving **performance** and **resource management**.

🔹 **Advantages of Thread Pools:**
✔ Reduces overhead of creating/destroying threads.
✔ Optimizes CPU utilization.
✔ Prevents system resource exhaustion.
✔ Efficient task execution by managing concurrent threads.

---

### 2. Creating Thread Pools in Java

Java provides the `ExecutorService` interface and `ThreadPoolExecutor` class to manage thread pools.

#### 2.1 Creating a Thread Pool using `Executors`

Java provides a factory class `Executors` to create different types of thread pools.

```java
import java.util.concurrent.*;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // Pool of 3 threads

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            });
        }

        executor.shutdown(); // Shutdown the pool after task execution
    }
}
```

**Output Example**
```
Executing Task 1 by pool-1-thread-1
Executing Task 2 by pool-1-thread-2
Executing Task 3 by pool-1-thread-3
Executing Task 4 by pool-1-thread-1
Executing Task 5 by pool-1-thread-2
```

🔹 **How it works?**

* **Creates a thread pool of size 3.**
* **Executes 5 tasks using available threads.**
* **Reuses threads when a task is completed.**

---

### 3. Types of Thread Pools in Java (`Executors` Factory Methods)

| Method                                | Description                                                    |
| ------------------------------------- | -------------------------------------------------------------- |
| `Executors.newFixedThreadPool(n)`     | Fixed-size thread pool with `n` threads.                       |
| `Executors.newCachedThreadPool()`     | Creates threads dynamically as needed but reuses idle threads. |
| `Executors.newSingleThreadExecutor()` | Single-threaded executor (executes tasks sequentially).        |
| `Executors.newScheduledThreadPool(n)` | Fixed-size pool for scheduled tasks (like `cron` jobs).        |

#### 3.1 `newCachedThreadPool()` Example (Dynamic Thread Management)

```java
ExecutorService executor = Executors.newCachedThreadPool();
```

✔ Creates threads as needed, but **reuses idle threads** for new tasks.
✔ Suitable for **short-lived, high-volume tasks**.

---

### 4. ThreadPoolExecutor - Custom Thread Pool

For **fine-grained control**, use `ThreadPoolExecutor` instead of `Executors`.

```java
import java.util.concurrent.*;

public class CustomThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,  // Core pool size
            4,  // Maximum pool size
            60, // Time before excess idle threads are terminated
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(2) // Task queue (capacity 2)
        );

        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
                try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
            });
        }

        executor.shutdown();
    }
}
```

🔹 **Key Parameters:**

* `corePoolSize`: Minimum number of threads in the pool.
* `maximumPoolSize`: Maximum number of threads.
* `keepAliveTime`: Time an idle thread waits before termination.
* `BlockingQueue<Runnable>`: Task queue for holding tasks before execution.

---

### 5. Handling Task Rejections (`RejectedExecutionHandler`)

If a thread pool's task queue is full, tasks **may be rejected**.
Java provides `RejectedExecutionHandler` to define custom rejection handling.

#### 5.1 Example: Custom Rejection Policy

```java
class CustomRejectionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: " + r.toString());
    }
}

public class RejectedExecutionExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, 2, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(2), // Small queue (2 tasks)
            new CustomRejectionHandler()
        );

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
                try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
            });
        }

        executor.shutdown();
    }
}
```

✔ **Custom handler logs rejected tasks.**

---

### 6. Scheduled Thread Pool (`ScheduledThreadPoolExecutor`)

For tasks that need to be **executed periodically**, use `ScheduledThreadPoolExecutor`.

#### 6.1 Example: Scheduling a Task

```java
import java.util.concurrent.*;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        Runnable task = () -> System.out.println("Scheduled Task Executed: " + System.currentTimeMillis());

        // Execute task after an initial delay of 2 seconds, then every 3 seconds
        scheduler.scheduleAtFixedRate(task, 2, 3, TimeUnit.SECONDS);

        // Stop after 10 seconds
        try { Thread.sleep(10000); } catch (InterruptedException e) { e.printStackTrace(); }
        scheduler.shutdown();
    }
}
```

🔹 **Use Cases:**
✔ Running **cron jobs** (e.g., **data backups, log rotation**).
✔ **Polling external APIs** periodically.

---

### 7. Summary

| Feature            | FixedThreadPool                     | CachedThreadPool                  | ScheduledThreadPool                        | SingleThreadExecutor |
| ------------------ | ----------------------------------- | --------------------------------- | ------------------------------------------ | -------------------- |
| **Thread Count**   | Fixed (`n` threads)                 | Dynamic (grows/shrinks as needed) | Fixed (`n` threads)                        | Single thread        |
| **Task Execution** | Handles multiple tasks concurrently | Reuses existing threads           | Executes tasks with delay or at fixed rate | One task at a time   |
| **Use Case**       | Fixed workload                      | High volume short tasks           | Periodic tasks                             | Sequential execution |

---

### 8. Key Takeaways

✅ Use `ExecutorService` instead of manually creating threads.
✅ Choose the right thread pool based on workload:

* **FixedThreadPool**: Constant number of threads.
* **CachedThreadPool**: Scales dynamically.
* **ScheduledThreadPool**: Periodic tasks.
* **SingleThreadExecutor**: One thread execution.

✅ Use `ThreadPoolExecutor` for **fine-grained control**.
✅ Handle **task rejections** using `RejectedExecutionHandler`.

---

## Part 7 | Java 8 CompletableFuture | Future and Callable in Java

---

### 1. Introduction to Asynchronous Programming in Java

In Java, when a task takes a long time (e.g., I/O operations, API calls), executing it **synchronously** (blocking the main thread) can degrade performance.

To solve this, Java provides:
✔ **Future and Callable** (Java 5) – Basic async tasks.
✔ **CompletableFuture** (Java 8) – Advanced async programming.

---

### 2. Future and Callable (Java 5)

Java introduced **Callable** and **Future** in Java 5 to execute tasks asynchronously and get results.

#### 2.1 Callable Interface

* `Callable<V>` is like `Runnable`, but **returns a result** and **can throw checked exceptions**.
* Used with `ExecutorService.submit()`, which returns a `Future<V>` object.

```java
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            System.out.println("Task started by " + Thread.currentThread().getName());
            Thread.sleep(2000); // Simulate delay
            return 42;
        };

        Future<Integer> future = executor.submit(task); // Submit callable task

        System.out.println("Doing other work while waiting...");
        Integer result = future.get(); // Blocks until result is available
        System.out.println("Result: " + result);

        executor.shutdown();
    }
}
```

**Output**

```
Doing other work while waiting...
Task started by pool-1-thread-1
Result: 42
```

🔹 **Limitations of Future**
❌ **Blocking** (`future.get()` blocks execution).
❌ No **chaining** (hard to combine multiple tasks).
❌ Cannot **manually complete** a `Future`.

---

### 3. CompletableFuture (Java 8)

Java 8 introduced `CompletableFuture` to **overcome Future's limitations** by providing:
✔ **Non-blocking programming** (`thenApply`, `thenAccept`).
✔ **Chaining multiple tasks** (`thenCompose`, `thenCombine`).
✔ **Combining multiple futures** (`allOf`, `anyOf`).

#### 3.1 Creating a CompletableFuture

```java
import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task started by " + Thread.currentThread().getName());
            try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
            return 42;
        });

        System.out.println("Doing other work...");
        Integer result = future.get(); // Blocking
        System.out.println("Result: " + result);
    }
}
```

**Output**

```
Doing other work...
Task started by ForkJoinPool.commonPool-worker-1
Result: 42
```

🔹 **Key Features:**

* `supplyAsync()` → Runs task asynchronously and returns a `CompletableFuture<V>`.
* Uses **ForkJoinPool** (default pool) but can be customized.

---

### 4. Chaining Async Calls (`thenApply`, `thenAccept`)

Instead of blocking, use **chaining**.

```java
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
        .thenApply(num -> num * 2) // Transforms result (10 → 20)
        .thenApply(num -> num + 5); // 20 → 25

System.out.println("Result: " + future.get()); // 25
```

🔹 **Methods:**
✔ `thenApply(fn)` → Transforms result.
✔ `thenAccept(consumer)` → Consumes result without returning anything.

---

### 5. Combining Multiple Futures

#### 5.1 `thenCompose()` (Dependent Async Calls)

When one async task **depends** on another.

```java
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
        .thenCompose(num -> CompletableFuture.supplyAsync(() -> num * 2));

System.out.println("Result: " + future.get()); // 20
```

✔ **Use when the second task depends on the first one.**

---

#### 5.2 `thenCombine()` (Independent Async Calls)

When two independent tasks **need to be combined**.

```java
CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

CompletableFuture<Integer> result = future1.thenCombine(future2, Integer::sum);

System.out.println("Result: " + result.get()); // 30
```

✔ **Use when both tasks run independently but need a combined result.**

---

### 6. Running Multiple Futures in Parallel

#### 6.1 `allOf()` (Wait for All Futures)

```java
CompletableFuture<Void> allFutures = CompletableFuture.allOf(
    CompletableFuture.runAsync(() -> System.out.println("Task 1")),
    CompletableFuture.runAsync(() -> System.out.println("Task 2"))
);

allFutures.get(); // Blocks until all tasks finish
```

✔ Used when all futures **must complete before proceeding**.

---

#### 6.2 `anyOf()` (Wait for First Completed Future)

```java
CompletableFuture<Object> firstDone = CompletableFuture.anyOf(
    CompletableFuture.supplyAsync(() -> "Task A"),
    CompletableFuture.supplyAsync(() -> "Task B")
);

System.out.println("First completed: " + firstDone.get());
```

✔ Returns **result of the first completed future**.

---

### 7. Exception Handling in CompletableFuture

Use `exceptionally()` or `handle()` to catch exceptions.

```java
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
    if (true) throw new RuntimeException("Error occurred!");
    return 10;
}).exceptionally(ex -> {
    System.out.println("Exception: " + ex.getMessage());
    return 0;
});

System.out.println("Result: " + future.get()); // 0
```

✔ `exceptionally()` → Handles exceptions and **provides a fallback value**.

---

### 8. Custom Thread Pool in CompletableFuture

By default, `CompletableFuture` uses **ForkJoinPool**.
To use a **custom thread pool**, provide an `ExecutorService`.

```java
ExecutorService executor = Executors.newFixedThreadPool(3);

CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
    System.out.println("Running in: " + Thread.currentThread().getName());
    return 42;
}, executor);

System.out.println("Result: " + future.get());
executor.shutdown();
```

✔ Ensures **better control over threading**.

---

### 9. Summary

| Feature            | Future & Callable      | CompletableFuture                          |
| ------------------ | ---------------------- | ------------------------------------------ |
| Async Execution    | ✅ Yes                  | ✅ Yes                                      |
| Blocking           | ❌ Yes (`future.get()`) | ✅ Non-blocking (`thenApply`, `thenAccept`) |
| Task Chaining      | ❌ No                   | ✅ Yes (`thenCompose`, `thenCombine`)       |
| Multiple Futures   | ❌ No                   | ✅ Yes (`allOf`, `anyOf`)                   |
| Exception Handling | ❌ No                   | ✅ Yes (`exceptionally`, `handle`)          |

✅ **Use `Future` for basic async tasks.**
✅ **Use `CompletableFuture` for advanced, non-blocking programming.**

---

## Java Thread Pools and ForkJoinPool

### 1. Introduction to Thread Pools

Thread pools are used to efficiently manage and reuse a fixed number of worker threads instead of creating and destroying threads manually.

#### Why Use Thread Pools?

✔ **Improves performance** by reusing threads.
✔ **Reduces resource consumption** by avoiding frequent thread creation/destruction.
✔ **Prevents system overload** by limiting the number of concurrent threads.
✔ **Efficient task scheduling** and management.

---

### 2. Types of Thread Pools in Java (`ExecutorService`)

Java provides various thread pools using `Executors` class:

#### 2.1 FixedThreadPool

* **Fixed number of threads** (best for predictable workloads).
* **If all threads are busy, tasks wait in a queue** until a thread is available.

**Example**

```java
import java.util.concurrent.*;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // 3 threads

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown(); // Shutdown the executor
    }
}
```

🔹 **Use Case:** Best for CPU-bound tasks (fixed worker threads).

---

#### 2.2 CachedThreadPool

* **Creates new threads as needed but reuses old ones**.
* **Unused threads are terminated after 60 seconds**.
* **Best for short-lived tasks with varying workloads**.

**Example**

```java
ExecutorService executor = Executors.newCachedThreadPool();

for (int i = 1; i <= 5; i++) {
    final int taskId = i;
    executor.submit(() -> System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName()));
}

executor.shutdown();
```

🔹 **Use Case:** Best for **I/O-bound tasks** where task execution time varies.

---

#### 2.3 SingleThreadExecutor

* **Only one thread** to execute tasks sequentially.
* **Ensures task execution order is maintained**.

**Example**

```java
ExecutorService executor = Executors.newSingleThreadExecutor();

for (int i = 1; i <= 5; i++) {
    final int taskId = i;
    executor.submit(() -> System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName()));
}

executor.shutdown();
```

🔹 **Use Case:** Best for tasks that must be executed sequentially (e.g., logging, database writes).

---

#### 2.4 ScheduledThreadPool

* **Executes tasks after a delay or at fixed intervals**.
* **Best for scheduling periodic tasks (like Cron jobs)**.

**Example**

```java
ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

executor.schedule(() -> System.out.println("Task executed after 3 seconds"), 3, TimeUnit.SECONDS);

executor.shutdown();
```

🔹 **Use Case:** Best for **periodic and delayed tasks** (e.g., sending reminders, polling services).

---

### 3. ForkJoinPool (Work-Stealing Pool)

Java 7 introduced **ForkJoinPool** to efficiently execute **divide-and-conquer** tasks using **work-stealing**.

#### 3.1 How ForkJoinPool Works?

✔ Uses **multiple worker threads (parallelism)**.
✔ **Divides large tasks into smaller sub-tasks**.
✔ **Idle threads "steal" uncompleted tasks** from busy threads.

---

#### 3.2 ForkJoin Example

**Example: Sum of an Array using ForkJoinPool**

```java
import java.util.concurrent.*;

class SumTask extends RecursiveTask<Integer> {
    private final int[] array;
    private final int start, end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 2) { // Base case
            int sum = 0;
            for (int i = start; i < end; i++) sum += array[i];
            return sum;
        }

        int mid = (start + end) / 2;
        SumTask leftTask = new SumTask(array, start, mid);
        SumTask rightTask = new SumTask(array, mid, end);

        leftTask.fork(); // Execute left task asynchronously
        int rightResult = rightTask.compute(); // Compute right task synchronously
        int leftResult = leftTask.join(); // Wait for left task result

        return leftResult + rightResult;
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};

        SumTask task = new SumTask(array, 0, array.length);
        int result = pool.invoke(task);

        System.out.println("Total Sum: " + result);
    }
}
```

🔹 **Output:**

```
Total Sum: 36
```

✔ ForkJoinPool automatically **distributes work across available processors**.
✔ Uses **RecursiveTask** for returning results and **RecursiveAction** for void tasks.

---

### 4. WorkStealingPool

* Java 8 introduced `Executors.newWorkStealingPool()`, which internally uses **ForkJoinPool**.
* **Efficiently balances work** among threads by **stealing** unfinished tasks.
* Uses **parallelism based on available CPU cores**.

**Example**

```java
ExecutorService executor = Executors.newWorkStealingPool();

for (int i = 1; i <= 5; i++) {
    final int taskId = i;
    executor.submit(() -> System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName()));
}

executor.shutdown();
```

🔹 **Use Case:** Best for **parallel processing of independent tasks**.

---

### 5. Comparing Thread Pools

| Pool Type                | Thread Management                | Best For                     |
| ------------------------ | -------------------------------- | ---------------------------- |
| **FixedThreadPool**      | Fixed-size threads               | CPU-bound tasks              |
| **CachedThreadPool**     | Creates new threads as needed    | I/O-bound tasks              |
| **SingleThreadExecutor** | One thread, sequential execution | Tasks that must run in order |
| **ScheduledThreadPool**  | Scheduled execution of tasks     | Timers, cron jobs            |
| **ForkJoinPool**         | Work-stealing, divides tasks     | Parallel processing          |
| **WorkStealingPool**     | Work-stealing using ForkJoinPool | Large task distribution      |

---

### 6. Conclusion

✅ **Use `FixedThreadPool` for predictable workloads**.
✅ **Use `CachedThreadPool` for unpredictable workloads**.
✅ **Use `SingleThreadExecutor` for sequential execution**.
✅ **Use `ScheduledThreadPool` for periodic tasks**.
✅ **Use `ForkJoinPool` for parallel processing**.
✅ **Use `WorkStealingPool` for dynamic task distribution**.

---

## Java ScheduledThreadPoolExecutor and Thread Termination

### 1. Introduction to ScheduledThreadPoolExecutor

`ScheduledThreadPoolExecutor` is a specialized thread pool that allows scheduling tasks **at a fixed rate, after a delay, or periodically**.

🔹 **Main Features:**
✔ Executes **one-time** tasks after a delay.
✔ Executes **periodic** tasks at **fixed rate** or **fixed delay**.
✔ Supports **graceful shutdown** with `shutdown()` and `awaitTermination()`.

---

### 2. Creating a ScheduledThreadPoolExecutor

Use **`Executors.newScheduledThreadPool()`** to create a pool with a fixed number of threads.

```java
import java.util.concurrent.*;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        Runnable task = () -> System.out.println("Executing task at " + System.currentTimeMillis());

        // Schedule task to run after 3 seconds
        scheduler.schedule(task, 3, TimeUnit.SECONDS);

        scheduler.shutdown();
    }
}
```

🔹 **Output:**

```
Executing task at 1710349423000 (timestamp)
```

---

### 3. Scheduling Periodic Tasks

#### 3.1 scheduleAtFixedRate()

Executes a task **at a fixed rate** (start time is constant).

```java
scheduler.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);
```

🔹 **Behavior:**

* Executes every **3 seconds** after initial **1-second delay**.
* If a task takes longer than the interval, **next execution starts immediately**.

---

#### 3.2 scheduleWithFixedDelay()

Executes a task **after a fixed delay** between the **end of one execution and the start of the next**.

```java
scheduler.scheduleWithFixedDelay(task, 1, 3, TimeUnit.SECONDS);
```

🔹 **Behavior:**

* Executes every **3 seconds after previous task completes**.
* If a task takes longer, **next execution is delayed accordingly**.

---

### 4. Shutting Down Thread Pools

#### 4.1 shutdown()

* **Stops accepting new tasks** but allows **running tasks to finish**.
* Already scheduled tasks **continue executing**.
* New task submissions throw **RejectedExecutionException**.

```java
scheduler.shutdown();
```

---

#### 4.2 shutdownNow()

* **Attempts to stop all running tasks immediately**.
* **Returns a list of unexecuted tasks**.
* **Interrupts worker threads** but does not guarantee instant termination.

```java
List<Runnable> unexecutedTasks = scheduler.shutdownNow();
System.out.println("Unexecuted tasks: " + unexecutedTasks.size());
```

---

#### 4.3 awaitTermination()

* **Waits for all tasks to finish execution** before shutting down.
* If tasks don't finish within the specified time, it **forcefully terminates the executor**.

```java
scheduler.shutdown();

try {
    if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
        scheduler.shutdownNow(); // Force shutdown
    }
} catch (InterruptedException e) {
    scheduler.shutdownNow();
}
```

---

### 5. shutdown() vs shutdownNow() vs awaitTermination()

| Method                 | What it does?                                 | Can tasks complete?                | Accepts new tasks? |
| ---------------------- | --------------------------------------------- | ---------------------------------- | ------------------ |
| **shutdown()**         | Initiates shutdown, running tasks continue    | ✅ Yes                              | ❌ No               |
| **shutdownNow()**      | Attempts immediate shutdown, interrupts tasks | ❌ No (may interrupt running tasks) | ❌ No               |
| **awaitTermination()** | Waits for termination before proceeding       | ✅ Yes (if tasks complete in time)  | ❌ No               |

---

### 6. Complete Example

```java
import java.util.concurrent.*;

public class ScheduledThreadPoolExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        Runnable task = () -> System.out.println("Task executed at " + System.currentTimeMillis());

        // Schedule task at fixed rate
        scheduler.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        // Wait 10 seconds before shutting down
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown();

        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduler.shutdownNow(); // Force shutdown
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
        }
    }
}
```

🔹 **Key Takeaways:**
✅ **Use `scheduleAtFixedRate()` for precise scheduling.**
✅ **Use `scheduleWithFixedDelay()` for flexible delays.**
✅ **Use `shutdown()` for graceful shutdown.**
✅ **Use `shutdownNow()` to cancel tasks immediately.**
✅ **Use `awaitTermination()` to wait for completion.**

---

## Java Virtual Threads vs Normal Threads | ThreadLocal in Java

### 1. Introduction to Java Virtual Threads (JDK 19/21)

Java **Virtual Threads** (introduced in Java 19 as a preview and finalized in Java 21) provide lightweight, high-performance concurrency by decoupling **threads from OS threads**.

🔹 **Why Virtual Threads?**
✔ **Reduce memory footprint** (Lower cost per thread).
✔ **Better scalability** (Can create millions of threads).
✔ **Ideal for I/O-bound tasks** (e.g., network calls, database queries).

---

### 2. Normal Threads vs Virtual Threads

#### 2.1 Normal Threads (Platform Threads)

✔ **Each Java thread maps to an OS thread** (heavy).
✔ **Context switching is expensive**.
✔ **Good for CPU-bound tasks** but **poor for high-concurrency I/O-bound workloads**.

**Example: Normal Thread Creation**

```java
public class NormalThreadExample {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Executed by " + Thread.currentThread());

        Thread thread = new Thread(task);
        thread.start();
    }
}
```

🔹 **Issues with Normal Threads:**

* Limited number of OS threads.
* **Blocking I/O** leads to **thread starvation**.
* **Context switching is expensive**.

---

#### 2.2 Virtual Threads (Java 21)

✔ **Thousands or millions of Virtual Threads can run on few OS threads**.
✔ **No expensive context switching**.
✔ **Best for I/O-bound applications** (e.g., web servers, microservices).

**Example: Creating Virtual Threads**

```java
public class VirtualThreadExample {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Executed by " + Thread.currentThread());

        Thread.startVirtualThread(task); // Virtual Thread creation
    }
}
```

✔ Runs **millions of threads without system overhead**.

---

#### 2.3 Benchmark: Creating 100,000 Threads

**Using Normal Threads**

```java
public class NormalThreadBenchmark {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {}).start();
        }
    }
}
```

🔹 **Issues:**
❌ **High CPU & Memory usage**.
❌ **May crash due to OS thread limits**.

---

**Using Virtual Threads**

```java
public class VirtualThreadBenchmark {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            Thread.startVirtualThread(() -> {});
        }
    }
}
```

✅ **Runs efficiently with minimal memory usage**.

---

### 3. Virtual Threads in ExecutorService

Java 21 introduced **`Executors.newVirtualThreadPerTaskExecutor()`**, which creates an ExecutorService using **virtual threads**.

```java
ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

for (int i = 0; i < 10000; i++) {
    executor.submit(() -> {
        System.out.println(Thread.currentThread());
    });
}

executor.shutdown();
```

✔ **Perfect for web servers and database calls**.

---

### 4. When to Use Normal vs Virtual Threads?

| Feature                | Normal Threads  | Virtual Threads                    |
| ---------------------- | --------------- | ---------------------------------- |
| **Best for**           | CPU-bound tasks | I/O-bound tasks                    |
| **Thread per request** | ❌ Not scalable  | ✅ Highly scalable                  |
| **Memory footprint**   | High            | Low                                |
| **Context Switching**  | Expensive       | Cheap                              |
| **Parallelism**        | Uses OS threads | Uses lightweight user-mode threads |

🚀 **Use Virtual Threads for web servers, API calls, microservices, and database queries.**

---

### 5. ThreadLocal in Java

`ThreadLocal` is a mechanism that **stores variables per thread**, ensuring **thread safety** without synchronization.

#### 5.1 ThreadLocal Example

```java
public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            threadLocal.set((int) (Math.random() * 100));
            System.out.println(Thread.currentThread().getName() + " -> " + threadLocal.get());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
```

🔹 **Each thread gets its own independent variable.**

---

#### 5.2 ThreadLocal vs Virtual Threads

`ThreadLocal` **stores variables per thread**, but **Virtual Threads don't retain thread affinity**.

* **Using ThreadLocal in Virtual Threads is discouraged** since virtual threads are reused.

🚀 **Use `ScopedValues` (Java 21) instead of ThreadLocal in Virtual Threads!**

---

### 6. Summary

| Feature                 | Normal Threads  | Virtual Threads         |
| ----------------------- | --------------- | ----------------------- |
| **Use Cases**           | CPU-bound tasks | I/O-bound tasks         |
| **Scalability**         | Limited         | Millions of threads     |
| **Memory Overhead**     | High            | Low                     |
| **ThreadLocal Support** | ✅ Yes           | ❌ No (Use ScopedValues) |

🚀 **Use Virtual Threads for web servers, database calls, and async processing!**
🔥 **Use ThreadLocal only in traditional threads, not Virtual Threads.**

---

## Lombok Features in Java

Lombok is a Java library that reduces boilerplate code by generating commonly used methods like getters, setters, constructors, etc., during compilation.

---

### 1. `val` and `var`

* `val`: Immutable local variable (like `final`)
* `var`: Mutable local variable
* Type is inferred by the compiler.

```java
val name = "John";  // becomes final String name = "John";
var count = 10;     // becomes int count = 10;
```

✅ Helps reduce verbosity when declaring variables.

---

### 2. `@NonNull`

* Automatically adds null checks in constructors or methods.
* Throws `NullPointerException` if the value is null.

```java
public class Person {
    public Person(@NonNull String name) {
        this.name = name;
    }
}
```

✅ Avoids writing manual null checks.

---

### 3. `@Getter` and `@Setter`

* Automatically generates getter and setter methods.

```java
@Getter
@Setter
private String name;
```

* You can annotate at **class level** (for all fields) or **field level**.

✅ Reduces boilerplate method generation.

---

### 4. `@ToString`

* Generates a readable `toString()` method.
* Can exclude fields: `@ToString(exclude = "password")`

```java
@ToString
public class User {
    private String name;
    private String email;
}
```

---

### 5. `@NoArgsConstructor`, `@AllArgsConstructor`, `@RequiredArgsConstructor`

* `@NoArgsConstructor`: No-arg constructor.
* `@AllArgsConstructor`: Constructor with all fields.
* `@RequiredArgsConstructor`: Only `final` or `@NonNull` fields.

```java
@RequiredArgsConstructor
public class Student {
    private final String name;
    private int age;
}
```

---

### 6. `@EqualsAndHashCode`

* Generates `equals()` and `hashCode()` based on fields.
* Can exclude fields too.

```java
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
}
```

---

### 7. `@Data`

* Combines:
  * `@ToString`
  * `@EqualsAndHashCode`
  * `@Getter`/`@Setter`
  * `@RequiredArgsConstructor`

```java
@Data
public class Product {
    private final String id;
    private String name;
}
```

✅ Ideal for POJOs.

---

### 8. `@Value`

* Immutable version of `@Data`.
* All fields are `private` and `final`.
* No setters generated.

```java
@Value
public class Config {
    String host;
    int port;
}
```

---

### 9. `@Builder`

* Enables fluent API for object creation.
* Useful for creating immutable or complex objects.

```java
@Builder
public class Order {
    private String item;
    private int quantity;
}
```

```java
Order order = Order.builder().item("Book").quantity(2).build();
```

---

### 10. `@Cleanup`

* Automatically closes resources like streams, readers, etc.

```java
@Cleanup InputStream in = new FileInputStream("file.txt");
```

✅ Ensures `close()` is called, even in case of exceptions.

---

## Java 17: Sealed Classes and Interfaces

---

### Key Concept

* **Problem before Sealed Classes**:
  * No control over inheritance hierarchy.
  * Any class could implement an interface or extend a class.
  * Leads to unpredictable subclasses, forcing developers to add `default` cases in `switch` or `if-else` handling.
  * Silent code breaks could occur if a new subclass was introduced unintentionally.

* **Solution**: **Sealed Classes & Interfaces (Java 17)**
  * Introduce `sealed` keyword + `permits` clause.
  * Restricts which classes or interfaces can directly extend/implement a type.
  * Provides controlled inheritance.

---

### How It Works

**Syntax Example**:

```java
public sealed interface Shape permits Circle, Rectangle {}
```

* `Shape` can only be implemented by `Circle` and `Rectangle`.
* Any other class (e.g., `Triangle`) is **not allowed**.

---

### Rules for Subclasses

Every permitted subclass must declare **one of three modifiers**:

1. **final** → No further subclassing allowed.
   ```java
   final class Circle implements Shape {}
   ```

2. **sealed** → Can be subclassed, but only by explicitly permitted types.
   ```java
   sealed class AbstractShape implements Shape permits Rectangle, Triangle {}
   ```

3. **non-sealed** → Open for extension by any number of subclasses.
   ```java
   non-sealed interface Polygon extends Shape {}
   ```

---

### Important Conditions

* **Permitted types must be direct subclasses** of the sealed type.
* **Permitted subclasses must declare themselves as final, sealed, or non-sealed**.
* **All permitted subclasses must exist at compile time** (future hypothetical classes not allowed).

---

### Example Hierarchy

```java
// Sealed Interface
public sealed interface Shape permits Circle, Polygon, AbstractShape {}

// Circle - No further subclass
public final class Circle implements Shape {}

// Polygon - Open branch
public non-sealed interface Polygon extends Shape {}

// AbstractShape - Restricted to Rectangle & Triangle
public sealed abstract class AbstractShape implements Shape permits Rectangle, Triangle {}

// Rectangle - Closed branch
public final class Rectangle extends AbstractShape {}

// Triangle - Open branch
public non-sealed class Triangle extends AbstractShape {}
```

---

### Benefits

* Enforces **controlled inheritance**.
* Reduces **unexpected child classes**.
* Improves **readability and maintainability** of code.
* Compiler can perform **exhaustive checks** in `switch` expressions (no need for unnecessary `default`).
