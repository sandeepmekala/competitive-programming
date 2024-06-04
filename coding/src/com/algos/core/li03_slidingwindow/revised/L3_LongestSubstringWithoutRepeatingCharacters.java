package com.algos.core.li03_slidingwindow.revised;

public class L3_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		L3_LongestSubstringWithoutRepeatingCharacters obj = new L3_LongestSubstringWithoutRepeatingCharacters();
		String input = "aabcbe";
		System.out.println(obj.lengthOfLongestSubstring(input));
	}
	
	// Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
	// Idea: Use 2 pointers. You can store the index i+1 with each repeating char in map so that, j can be jumped to that.
	public int lengthOfLongestSubstring(String s) {
		int[] set = new int[256];

		int l=0, r=0, maxLen = 0, n = s.length();
		while(r<n) {
			char ch = s.charAt(r);
			//update l pointer until the char is not in set
			if(set[ch] != 0) {
				l = Math.max(l, set[ch]);		// abba case
			}
			set[ch] = r+1;						// store the index to which l should jump

			maxLen = Math.max(maxLen, r-l+1);
			r++;
		}

		return maxLen;
	}
}
