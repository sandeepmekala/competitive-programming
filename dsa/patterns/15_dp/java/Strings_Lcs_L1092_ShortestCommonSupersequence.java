public class Strings_Lcs_L1092_ShortestCommonSupersequence {
    public static void main(String[] args) {
        Strings_Lcs_L1092_ShortestCommonSupersequence obj = new Strings_Lcs_L1092_ShortestCommonSupersequence();

        System.out.println(obj.shortestCommonSupersequence("abac", "cab"));
    }

    // Problem: https://leetcode.com/problems/shortest-common-supersequence/
    // Idea: If we put two strings together, it forms a supersequence.
    // Common guys can be counted once to minumize the count. Common guys can found with lcs.
    // The super sequence can be found the same way of lcs using while loop.
    // Time: O(m*n)
    // Space: O(m*n)
	public String shortestCommonSupersequence(String text1, String text2) {
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

        return getShortestCommonSupersequence(lcs, text1, text2, m, n);
    }

    private String getShortestCommonSupersequence(int[][] lcs, String str1, String str2, int m, int n){
		StringBuffer sb = new StringBuffer();
		int i=m, j=n;
		while(i>0 && j>0){
			if(str1.charAt(i-1) == str2.charAt(j-1)){
				sb.append(str1.charAt(i-1));
				i--; j--;
			}else if(lcs[i-1][j] > lcs[i][j-1]){
                sb.append(str1.charAt(i-1));
				i--;
			}else{
                sb.append(str2.charAt(j-1));
				j--;
			}
		}

        while(i>0){
            sb.append(str1.charAt(i-1));
			i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
			j--;
        }
		return sb.reverse().toString();
	}
}
