
public class L5_LongestPalindromicSubstring {

	public static void main(String[] args) {
		L5_LongestPalindromicSubstring obj = new L5_LongestPalindromicSubstring();

		String s = "babad";
		// String s = "aacabdkacaa";
		// String s = "bb";
		System.out.println(obj.longestPalindrome(s));
		System.out.println(obj.longestPalindrome2(s));
	}
	// Problem: https://leetcode.com/problems/longest-palindromic-substring/
	// Idea: Expand around center
	// Alternative: This can be solved using DP with same complexity.
	// Time: O(n^2)
	public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);			// aba
            int len2 = expandAroundCenter(s, i, i + 1);		// abba
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
			if (s.charAt(l) != s.charAt(r))
				break;
            l--;
            r++;
        }
        return r - l - 1;
    }

	// Idea: Start with l=1 and go till l=n.
	// If first char and last char matches, add 2 to the lenth and look into the substring except first and last chars
	// Track the max len and substring which is polindrom when max gets updated
	// aba = 2+len(b) = 3
	//
	// Time: O(n^2)
	//
	// 	T[i][j] = T[i+1][j-1] if str[i] == str[j]
	//
	//
	//	i\j	b	a	b	a	d
	//	b	t	f	t	f	f
	//	a		t	f	t	f
	//	b			t	f	f
	//	a				t	f
	//	d					t
	//
	//	max = 3
	//
	// Time: O(n^2)
    // Space: O(n*n)
	public String longestPalindrome2(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];

		int maxLen = 0;
		String polindrom = "";
		for(int l=0; l<n; l++) {
			for(int i=0; i<n-l; i++) {
				int j = i+l;
				if (i == j) {
					dp[i][j] = true;						// handles "b"
				} else if (s.charAt(i) == s.charAt(j)) {
					if(l == 1) {							// handles "bb"
						dp[i][j] = true;
					}else {
						dp[i][j] = dp[i + 1][j - 1];
					}
				}

				if(dp[i][j] && j-i+1 > maxLen) {
					maxLen = j-i+1;
					polindrom = s.substring(i, j+1);
				}
			}
		}
		return polindrom;
	}
}
