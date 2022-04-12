package edu.algos.strings;

import java.util.ArrayList;
import java.util.List;

public class LongestNonRepeatingCharacters {

	public static void main(String[] args) {
		String input = "aabcbe";
		System.out.println(maxSubstringLenthOfNonRepeatingChars(input));
	}
	
	// use 2 pointers 
	// once you find a repeating char on the right side remove all the old chars from list until the repeating item
	private static int maxSubstringLenthOfNonRepeatingChars(String input) {
		List<Character> list = new ArrayList<Character>();
		int maxLength = 0;
		for(int j=0,i=0; i<input.length(); i++) {
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
		return maxLength;
	}
}
