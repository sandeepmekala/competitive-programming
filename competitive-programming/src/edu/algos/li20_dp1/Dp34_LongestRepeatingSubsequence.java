package edu.algos.li20_dp1;

public class Dp34_LongestRepeatingSubsequence {

	public static void main(String[] args) {
		Dp34_LongestRepeatingSubsequence obj = new Dp34_LongestRepeatingSubsequence();
		String string = "axxxy";
		System.out.println(obj.longest(string));
	}

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