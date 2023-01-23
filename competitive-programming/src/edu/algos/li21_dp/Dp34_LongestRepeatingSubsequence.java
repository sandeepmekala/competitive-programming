package edu.algos.li21_dp;

public class Dp34_LongestRepeatingSubsequence {

	public static void main(String[] args) {
		Dp34_LongestRepeatingSubsequence obj = new Dp34_LongestRepeatingSubsequence();
		String string = "axxxy";
		System.out.println(obj.longest(string));
	}

	// Problem: https://leetcode.com/discuss/general-discussion/1274765/longest-repeated-subsequence-lrs
	/*			a	x	x	x	y
	 * 		i\j	0	1	2	3	4
	 * 	a	0	0	0	0	0	0
	 * 	x	1	1	
	 * 	x	2	
	 * 	x	3
	 * 	y	4
	 * 
	 * */
	private char[] longest(String string) {
		return null;
	}

}
