package com.java.equalsandhashcode;

public class StringConstantsEquals {
        
    public static void main(String[] args) {
        String s1 = "A";
        String s2 = "A";
        
        // This will return true because both s1 and s2 are pointing to the same memory location.
        // Java stores the string literals in a string pool. If we create a string object using string literal, it will refer to the same object in the string pool.
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
