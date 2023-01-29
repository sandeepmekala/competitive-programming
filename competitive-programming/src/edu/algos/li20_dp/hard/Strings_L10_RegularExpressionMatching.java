package edu.algos.li20_dp.hard;

public class Strings_L10_RegularExpressionMatching {

	public static void main(String[] args) {
		Strings_L10_RegularExpressionMatching obj = new Strings_L10_RegularExpressionMatching();
		String s = "xabyc";
		String p = "xa*b.c";
		
		System.out.println(obj.isMatch(s, p));
		
	}
	
	/* Idea: 
	 * * matches 0 or more occurrences of a char before it
	 * . matches any single char
	 * T[i][j] = {
	 * 		T[i-1][j-1] 														if str[i] == pat[j] || pat[j] == '.'
	 * 		(T[i][j-2] || T[i-1][j] if str[i] == pat[j-1] || pat[j-1] == '.') 	if pat[j] == '*'
	 * }
	 * 
	 * 			
	 *			""	x	a 	*	b	.	c
	 * 		i\j	0	1	2	3	4	5	6		
	 * ""	0	T	F	F	F	F	F	F
	 * x	1	F	T	F	T	F	F	F
	 * a	2	F	F	T	T	F	F	F	
	 * a	3	F	F	F	T	F	F	F
	 * b	4	F	F	F	F	T	F	F
	 * y	5	F	F	F	F	F	T	F
	 * c	6	F	F	F	F	F	F	T
	 * 		
	 * */
	public boolean isMatch(String s, String p) {
		int n = s.length(), m = p.length();
		
		boolean[][] match = new boolean[n+1][m+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				if(i == 0 && j == 0) {
					match[i][j] = true;
				}else if(j == 0) {
					match[i][j] = false;
				}else if(i == 0) {
					if(p.charAt(j-1) == '*') {
						match[i][j] = match[i][j-2];
					}
				}else if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
					match[i][j] = match[i-1][j-1];
				}else if(p.charAt(j-1) == '*') {
					match[i][j] = match[i][j-2] || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && match[i-1][j]);
				}else {
					match[i][j] = false;
				}
			}
		}
		return match[n][m];
	}

}
