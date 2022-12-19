package edu.algos.li20_dp1;

public class Dp31LongestPolindromicSubsequence {

	public static void main(String[] args) {
		Dp31LongestPolindromicSubsequence obj = new Dp31LongestPolindromicSubsequence();
		
		String text = "agbdba";
		int n = text.length();
		
		System.out.println(obj.longestPolindromicSubsequenceTopDown(text, 0, n-1));
		System.out.println(obj.longestPolindromicSubsequenceBottomUp(text, n));
	}
	
	/*	
	 * Idea: Start with l=1 and go till l=n.
	 * if first char and last char matches, add 2 to the lenth and look into the substring except first and last chars
	 * if doesn't match, take the max length if you ignore first char or last char.
	 * aba = 2+len(b) = 3
	 * abb = max(ab, bb) = 2
	 * 
	 * time: O(n^2)
	 * 
	 * 	T[i][j] = {
	 * 		2+T[i+1][j-1] if str[i] == str[j]
	 * 		Max(T[i+1][j], [i][j-1])
	 * }
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
	private int longestPolindromicSubsequenceBottomUp(String string, int n) {
		int[][] mem = new int[n][n];
		for(int l=0; l<n; l++) {
			for(int i=0; i<n-l; i++) {
				int j = i+l;
				if (i == j) {
					mem[i][j] = 1;
				} else if (string.charAt(i) == string.charAt(j)) {
					mem[i][j] = 2 + mem[i + 1][j - 1];
				} else {
					mem[i][j] = Math.max(mem[i + 1][j], mem[i][j - 1]);
				}
				 
				System.out.println(l+"=>"+i+":"+j);
			}
		}
		return mem[0][n-1];
	}
	
	private int longestPolindromicSubsequenceTopDown(String text, int i, int j) {
		if(j == i) {
			return 1;
		}else if(j < i) {
			return 0;
		}else if(text.charAt(i) == text.charAt(j)) {
			return 2+longestPolindromicSubsequenceTopDown(text, i+1, j-1);
		}else {
			return Math.max(longestPolindromicSubsequenceTopDown(text, i+1, j), longestPolindromicSubsequenceTopDown(text, i, j-1));
		}
	}
}
