package edu.algos.dp;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {
		LongestRepeatingSubsequence obj = new LongestRepeatingSubsequence();
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
