package edu.algos.li21.dp2;

import java.util.HashMap;

public class DistinctSubsequences {

	public static void main(String[] args) {
		DistinctSubsequences obj = new DistinctSubsequences();
		
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(obj.numDistinct(s, t));
	}

	public int numDistinct(String s, String t) {

		HashMap<String, Integer> mem = new HashMap<>();
		return numDistinctRec(0, 0, s, t, mem);
	}

	private int numDistinctRec(int i, int j, String s, String t, HashMap<String, Integer> mem) {
		int m = s.length(), n = t.length();
		if (j == n) {
			return 1;
		}

		if (i == m && j < n) {
			return 0;
		}

		String key = i + ":" + j;
		if (mem.containsKey(key)) {
			return mem.get(key);
		}

		if (s.charAt(i) == t.charAt(j)) {
			int count = numDistinctRec(i + 1, j + 1, s, t, mem) + numDistinctRec(i + 1, j, s, t, mem);
			mem.put(key, count);
		} else {
			int count = numDistinctRec(i + 1, j, s, t, mem);
			mem.put(key, count);
		}

		return mem.get(key);
	}
}
