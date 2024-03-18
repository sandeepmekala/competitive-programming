package  com.algos.li03_slidingwindow;

import java.util.HashMap;

public class L76_MinimumWindowSubstring {

	public static void main(String[] args) {
		L76_MinimumWindowSubstring obj = new L76_MinimumWindowSubstring();

		String s = "ADOBECODEBANC", t = "ABC";
		System.out.println(obj.minWindow(s, t));
	}

	/*
	 * Problem: https://leetcode.com/problems/minimum-window-substring/
	 * Idea: Maintain the frequencies of window chars of s. If every char freq in s >= t char freq, it is a match
	 * while matching, update the res len and remove the char from left window and see if len can be minimized
	 * 
	 * TODO
	 * */
	
	public String minWindow(String s, String t) {
		if (t.isEmpty()) {
			return "";
		}
		
		HashMap<Character, Integer> tmap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
		}
		
		int l = 0, len = Integer.MAX_VALUE;
		int sRes = 0, eRes = Integer.MAX_VALUE;
		HashMap<Character, Integer> smap = new HashMap<>();
		for (int r = 0; r < s.length(); r++) {
			char ch = s.charAt(r);
			if(tmap.containsKey(ch)) {
				smap.put(ch, smap.getOrDefault(ch, 0) + 1);
			}

			while (isMatching(tmap, smap)) {		// If evenry ch in smap exist tmap and countS >= countT then matching. Update the length and remove char from left to see if len can be minimized
				if (r-l+1 < len) {
					len = (r-l+1);
					sRes = l;
					eRes = r;
				}

				ch = s.charAt(l);
				smap.put(ch, smap.getOrDefault(ch, 0) - 1);
				l++;
			}
		}

		if (eRes == Integer.MAX_VALUE) {
			return "";
		}
		return s.substring(sRes, eRes + 1);
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
