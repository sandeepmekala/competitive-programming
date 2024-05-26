package  com.algos.core.li15_dp.revised;

public class Strings_Lcs_L1312_MinimumInsertionStepsToMakeAStringPalindrome {
    public static void main(String[] args) {
        Strings_Lcs_L1312_MinimumInsertionStepsToMakeAStringPalindrome obj = new Strings_Lcs_L1312_MinimumInsertionStepsToMakeAStringPalindrome();

        String s = "mbadm";
        System.out.println(obj.minInsertions(s));
    }

    // Problem: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
    // Idea: We can reuse longest polindrome subseq.
    // String already has a longest polindrome. We should keep that intact and insert char around it to make the whole string as polindrome.
    // Hence, the number of insertions that we need to do is number of chars not part of longest polindrome.
    // Time: O(m*n)
    // Space: O(m*n)
	public int minInsertions(String s) {
        int n = s.length();
        return n-longestPalindromeSubseq(s);
    }

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
}
