package com.algos.company.google;


import java.util.*;

public class Math_LargeIntegerSubtraction {

    public static String solve(long a, long b) {
        // Convert the long integers to strings
        String s1 = Long.toString(a);
        String s2 = Long.toString(b);
        
        // Swap strings if a < b
        if (a < b) {    // s1 should be greater than s2
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        
        // Reverse the strings
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        sb1.reverse();
        sb2.reverse();
        
        StringBuilder ans = new StringBuilder();
        // Perform subtraction
        int carry = 0;
        for (int i = 0; i < sb1.length(); i++) {
            int digit1 = sb1.charAt(i) - '0';
            int digit2 = (i < sb2.length()) ? sb2.charAt(i) - '0' : 0;
            int diff = digit1 - digit2 - carry;
            if (diff < 0) {
                diff += 10; // Adjust for borrow
                carry = 1;
            } else {
                carry = 0;
            }
            ans.append(diff);
        }

        // Reverse the result string
        ans.reverse();
        
        // Remove leading zeros
        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        
        if(a < b) 
            ans.insert(0, '-');
        
        return ans.toString();
    }

    public static void main(String[] args) {
        long a = 129347;
        long b = 1398;
        System.out.println(solve(a, b));
        long a2 = 123456789;
        long b2 = 987654321;
        System.out.println(solve(a2, b2));
    }
}
