package com.java.generics;

public class GenericsExample {
    public static void main(String[] args) {

        // Example 1: Generics Basic
        // Use to generalize the functionality to different types of classes.
        Printer<Integer> p = new Printer<>(10);
        p.print();
        
        Printer<String> p1 = new Printer<>("Hello");
        p1.print();
    }
}

class Printer<T>{
    T val;
    
    Printer(T val){
        this.val = val;
    }

    public void print(){
        System.out.println(this.val);
    }
}