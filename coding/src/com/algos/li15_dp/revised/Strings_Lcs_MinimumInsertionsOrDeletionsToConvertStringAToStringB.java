package  com.algos.li15_dp.revised;

public class Strings_Lcs_MinimumInsertionsOrDeletionsToConvertStringAToStringB {
    public static void main(String[] args) {
        Strings_Lcs_MinimumInsertionsOrDeletionsToConvertStringAToStringB obj = new Strings_Lcs_MinimumInsertionsOrDeletionsToConvertStringAToStringB();

        System.out.println(obj.minOperations("abcd", "anc"));
    }

    // Idea: ac are common in both strings. 
    // To make s1 to s2, we need to keep ac intact and remove bd from s1 and insert n.
    // #deletions = m-lcs(s1, s2);
    // #insertions = n-lcs(s1, s2);
    // total = deletion + insertion
    // Time: O(m*n)
    // Space: O(m*n)
    public int minOperations(String str1, String str2){
        int m = str1.length(), n = str2.length();
        return (m+n)-2*longestCommonSubsequence(str1, str2);
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
