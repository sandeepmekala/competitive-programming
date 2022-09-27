package edu.algos.li05.slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring obj = new MinimumWindowSubstring();

		String s = "ADOBECODEBANC", t = "ABC";
		System.out.println(obj.minWindow(s, t));
	}

	/*
	 * Problem: return shortest string of s which contains every char of t
	 * Concept: maintain the frequencies of window chars of s. if every char freq in s >= t char freq, it is a match
	 * while matching, update the res len and remove the char from left window and see if len can be minimized
	 * 	
	 * 
	 * */
	
	public String minWindow(String s, String t) {
		if (t.isEmpty()) {
			return "";
		}
		int start = 0, end = Integer.MAX_VALUE;

		HashMap<Character, Integer> tmap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
		}

		int l = 0;
		int len = Integer.MAX_VALUE;
		HashMap<Character, Integer> smap = new HashMap<>();
		for (int r = 0; r < s.length(); r++) {
			char ch = s.charAt(r);
			if(tmap.containsKey(ch)) {
				smap.put(ch, smap.getOrDefault(ch, 0) + 1);
			}

			while (isMatching(tmap, smap)) {		//if evenry ch in smap existing tmap and countS >= countT then matching. update the lentgth and remove char from left to see if len can be minimized
				if (r-l+1 < len) {
					len = (r-l+1);
					start = l;
					end = r;
				}

				ch = s.charAt(l);
				smap.put(ch, smap.getOrDefault(ch, 0) - 1);
				l++;
			}
		}

		if (end == Integer.MAX_VALUE) {
			return "";
		}
		return s.substring(start, end + 1);
	}

	private boolean isMatching(HashMap<Character, Integer> tmap, HashMap<Character, Integer> smap) {
		for(char key: tmap.keySet()) {
			if(smap.get(key) == null || smap.get(key) < tmap.get(key)) {
				return false;
			}
		}
		
		return true;
	}
	
}
