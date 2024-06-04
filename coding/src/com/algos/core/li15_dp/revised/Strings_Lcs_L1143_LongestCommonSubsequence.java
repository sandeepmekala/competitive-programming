	package  com.algos.core.li15_dp.revised;

public class Strings_Lcs_L1143_LongestCommonSubsequence {
	
	public static void main(String[] args) {
		Strings_Lcs_L1143_LongestCommonSubsequence obj = new Strings_Lcs_L1143_LongestCommonSubsequence();

		String str1 = "BATD", str2 = "ABACD";
		int m = str1.length(), n = str2.length();
		System.out.println(obj.longestCommonSubsequence(str1, str2, m, n));
		System.out.println(obj.longestCommonSubsequence(str1, str2));
	}
	
	// Problem: https://leetcode.com/problems/longest-common-subsequence/
	// Idea: If char match, add 1 and check for the rest of the substrings excluding that char
	// else, take the max of exclusion of the char1 in str1 and exclusion of char2 in str2
	// m and n defines the state
	// 
	//  	i\j	A	B	A	C	D	
	//  	B	0	1	1	1	1
	//  	A	1	1	2	2	2
	//  	T	1	1	2	2	2
	//  	D	1	1	2	2	3
	//  
	// Time: O(m*n)
    // Space: O(m*n)
	public int longestCommonSubsequence(String str1, String str2, int i, int j){
		if(i == 0 || j == 0)
			return 0;
		if(str1.charAt(i-1) == str2.charAt(j-1))		// index right shifted
			return 1 + longestCommonSubsequence(str1, str2, i-1, j-1);
		int lcs1 = longestCommonSubsequence(str1, str2, i-1, j);
		int lcs2 = longestCommonSubsequence(str1, str2, i, j-1);
		return Math.max(lcs1, lcs2);
	}

	public int longestCommonSubsequence(String str1, String str2) {
		int m = str1.length(), n = str2.length();

		int lcs[][] = new int[m+1][n+1];
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) { 	// matching
					lcs[i][j] = 1+lcs[i-1][j-1];
				}else {											// not matching
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}

		String lcsStr = getLcs(lcs, str1, str2, m, n);
		System.out.println(lcsStr);

		return lcs[m][n];
	}

	private String getLcs(int[][] lcs, String text1, String text2, int m, int n){
		StringBuffer sb = new StringBuffer();
		int i = m, j = n;
		while(i>0 && j>0){
			if(text1.charAt(i-1) == text2.charAt(j-1)){
				sb.append(text1.charAt(i-1));
				i--;
				j--;
			}else if(lcs[i-1][j] > lcs[i][j-1]){
				i--;
			}else{
				j--;
			}
		}
		
		return sb.reverse().toString();
	}
}
