package com.java.generics;

public class GenericsWithMethod {
    
    public static void main(String[] args) {
        GenericsWithMethod gm = new GenericsWithMethod();
        gm.print(10);
        gm.print("Hello");

        gm.print(10, "Hello");
    }

    // We need to put before return type to make it generic method.
    public <T> void print(T val){
        System.out.println(val);
    }

    // We can have multiple generic types.
    public <T, V> void print(T val, V val2){
        System.out.println(val);
        System.out.println(val2);
    }
}
