package  com.algos.li04_slidingwindow;

import java.util.HashSet;
import java.util.Set;

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
		Set<Character> list = new HashSet<Character>();
		int max = 0;
        
		for(int i=0,j=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			//update j
			while(list.contains(ch)) {
				list.remove(ch);
				ch = s.charAt(j++);
			}
			list.add(ch);

			int length = i-j+1;
			if(length > max) {
				max = length;
			}
		}

		return max;
	}
}
