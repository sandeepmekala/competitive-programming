package  com.algos.core.li15_dp.revised;

public class Strings_Lcs_LongestCommonSubstring {

	public static void main(String[] args) {
		String str1 = "abcdaf";
		String str2 = "zbcdf";
		System.out.println(longestCommonSubstring(str1, str2));
	}

	/*		
	 * Idea: If char1 in str1 is equal to char2 in str2, check for remaining str1 and str2 excluding char1 and char2.
	 * 		
	 *		i\j	""	a	b	c	d	a	f
	 * 		""	0	0	0	0	0	0	0
	 * 		z	0	0	0	0	0	0	0	
	 * 		b	0	0	1	0	0	0	0
	 * 		c	0	0	0	2	0	0	0
	 * 		d	0	0	0	0	3	0	0
	 * 		f	0	0	0	0	0	0	1
	 * */
	// Time: O(m*n)
    // Space: O(m*n)
	private static int longestCommonSubstring(String str1, String str2) {
		int m = str1.length(), n = str2.length();

		int[][] mem = new int[m+1][n+1];
		int max = 0;
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)){
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
