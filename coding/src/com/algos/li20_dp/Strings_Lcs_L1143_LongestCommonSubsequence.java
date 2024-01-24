	package  com.algos.li20_dp;

public class Strings_Lcs_L1143_LongestCommonSubsequence {
	
	public static void main(String[] args) {
		Strings_Lcs_L1143_LongestCommonSubsequence obj = new Strings_Lcs_L1143_LongestCommonSubsequence();

		System.out.println(obj.longestCommonSubsequence("BATD", "ABACD"));
		System.out.println(obj.longestCommonSubsequence("BATD", "ABACD", 4, 5));
	}
	
	/*
	 * 	i\j	A	B	A	C	D	
	 * 	B	0	1	1	1	1
	 * 	A	1	1	2	2	2
	 * 	T	1	1	2	2	2
	 * 	D	1	1	2	2	3
	 * 
	 * */
	// Problem: https://leetcode.com/problems/longest-common-subsequence/
	// Idea: If char match, add 1 and check for the rest of the substrings excluding that char
	// else, take the max of exclusion of the char1 in str1 and exclusion of char2 in str2
	// m and n defines the state
	// Time: O(m*n)
    // Space: O(m*n)
	public int longestCommonSubsequence(String text1, String text2) {
		int m=text1.length(), n=text2.length();

		int lcs[][] = new int[m+1][n+1];
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) { 	// matching
					lcs[i][j] = 1+lcs[i-1][j-1];
				}else {											// not matching
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}

		String lcsStr = getLcs(lcs, text1, text2, m, n);
		System.out.println(lcsStr);

		return lcs[m][n];
	}
	
	public int longestCommonSubsequence(String text1, String text2, int i, int j){
		if(i == 0 || j == 0)
			return 0;
		if(text1.charAt(i-1) == text2.charAt(j-1))
			return 1 + longestCommonSubsequence(text1, text2, i-1, j-1);
		int lcs1 = longestCommonSubsequence(text1, text2, i-1, j);
		int lcs2 = longestCommonSubsequence(text1, text2, i, j-1);
		return Math.max(lcs1, lcs2);
	}

	private String getLcs(int[][] lcs, String text1, String text2, int m, int n){
		int len = lcs[m][n];
		StringBuffer sb = new StringBuffer();
		sb.setLength(len);

		int i=m, j=n, ind=len-1;
		while(i>0 && j>0){
			if(text1.charAt(i-1) == text2.charAt(j-1)){
				sb.insert(ind, text1.charAt(i-1));
				ind--;
				i--;
				j--;
			}else if(lcs[i-1][j] > lcs[i][j-1]){
				i--;
			}else{
				j--;
			}
		}
		return sb.toString();
	}
}
