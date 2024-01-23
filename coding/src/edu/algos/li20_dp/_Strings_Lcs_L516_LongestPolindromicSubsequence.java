package edu.algos.li20_dp;

public class _Strings_Lcs_L516_LongestPolindromicSubsequence {

	public static void main(String[] args) {
		_Strings_Lcs_L516_LongestPolindromicSubsequence obj = new _Strings_Lcs_L516_LongestPolindromicSubsequence();
		
		String s = "agbdba";
		int n = s.length();
		
		System.out.println(obj.longestPalindromeSubseq(s, 0, n-1));
		System.out.println(obj.longestPalindromeSubseq2(s));
	}
	// Problem: https://leetcode.com/problems/longest-palindromic-subsequence/	
	// Idea: We can reuse lcs logic. You can reverse s and find lcs of s and reverse(s). This is longest polindrome.
	// Time: O(m*n)
    // Space: O(m*n)
	public int longestPalindromeSubseq(String s) {
		String t = new StringBuffer(s).reverse().toString();
		return longestCommonSubsequence(s, t);
	}
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

		return lcs[m][n];
	}


	/* Problem: https://leetcode.com/problems/longest-palindromic-subsequence/	
	 * Idea: Start with l=1 and go till l=n.
	 * if first char and last char matches, add 2 to the lenth and look into the substring except first and last chars
	 * if doesn't match, take the max length if you ignore first char or last char.
	 * aba = 2+len(b) = 3
	 * abb = max(ab, bb) = 2
	 * 
	 * Time: O(n^2)
	 * 
	 * 	T[i][j] = {
	 * 		2+T[i+1][j-1] if str[i] == str[j]
	 * 		Max(T[i+1][j], [i][j-1])
	 *  }
	 * 		
	 * 
	 *	i\j	a	g	b	d	b	a
	 *	a	1	1	1	1	3	5
	 *	g		1	1	1	3	3
	 *	b			1	1	3	3
	 *	d				1	1	1	
	 *	b					1	1
	 *	a						1
	 *
	 * 
	 * */
	public int longestPalindromeSubseq2(String s) {
		int n = s.length();
		int[][] mem = new int[n][n];
		for(int l=0; l<n; l++) {
			for(int i=0; i<n-l; i++) {
				int j = i+l;
				if (i == j) {
					mem[i][j] = 1;
				} else if (s.charAt(i) == s.charAt(j)) {
					mem[i][j] = 2 + mem[i + 1][j - 1];
				} else {
					mem[i][j] = Math.max(mem[i + 1][j], mem[i][j - 1]);
				}
				 
				//System.out.println(l+"=>"+i+":"+j);
			}
		}
		return mem[0][n-1];
	}
	
	private int longestPalindromeSubseq(String text, int i, int j) {
		if(j == i) {
			return 1;
		}else if(j < i) {
			return 0;
		}else if(text.charAt(i) == text.charAt(j)) {
			return 2+longestPalindromeSubseq(text, i+1, j-1);
		}else {
			return Math.max(longestPalindromeSubseq(text, i+1, j), longestPalindromeSubseq(text, i, j-1));
		}
	}
}
