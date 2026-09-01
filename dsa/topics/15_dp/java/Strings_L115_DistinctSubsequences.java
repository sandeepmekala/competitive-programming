public class Strings_L115_DistinctSubsequences {

	public static void main(String[] args) {
		Strings_L115_DistinctSubsequences obj = new Strings_L115_DistinctSubsequences();

		String s = "rabbbit", t = "rabbit";
		int m = s.length(), n = t.length();
		System.out.println(obj.numDistinct(s, t));

		System.out.println(obj.numDistinct(s, t, m, n));
	}

	// Problem: https://leetcode.com/problems/distinct-subsequences/
	// Idea: If char at i, j matching, check T[i-1][j-1] and T[i-1][j]
	// 		 Else check T[i-1][j]
	// Time: O(m*n)
    // Space: O(m*n)
	public int numDistinct(String s, String t, int i, int j) {
		if (j == 0)
			return 1;
		if (i == 0)
			return 0;

		if (s.charAt(i-1) == t.charAt(j-1)) {
			return numDistinct(s, t, i-1, j-1) + numDistinct(s, t, i-1, j);
		}

		return numDistinct(s, t, i-1, j);
	}

	public int numDistinct(String s, String t) {
		int m = s.length(), n = t.length();

		int[][] dp = new int[m+1][n+1];
		for(int i=0; i<=m; i++)
			dp[i][0] = 1;

		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if (s.charAt(i-1) == t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				} else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[m][n];
	}
}
