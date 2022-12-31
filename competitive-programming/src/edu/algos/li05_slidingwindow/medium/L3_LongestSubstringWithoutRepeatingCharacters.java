package edu.algos.li05_slidingwindow.medium;

import java.util.ArrayList;
import java.util.List;

public class L3_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		L3_LongestSubstringWithoutRepeatingCharacters obj = new L3_LongestSubstringWithoutRepeatingCharacters();
		String input = "aabcbe";
		System.out.println(obj.lengthOfLongestSubstring(input));
	}
	
	// Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
	// Idea: Use 2 pointers. 
	// Once you find a repeating char on the right side, remove all the old chars from list until the repeating item.
	// TODO
	public int lengthOfLongestSubstring(String s) {
		List<Character> list = new ArrayList<Character>();
		int maxLength = 0;
        
		for(int i=0,j=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			//update j
			while(j<i && !list.isEmpty() && list.contains(ch)) {
				Character oldCh = s.charAt(j++);
				list.remove(oldCh);
				if(oldCh ==  ch) {
					break;
				}
			}
			list.add(ch);

			int length = i-j+1;
			if(length > maxLength) {
				maxLength = length;
			}
		}

		return maxLength;
	}
}
