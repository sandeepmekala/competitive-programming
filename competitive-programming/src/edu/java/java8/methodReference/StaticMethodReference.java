package edu.java.java8.methodReference;

interface Sayable {
    void say();
}

public class StaticMethodReference {
    public static void saySomething() {
        System.out.println("Hello, this is static method.");
    }

    public static void main(String[] args) {
        Sayable sayable = StaticMethodReference::saySomething;
        sayable.say();
    }
}