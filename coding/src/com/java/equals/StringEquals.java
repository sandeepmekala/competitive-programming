package com.java.equals;

public class StringEquals {
        
    public static void main(String[] args) {
        String s1 = new String("A");
        String s2 = new String("A");
        
        // s1 and s2 represent memory locations. Hence, == operator will return false.
        if(s1 == s2)                   
            System.out.println("Equal");
        else
            System.out.println("Not Equal");

        // Each Wrapper class has overridden equals method to compare the values. Hence, it will return true.  
        // We should always use equals method to compare the values of objects instead of == operator.
        if(s1.equals(s2))              
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }
}
