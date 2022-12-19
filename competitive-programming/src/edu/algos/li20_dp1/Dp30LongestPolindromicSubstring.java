package edu.algos.li20_dp1;

public class Dp30LongestPolindromicSubstring {

	public static void main(String[] args) {
		Dp30LongestPolindromicSubstring obj = new Dp30LongestPolindromicSubstring();
		
		//String text = "cbbd";
		//String text = "aacabdkacaa";
		String text = "bb";
		System.out.println(obj.longestPolindromicSubstringBottomUp(text));
	}
	
	/*	
	 * Idea: start with l=1 and go till l=n.
	 * if first char and last char matches, add 2 to the lenth and look into the substring except first and last chars
	 * track the max len and substring which is polindrom when max gets updated
	 * aba = 2+len(b) = 3
	 * 	 * 
	 * time: O(n^2)
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
	 * 
	 * */
	private String longestPolindromicSubstringBottomUp(String s) {
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
