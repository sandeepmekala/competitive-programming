package edu.java.java8;
interface Sayable1{  
    void say();  
}  
public class MethodReference {  
    public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }  
    public static void main(String[] args) {  
        // Referring static method  
        Sayable1 sayable = MethodReference::saySomething;  
        // Calling interface method  
        sayable.say();  
    }  
}  