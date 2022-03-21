package edu.algos.dp;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String str1 = " abcdaf";
		String str2 = " zbcdf";
		int m = str1.length();
		int n = str2.length();
		System.out.println(longestCommonSubstring(str1, str2, m, n));
	}

	/*				a	b	c	d	a	f
	 *		i\j	0	1	2	3	4	5	6
	 * 		0	0	0	0	0	0	0	0
	 * 	z	1	0	0	0	0	0	0	0	
	 * 	b	2	0	0	1	0	0	0	0
	 * 	c	3	0	0	0	2	0	0	0
	 * 	d	4	0	0	0	0	3	0	0
	 * 	f	5	0	0	0	0	0	0	1
	 * */
	private static int longestCommonSubstring(String str1, String str2, int m, int n) {
		int[][] mem = new int[m][n];
		int max = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i == 0 || j == 0) {
					mem[i][j] = 0;
				}else if(str1.charAt(i) == str2.charAt(j)){
					mem[i][j] = 1+mem[i-1][j-1];
					if(mem[i][j] > max) {
						max = mem[i][j];
					}
				}
			}
		}
		return max;
	}

}
