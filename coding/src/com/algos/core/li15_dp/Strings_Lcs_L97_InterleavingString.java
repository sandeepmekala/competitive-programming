package  com.algos.core.li15_dp;

public class Strings_Lcs_L97_InterleavingString {

	public static void main(String[] args) {
		Strings_Lcs_L97_InterleavingString obj = new Strings_Lcs_L97_InterleavingString();

		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";

		System.out.println(obj.isInterleave(s1, s2, s3));
	}

	// Problem: https://leetcode.com/problems/interleaving-string/
	// Idea: Concept is similar to LCS. 
	// If ch1 in s1 matches with ch in s3 then expect remaining string before ch1 to be true.
	// If ch2 in s2 matches with char in s3 then expect remaining string before char2 to be true. 
	// 
	// 
	// T[i][j] = { 
	// 				T[i-1][j] if(s1[i] == s3[i+j])
	// 				T[i1][j-1] if(s2[j] == s3[i+j]) 
	// }
	// 
	// k=i+j
	// 
	// i/j	"" 	d 	b 	b 	c	a 
	// ""	t	f	f	f	f	f
	// a	t	f	f	f	f	f
	// a	t	t	t	t	t	f
	// b	f	t	t	t			
	// c	f	
	// c	f
	// 
	public boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length(), n = s2.length();
		if (m + n != s3.length()) 
			return false;

		boolean[][] dp = new boolean[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) {
						dp[i][j] = true;
					}
				} else if (j == 0) {
					if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) {
						dp[i][j] = true;
					}
				} else {
					if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) {
						dp[i][j] = true;
					}else if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) {
						dp[i][j] = true;
					}
				}
			}
		}
		return dp[m][n];
	}
}
