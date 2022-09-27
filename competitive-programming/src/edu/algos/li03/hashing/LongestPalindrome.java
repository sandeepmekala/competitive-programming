package edu.algos.li03.hashing;

import java.util.HashSet;

public class LongestPalindrome {

	public static void main(String[] args) {
		LongestPalindrome obj = new LongestPalindrome();
		
		System.out.println(obj.longestPalindrome("aabbbccccddd"));
	}

	/*
	 * Problem: https://leetcode.com/problems/longest-palindrome/
	 * */
	public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        
        char[] chars = s.toCharArray();
        int count = 0;
        for(char ch: chars){
            if(!set.contains(ch)){
                set.add(ch);
            }else{
                set.remove(ch);
                count++;
            };
        }
        
        return set.isEmpty()? 2*count : 2*count+1;
    }
}
