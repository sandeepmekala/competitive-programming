package com.java.concurrency.modern;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Modern Java 21 Thread Synchronization Examples
 * Demonstrates various approaches to thread coordination
 */
public class OddEven {

    public static void main(String[] args) {
        var demo = new OddEven();

        System.out.println("=== Traditional Synchronized Approach (Fixed) ===");
        demo.traditionalSynchronizedApproach();

        System.out.println("\n=== Modern ReentrantLock Approach ===");
        demo.modernLockApproach();

        System.out.println("\n=== Semaphore Approach ===");
        demo.semaphoreApproach();

        System.out.println("\n=== CompletableFuture Approach ===");
        demo.completableFutureApproach();

        System.out.println("\n=== Virtual Threads Approach (Java 21) ===");
        demo.virtualThreadsApproach();
    }

    // Fixed traditional approach with proper exception handling
    private void traditionalSynchronizedApproach() {
        var lock = new Object();
        var evenTurn = new boolean[]{true}; // Use array to make it effectively final

        Thread evenThread = new Thread(() -> {
            for (int i = 0; i < 10; i += 2) {
                synchronized (lock) {
                    while (!evenTurn[0]) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.println("Even: " + i);
                    evenTurn[0] = false;
                    lock.notifyAll();
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                synchronized (lock) {
                    while (evenTurn[0]) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.println("Odd: " + i);
                    evenTurn[0] = true;
                    lock.notifyAll();
                }
            }
        });
        oddThread.setName("Odd-Thread");

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Modern ReentrantLock approach
    private void modernLockApproach() {
        var lock = new ReentrantLock();
        Condition evenCondition = lock.newCondition();
        Condition oddCondition = lock.newCondition();
        var evenTurn = new boolean[]{true};

        Thread evenThread = new Thread(() -> {
            for (int i = 0; i < 10; i += 2) {
                lock.lock();
                try {
                    while (!evenTurn[0]) {
                        evenCondition.await();
                    }
                    System.out.println("Even (Lock): " + i);
                    evenTurn[0] = false;
                    oddCondition.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                } finally {
                    lock.unlock();
                }
            }
        });
        evenThread.setName("Even-Lock-Thread");

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                lock.lock();
                try {
                    while (evenTurn[0]) {
                        oddCondition.await();
                    }
                    System.out.println("Odd (Lock): " + i);
                    evenTurn[0] = true;
                    evenCondition.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                } finally {
                    lock.unlock();
                }
            }
        });
        oddThread.setName("Odd-Lock-Thread");

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Semaphore approach
    private void semaphoreApproach() {
        var evenSemaphore = new Semaphore(1);
        var oddSemaphore = new Semaphore(0);

        Thread evenThread = new Thread(() -> {
            for (int i = 0; i < 10; i += 2) {
                try {
                    evenSemaphore.acquire();
                    System.out.println("Even (Semaphore): " + i);
                    oddSemaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
        evenThread.setName("Even-Semaphore-Thread");

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                try {
                    oddSemaphore.acquire();
                    System.out.println("Odd (Semaphore): " + i);
                    evenSemaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
        oddThread.setName("Odd-Semaphore-Thread");

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // CompletableFuture approach
    private void completableFutureApproach() {
        var latch = new CountDownLatch(2);

        CompletableFuture<Void> evenTask = CompletableFuture.runAsync(() -> {
            IntStream.range(0, 10)
                    .filter(i -> i % 2 == 0)
                    .forEach(i -> {
                        System.out.println("Even (CompletableFuture): " + i);
                        try {
                            Thread.sleep(100); // Small delay for demonstration
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    });
            latch.countDown();
        });

        CompletableFuture<Void> oddTask = CompletableFuture.runAsync(() -> {
            IntStream.range(0, 10)
                    .filter(i -> i % 2 != 0)
                    .forEach(i -> {
                        System.out.println("Odd (CompletableFuture): " + i);
                        try {
                            Thread.sleep(100); // Small delay for demonstration
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    });
            latch.countDown();
        });

        try {
            CompletableFuture.allOf(evenTask, oddTask).join();
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Modern ExecutorService approach (Java 21 Virtual Threads simulation)
    private void virtualThreadsApproach() {
        ExecutorService executor = Executors.newCachedThreadPool();
        var latch = new CountDownLatch(2);

        try {
            // Submit even number task
            executor.submit(() -> {
                IntStream.range(0, 10)
                        .filter(i -> i % 2 == 0)
                        .forEach(i -> {
                            System.out.println("Even (Executor): " + i +
                                             " [" + Thread.currentThread().getName() + "]");
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        });
                latch.countDown();
            });

            // Submit odd number task
            executor.submit(() -> {
                IntStream.range(0, 10)
                        .filter(i -> i % 2 != 0)
                        .forEach(i -> {
                            System.out.println("Odd (Executor): " + i +
                                             " [" + Thread.currentThread().getName() + "]");
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        });
                latch.countDown();
            });

            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }
    }
}
