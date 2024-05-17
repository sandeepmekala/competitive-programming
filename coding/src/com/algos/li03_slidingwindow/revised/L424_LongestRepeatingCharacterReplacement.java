package  com.algos.li03_slidingwindow.revised;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class L424_LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		L424_LongestRepeatingCharacterReplacement obj = new L424_LongestRepeatingCharacterReplacement();
		
		String s = "AABABBA";
		System.out.println(obj.characterReplacement(s, 1));
	}

	// Problem: https://leetcode.com/problems/longest-repeating-character-replacement/
	// Idea: In a substring we will try to replace all characters except the max frequency character
	public int characterReplacement(String s, int k) {
		int[] map = new int[26];
		int l=0, r=0, maxLen = 0, maxFreq=0, n = s.length();
		while(r<n) {
			map[s.charAt(r) - 'A']++;
			maxFreq = Math.max(maxFreq, map[s.charAt(r) - 'A']);	//window length
			int len = r-l+1;
			if(len-maxFreq > k) {
				map[s.charAt(l) - 'A']--;
				l++;
			}

			len = r-l+1;
			if(len-maxFreq <= k) 
				maxLen = Math.max(maxLen, len);
			
			r++;
		}
		
		return maxLen;
	}
}
