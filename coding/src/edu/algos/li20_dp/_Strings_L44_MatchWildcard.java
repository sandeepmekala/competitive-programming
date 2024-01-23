package edu.algos.li20_dp;

public class _Strings_L44_MatchWildcard {

	public static void main(String[] args) {
		_Strings_L44_MatchWildcard obj = new _Strings_L44_MatchWildcard();
		
		String s = "xaylmz", p = "x?y*z";
		int n = s.length(), m=p.length();
		System.out.println(obj.isMatch(s, p, n, m));
	}

	/* Problem: https://leetcode.com/problems/wildcard-matching/
	 * Idea: Match char by char.
	 * 		* zero or more chars
	 * 		? any one char
	 * 
	 * T[i][j] = {
	 * 		T[i-1][j-1]				if str[i] == pat[j] || pat[j] == '?'
	 * 		T[i][j-1] || T[i-1][j]	if pat[j] == '*'
	 * }
	 * 
	 * 			""	x 	?	y	*	z
	 * 		i\j	0	1	2	3	4	5
	 * 	""	0	T	F	F	F	F	F
	 * 	x	1	F	T	F	F	F	F
	 * 	a	2	F	F	T	F	F	F	
	 * 	y	3	F	F	F	T	T	F	
	 * 	l	4	F	F	F	F	T	F	
	 * 	m	5	F	F	F	F	T	F	
	 * 	z	6	F	F	F	F	T	T
	 * 
	 * */
	// Time: O(m*n)
    // Space: O(m*n)
	public boolean isMatch(String s, String p) {
		int n = s.length(), m=p.length();

		boolean[][] match = new boolean[n+1][m+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				if(i == 0 && j == 0) {
					match[i][j] = true;
				}else if(j == 0) {
					match[i][j] = false;
				}else if(i == 0) {
					if(p.charAt(j-1) == '*') {
						match[i][j] = match[i][j-1];
					}
				}else if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
					match[i][j] = match[i-1][j-1];
				}else if(p.charAt(j-1) == '*'){
					match[i][j] = match[i][j-1]||match[i-1][j];
				}else {
					match[i][j] = false;
				}
			}
		}
		return match[n][m];
	}

	public boolean isMatch(String s, String p, int i, int j) {
		if(i == 0 && j == 0)
			return true;
		if(i > 0 && j == 0)
			return false;
		if(i == 0 && j > 0){
			for(int k=0; k<=j; j++){
				if(p.charAt(k) != '*')
					return false;
			}
			return true;
		}

		if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
			return isMatch(s, p, i-1, j-1);
		}
		if(p.charAt(j-1) == '*'){
			return isMatch(s, p, i, j-1) || isMatch(s, p, i-1, j);
		}

		return false; 
	}
}
