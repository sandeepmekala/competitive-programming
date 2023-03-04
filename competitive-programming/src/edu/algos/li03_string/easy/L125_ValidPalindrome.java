package edu.algos.li03_string.easy;

public class L125_ValidPalindrome {

	public static void main(String[] args) {
		L125_ValidPalindrome obj = new L125_ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		//String s = "race a car";
		//String s = "0P";
		System.out.println(obj.isPalindrome(s));
	}
	
    // Problem: https://leetcode.com/problems/valid-palindrome/
    // Idea: Convert string to lowercase. Move front and back ptrs. Skip non-alphanumeric.
	public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        s = s.toLowerCase();
        while(i<j){
            if(!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') &&
              !(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                i++;
                continue;
            }else if(!(s.charAt(j) >= 'a' && s.charAt(j) <= 'z') &&
                    !(s.charAt(j) >= '0' && s.charAt(j) <= '9')){
                j--;
                continue;
            }else{
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
                i++; j--;
            }
        }
        return true;
    }
}
