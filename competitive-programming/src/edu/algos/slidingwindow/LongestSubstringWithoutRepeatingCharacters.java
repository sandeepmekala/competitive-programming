package edu.algos.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		String input = "aabcbe";
		System.out.println(obj.maxSubstringLenthOfNonRepeatingChars(input));
	}
	
	// use 2 pointers 
	// once you find a repeating char on the right side remove all the old chars from list until the repeating item
	private int maxSubstringLenthOfNonRepeatingChars(String input) {
		List<Character> list = new ArrayList<Character>();
		int maxLength = 0;
        int j=0,i=0;
		for(; i<input.length(); i++) {
			char current = input.charAt(i);
			if(!list.contains(current)) {
				list.add(current);
			}else {
				int length = i-j;
				if(length > maxLength) {
					maxLength = length;
				}
				//update j
				while(j<i && !list.isEmpty()) {
					Character oldChar = input.charAt(j++);
					list.remove(oldChar);
					if(oldChar ==  current) {
						break;
					}
				}
				list.add(current);
			}
		}
        int length = i-j;
        if(length > maxLength) {
            maxLength = length;
        }
		return maxLength;
	}
}
