package edu.algos.li09.string;

public class LongestUncommonSubsequenceI {

	public static void main(String[] args) {
		LongestUncommonSubsequenceI obj = new LongestUncommonSubsequenceI();
		
		System.out.println(obj.findLUSlength("abc", "aaaaa"));
	}

	/*
	 * Problem: https://leetcode.com/problems/longest-uncommon-subsequence-i/
	 * Companies: Amazon, Google, Facebook
	 * */
	public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
