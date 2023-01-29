package edu.algos.li20_dp.medium;

public class IncrementalLength_L647_PalindromicSubstrings {

	public static void main(String[] args) {
		IncrementalLength_L647_PalindromicSubstrings obj = new IncrementalLength_L647_PalindromicSubstrings();

		String text = "aaa";
		System.out.println(obj.countSubstrings(text));
	}

	// Problem: https://leetcode.com/problems/palindromic-substrings/
	// Idea: Same as longest polindromic substring.
	// Instead of tracking longest, count all the polindromes.
	public int countSubstrings(String s) {
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
