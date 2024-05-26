package com.algos.core.li19_bit.revised;

public class L29_DivideTwoIntegers {
    public static void main(String[] args) {
        L29_DivideTwoIntegers obj = new L29_DivideTwoIntegers();

        System.out.println(obj.divide(22, 3));
        System.out.println(obj.divide(7, -3));
    }


    // Problem: https://leetcode.com/problems/divide-two-integers/
    // Idea: Instead of subtracting divisor from dividend one at a time, subtract divisor in multiple of 2^n.
    // This will reduce the time complexity to log(n) from n.
    // For f(22, 3) => 3*7 = 21, 3*(2^2+2^1+2^0)
    // Time: O(log(n)^2), Space: O(1) 
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; //Cornor case when -2^31 is divided by -1

        boolean negative = dividend < 0 ^ divisor < 0;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0;
        while(dividend - divisor >= 0){
            int cnt = 0;
            while(dividend - (divisor << cnt << 1) >= 0)
                cnt++;
            quotient += 1<<cnt;
            dividend -= divisor << cnt;
        }
      
        return negative ? -quotient : quotient;
    }
}
