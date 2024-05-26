package com.algos.core.li03_slidingwindow.revised;

public class L3_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		L3_LongestSubstringWithoutRepeatingCharacters obj = new L3_LongestSubstringWithoutRepeatingCharacters();
		String input = "aabcbe";
		System.out.println(obj.lengthOfLongestSubstring(input));
	}
	
	// Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
	// Idea: Use 2 pointers. Once you find a repeating char on the right side, remove all the old chars from list until the repeating item.
	// Incase you don't want to remove j ptr char's one by one. You can store the index i with each repeating char in map so that, j can be jumped to that.
	public int lengthOfLongestSubstring(String s) {
		int[] set = new int[256];

		int l=0, r=0, maxLen = 0, n = s.length();
		while(r<n) {
			char ch = s.charAt(r);
			//update l pointer until the char is not in set
			while(set[ch] != 0) {
				set[ch] = 0;
				ch = s.charAt(l);
				l++;
			}
			set[ch] = 1;

			maxLen = Math.max(maxLen, r-l+1);
			r++;
		}

		return maxLen;
	}
}
