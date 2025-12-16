package com.java.functional;

interface Sayable {
    void say();
}

// it can have object class methods as abstract methods. This won't violate it
// property.
@FunctionalInterface
interface StaticConverter<F, T> {
    T convert(F from);

    int hashCode();
}

public class StaticMethodReference {
    public static void saySomething() {
        System.out.println("Hello, this is static method.");
    }

    public static void main(String[] args) {
        Sayable sayable = StaticMethodReference::saySomething;
        sayable.say();

        StaticConverter<String, Integer> converter2 = Integer::parseInt;
        Integer integer2 = converter2.convert("123");
        System.out.println(integer2);
    }
}
