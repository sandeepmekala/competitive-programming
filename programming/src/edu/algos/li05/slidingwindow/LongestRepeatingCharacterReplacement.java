package edu.algos.li05.slidingwindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
		
		String s = "AABABBA";
		System.out.println(obj.characterReplacement(s, 1));
	}

	public int characterReplacement(String s, int k) {
		int maxLen = 0;
		int i=0, j=0, n=s.length();
		
		HashMap<Character, Integer> map = new HashMap<>();
		while(i<n) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
			int len = i-j+1, max = getMax(map);	//window length
			if(len-max <= k) {
				maxLen = Math.max(maxLen, len);
				i++;
			}else {
				while(len-max > k) {
					map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)-1);
					j++;
					
					len = i-j+1;
					max = getMax(map);
				}
				i++;
			}
			
		}
		
		return maxLen;

	}
	private int getMax(HashMap<Character, Integer> map) {
		int max = 0;
		for(int num: map.values()) {
			max = Math.max(max, num);
		}
		return max;
	}

}
