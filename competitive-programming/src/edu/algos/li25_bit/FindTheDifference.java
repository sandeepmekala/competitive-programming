package edu.algos.li25_bit;

public class FindTheDifference {

	public static void main(String[] args) {
		FindTheDifference obj = new FindTheDifference();
		
		System.out.println(obj.findTheDifference("acd", "aedc"));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/find-the-difference/
	 * Companies: Google
	 * */
	public char findTheDifference(String s, String t) {
        int chr = 0;
        for(char ch: s.toCharArray()){
            chr ^= ch;
        }
        for(char ch: t.toCharArray()){
            chr ^= ch;
        }
        
        return (char)chr;
    }

}
