
public class Strings_L72_EditDistance {

	public static void main(String[] args) {
		Strings_L72_EditDistance obj = new Strings_L72_EditDistance();

		String word1 = "voldemort";
		String word2 = "dumbledore";

		int m = word1.length(), n = word2.length();
		System.out.println(obj.minDistance(word1, word2, m, n));

		System.out.println(obj.minDistance(word1, word2));

	}

	// Problem: https://leetcode.com/problems/edit-distance/
	// Convert word1 to word2 with Insert, Delete or Replace
	// Idea: Similar like other algos of matching char by char
	// If chars at i, j are matching, check T[i-1][j-1]
	// Else there are 3 posibilities to be taken care and we need to take min of those
	// Time: O(m*n)
    // Space: O(m*n)
	public int minDistance(String word1, String word2, int i, int j) {
		if(i == 0)
			return j;			// str1 is empty. Insert all the chars of str2
		if(j == 0)
			return i;			// str2 is empty. Delete all the chars of str1

		if(word1.charAt(i-1) == word2.charAt(j-1)) {
			return 0 + minDistance(word1, word2, i-1, j-1);
		}else {
			return 1 + Math.min(Math.min((minDistance(word1, word2, i-1, j)), 	// delete str1 char
					minDistance(word1, word2, i, j-1)),							// insert str2 char in str1
					minDistance(word1, word2, i-1, j-1));						// replace str1 char with str2 char
		}
	}

	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();

		int[][] mem = new int[m+1][n+1]; 		// one extra index is needed for empty string
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i == 0) {					// str1 is empty. Insert all the chars of str2
					mem[i][j] = j;
				}else if(j == 0) {				// str2 is empty. Delete all the chars of str1
					mem[i][j] =  i;
				}else if(word1.charAt(i-1) == word2.charAt(j-1)) {
					mem[i][j] = mem[i-1][j-1];
				}else {
					mem[i][j] = 1+Math.min(
							Math.min(
									mem[i-1][j], 	// delete str1 char
									mem[i][j-1]),	// insert str2 char in str1
							mem[i-1][j-1]);			// replace str1 char with str2 char
				}
			}
		}
		return mem[m][n];
	}
}
