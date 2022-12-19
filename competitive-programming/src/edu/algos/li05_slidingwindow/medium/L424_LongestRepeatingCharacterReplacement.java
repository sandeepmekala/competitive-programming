package edu.algos.li05_slidingwindow.medium;

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
	// Idea: We have to track the windon len where the replacable char is <=k
	public int characterReplacement(String s, int k) {
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0,j=0; i<s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
			int winLen = i-j+1;
			int winMax = Collections.max(map.values());	//window length
			while(j<i && winLen-winMax > k) {
				map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)-1);
				j++;
				
				winLen = i-j+1;
				winMax = Collections.max(map.values());
			}

			if(winLen-winMax <= k) {
				max = Math.max(max, winLen);
			}

			
		}
		
		return max;
	}
}
