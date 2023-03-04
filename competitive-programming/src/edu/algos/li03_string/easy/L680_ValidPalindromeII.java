package edu.algos.li03_string.easy;

public class L680_ValidPalindromeII {

	public static void main(String[] args) {
		L680_ValidPalindromeII obj = new L680_ValidPalindromeII();
		
		String s = "abca";
		System.out.println(obj.validPalindrome(s));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/valid-palindrome-ii/
	 * Idea: Check polindrome from both sides. Once miss match happens, prepare 2 strings ignoring left and right chars and check if they are polindromes.
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
