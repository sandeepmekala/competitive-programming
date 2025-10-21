package  com.algos.topics.li02_hashing;

import java.util.HashSet;
import java.util.Set;

public class L409_LongestPalindrome {

	public static void main(String[] args) {
		L409_LongestPalindrome obj = new L409_LongestPalindrome();

		System.out.println(obj.longestPalindrome("aabbbccccddd"));
	}

	/*
	 * Problem: https://leetcode.com/problems/longest-palindrome/
     * Idea: Count all chars with even num of occurance
	 * */
	public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();

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
