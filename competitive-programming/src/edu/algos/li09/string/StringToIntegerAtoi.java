package edu.algos.li09.string;

public class StringToIntegerAtoi {

	public static void main(String[] args) {
		StringToIntegerAtoi obj = new StringToIntegerAtoi();
		
		System.out.println(obj.myAtoi("-42"));
	}

	/*
	 * Problem: https://leetcode.com/problems/string-to-integer-atoi/
	 * Companies: Amazon
	 * */
	public int myAtoi(String s) {
        if(s.isEmpty()) return 0;
        
        char[] chars = s.toCharArray();
        int i=0, n=chars.length, num = 0;
        boolean isPositive = true;
        
        while(i<n && chars[i] == ' ') i++;
        
        if(i<n && (chars[i] == '-' || chars[i] == '+')){
            if(chars[i++] == '-') isPositive = false; 
        }

        while(i<n && Character.isDigit(chars[i])){
            int intValue = (chars[i] - '0');
            if(num > Integer.MAX_VALUE/10 || num*10 > Integer.MAX_VALUE-intValue) {
                return isPositive? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }

            num *= 10;
            num += intValue;
            i++;
        }

        return isPositive? num: -num;
        
    }
}
