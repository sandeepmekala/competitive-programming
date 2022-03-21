package edu.algos.strings;

import java.util.ArrayList;
import java.util.List;

public class LongestNonRepeatingCharacters {

	public static void main(String[] args) {
		String input = "aabcbe";
		System.out.println(maxSubstringLenthOfNonRepeatingChars(input));
	}
	
	// use 2 pointers 
	// once you find a repeating char on the right side remove all the old chars from set until the repeating item
	private static int maxSubstringLenthOfNonRepeatingChars(String input) {
		List<Character> list = new ArrayList<Character>();
		int maxLength = 0;
		for(int i=0,j=0; j<input.length(); j++) {
			char currentChar = input.charAt(j);
			if(!list.contains(currentChar)) {
				list.add(currentChar);
			}else {
				int length = j-i;
				if(length > maxLength) {
					maxLength = length;
				}
				while(i<j && !list.isEmpty()) {
					Character oldChar = list.get(i++);
					list.remove(oldChar);
					if(oldChar ==  currentChar) {
						break;
					}
				}
				list.add(currentChar);
			}
		}
		return maxLength;
	}
}
