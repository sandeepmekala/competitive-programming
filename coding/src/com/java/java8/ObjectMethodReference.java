package com.java.java8;

import java.util.function.BiFunction;

interface Sayable2 {
    void say();
}

class Arithmetic {
	public int add(int a, int b) {
		return a + b;
	}
}

class Something {
    public String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

public class ObjectMethodReference {
    public void saySomething() {
        System.out.println("Hello, this is non-static method.");
    }

    public static void main(String[] args) {
        ObjectMethodReference methodReference = new ObjectMethodReference(); // Creating object
        
        Sayable2 sayable = methodReference::saySomething;
        sayable.say();
        
        Sayable2 sayable2 = new ObjectMethodReference()::saySomething; // You can use anonymous object also
        sayable2.say();

        Thread t2 = new Thread(new ObjectMethodReference()::saySomething); // Runnable run method will reference to saySomething
		t2.start();

        // Standard functional interfaces
        BiFunction<Integer, Integer, Integer> adder = new Arithmetic()::add;
		int result = adder.apply(10, 20);
		System.out.println(result);
    }
}