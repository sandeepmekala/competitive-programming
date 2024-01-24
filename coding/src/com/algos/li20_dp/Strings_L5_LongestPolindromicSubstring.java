package  com.algos.li20_dp;

public class Strings_L5_LongestPolindromicSubstring {

	public static void main(String[] args) {
		Strings_L5_LongestPolindromicSubstring obj = new Strings_L5_LongestPolindromicSubstring();
		
		String text = "babad";
		//String text = "aacabdkacaa";
		//String text = "bb";
		System.out.println(obj.longestPalindrome(text));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/longest-palindromic-substring/
	 * Idea: Start with l=1 and go till l=n.
	 * If first char and last char matches, add 2 to the lenth and look into the substring except first and last chars
	 * Track the max len and substring which is polindrom when max gets updated
	 * aba = 2+len(b) = 3
	 * 	 * 
	 * Time: O(n^2)
	 * 
	 * 	T[i][j] = T[i+1][j-1] if str[i] == str[j]
	 * 		
	 * 
	 *	i\j	b	a	b	a	d
	 *	b	t	f	t	f	f
	 *	a		t	f	t	f
	 *	b			t	f	f
	 *	a				t	f	
	 *	d					t
	 *	
	 *	max = 3	
	 *
	 * CHECK
	 * */
	// Time: O(n*n)
    // Space: O(n*n)
	public String longestPalindrome(String s) {
		int n = s.length();
		boolean[][] mem = new boolean[n][n];
		
		int maxLen = 0;
		String polindrom = "";
		for(int l=0; l<n; l++) {
			for(int i=0; i<n-l; i++) {
				int j = i+l;
				if (i == j) {
					mem[i][j] = true;						//handles "b"
				} else if (s.charAt(i) == s.charAt(j)) {
					if(l == 1) {							//handles "bb"
						mem[i][j] = true;
					}else {
						mem[i][j] = mem[i + 1][j - 1];
					}
				}
				
				if(mem[i][j] && j-i+1 > maxLen) {
					maxLen = j-i+1;
					polindrom = s.substring(i, j+1);
				}
			}
		}
		return polindrom;
	}
}
