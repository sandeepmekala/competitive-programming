package  com.algos.topics.li18_string.revised;

public class L647_PalindromicSubstrings {

	public static void main(String[] args) {
		L647_PalindromicSubstrings obj = new L647_PalindromicSubstrings();

		String s = "aaa";
		System.out.println(obj.countSubstrings(s));
		System.out.println(obj.countSubstrings2(s));
	}

	// Problem: https://leetcode.com/problems/palindromic-substrings/
	// Idea: Same as longest polindromic substring. Solvable using expand around center approach and DP.
	// Instead of tracking longest, count all the polindromes.
	public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s, i, i);   	// odd length palindromes
            count += expandAroundCenter(s, i, i + 1); 	// even length palindromes
        }
        return count;
    }

    private int expandAroundCenter(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length()) {
			if (s.charAt(l) != s.charAt(r))
				break;
            count++;
            l--;
            r++;
        }
        return count;
    }

	// DP
	public int countSubstrings2(String s) {
        int n = s.length();
		boolean[][] mem = new boolean[n][n];

		int count = 0;
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

				if(mem[i][j]) {
					count ++;
				}
			}
		}
		return count;
    }

}
