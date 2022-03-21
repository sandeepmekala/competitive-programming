package edu.algos.dp;

public class LongestPolindromicSubsequence {

	public static void main(String[] args) {
		String text = "agbdba";
		int n = text.length();
		System.out.println(longestPolindromicSubsequenceTopDown(text, 0, n-1));
		System.out.println(longestPolindromicSubsequenceBottomUp(text, n));
	}

	private static int longestPolindromicSubsequenceTopDown(String text, int i, int j) {
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
	
	/*		T[i][j] = {	2*T[i+1][j-1] if str[i] == str[j]
	 * 					Max(T[i+1][j], [i][j-1])
	 * 				  }
	 * 
	 * 			a	g	b	d	b	a
	 * 		i\j	0	1	2	3	4	5
	 * a	0	1	1	1	1	3	5
	 * g	1		1	1	1	3	3
	 * b	2			1	1	3	3
	 * d	3				1	1	1	
	 * b	4					1	1
	 * a	5						1
	 * 
	 * */
	private static int longestPolindromicSubsequenceBottomUp(String string, int n) {
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

}
