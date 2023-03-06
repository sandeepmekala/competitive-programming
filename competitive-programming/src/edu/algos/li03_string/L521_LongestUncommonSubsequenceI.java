package edu.algos.li03_string;

public class L521_LongestUncommonSubsequenceI {

	public static void main(String[] args) {
		L521_LongestUncommonSubsequenceI obj = new L521_LongestUncommonSubsequenceI();
		
		System.out.println(obj.findLUSlength("abc", "aaaaa"));
	}

	/*
	 * Problem: https://leetcode.com/problems/longest-uncommon-subsequence-i/
	 * Companies: Amazon, Google, Facebook
	 * Idea: If two string are equal, means every subseq of str1 is a subsequence of str2.
	 * If strings are not equal, the max len string subsequence is itself and it can't be there in other string.
	 * */
	public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
