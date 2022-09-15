package edu.java.java8.methodReference;

import java.util.function.BiFunction;

interface Sayable {
    void say();
}

class Arithmetic {
	public int add(int a, int b) {
		return a + b;
	}
}

public class InstanceMethodReference {
    public void saySomething() {
        System.out.println("Hello, this is non-static method.");
    }

    public static void main(String[] args) {
        InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object
        
        Sayable sayable = methodReference::saySomething;
        sayable.say();
        
        Sayable sayable2 = new InstanceMethodReference()::saySomething; // You can use anonymous object also
        sayable2.say();

        Thread t2 = new Thread(new InstanceMethodReference()::saySomething); // Runnable run method will reference to saySomething
		t2.start();

        // Standard functional interfaces
        BiFunction<Integer, Integer, Integer> adder = new Arithmetic()::add;
		int result = adder.apply(10, 20);
		System.out.println(result);
    }
}