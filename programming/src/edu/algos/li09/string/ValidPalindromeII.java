package edu.algos.li09.string;

public class ValidPalindromeII {

	public static void main(String[] args) {
		ValidPalindromeII obj = new ValidPalindromeII();
		
		String s = "abca";
		System.out.println(obj.validPalindrome(s));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/valid-palindrome-ii/
	 * 
	 * */
	public boolean validPalindrome(String s) {
        int l=0, r=s.length()-1;
        while(l<r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return isValidPolindrome(s.substring(l+1, r+1)) || isValidPolindrome(s.substring(l, r));
            }
        }
        return true;
    }
    
    private boolean isValidPolindrome(String s){
        int l=0, r=s.length()-1;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}
