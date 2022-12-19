package edu.algos.li21_dp2;

public class Dp07LongestCommonSubstring {

	public static void main(String[] args) {
		String str1 = "abcdaf";
		String str2 = "zbcdf";
		int m = str1.length();
		int n = str2.length();
		System.out.println(longestCommonSubstring(str1, str2, m, n));
	}

	/*		
	 * Idea: If char1 in str1 is equal to char2 in str2, check for remaining str1 and str2 excluding char1 and char2.
	 * 		
	 *		i\j	a	b	c	d	a	f
	 * 		z	0	0	0	0	0	0	
	 * 		b	0	1	0	0	0	0
	 * 		c	0	0	2	0	0	0
	 * 		d	0	0	0	3	0	0
	 * 		f	0	0	0	0	0	1
	 * */
	// time: O(m*n)
	private static int longestCommonSubstring(String str1, String str2, int m, int n) {
		int[][] mem = new int[m][n];
		int max = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(str1.charAt(i) == str2.charAt(j)){
					if(i == 0 || j == 0) {
						mem[i][j] = 1;
					}else {
						mem[i][j] = 1+mem[i-1][j-1];
					}
					
					if(mem[i][j] > max) {
						max = mem[i][j];
					}
				}
			}
		}
		return max;
	}

}
