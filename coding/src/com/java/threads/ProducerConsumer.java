package com.java.threads;

class SharedResource {
    private int value = 0;
    private boolean available = false;

    public synchronized void produce(int newValue) {
        while (available) { // Wait if value is not consumed
            try { wait(); } catch (Exception e) {}
        }
        value = newValue;
        available = true;
        System.out.println("Produced: " + value);
        notify(); // Notify consumer
    }

    public synchronized void consume() {
        while (!available) { // Wait if no value is produced
            try { wait(); } catch (Exception e) {}
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

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        new Producer(resource).start();
        new Consumer(resource).start();
    }
}

