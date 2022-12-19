package edu.algos.li23_math;

public class PalindromeNumber {

	public static void main(String[] args) {
		PalindromeNumber obj = new PalindromeNumber();
		
		System.out.println(obj.isPalindrome(121));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/palindrome-number/
	 * */
	public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        int num=x, rev = 0;
        while(x > 0){
            rev = rev*10;
            rev += x%10;
            x = x/10;
        }
        
        return num == rev;
    }

}
