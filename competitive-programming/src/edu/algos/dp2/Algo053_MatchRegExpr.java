package edu.algos.dp2;

public class Algo053_MatchRegExpr {

	public static void main(String[] args) {
		Algo053_MatchRegExpr obj = new Algo053_MatchRegExpr();
		String[] texts = new String[]  {	"xabyc",  "aa", "a", "aaa", "a",   "a",  "a",  "aaabbcd"};
		String[] patterns = new String[] {	"xa*b.c", "ab", "a.", "a.", "aa.", ".*", "a*", "a*b*.."};
		boolean[] results = new boolean[] {	true, false, false, false, false, true, true, true};
		
		//for(int i=0; i<texts.length; i++) {
			int i = 5;
			int n = texts[i].length();
			int m = patterns[i].length();
			System.out.println(i+":"+(Algo053_MatchRegExpr.match(texts[i], patterns[i], n, m) == results[i]));
		//}
		
	}
	
	/* concept: 
	 * * matches 0 or more occurances of a char before it
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
	private static boolean match(String text, String pattern, int n, int m) {
		boolean[][] mem = new boolean[n+1][m+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				if(i == 0 && j == 0) {
					mem[i][j] = true;
				}else if(i == 0) {
					if(pattern.charAt(j-1) == '*') {
						mem[i][j] = mem[i][j-1];
					}
				}else if(j == 0) {
					mem[i][j] = false;
				}else if(text.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '.') {
					mem[i][j] = mem[i-1][j-1];
				}else if(pattern.charAt(j-1) == '*') {
					mem[i][j] = mem[i][j-2] || ((text.charAt(i-1) == pattern.charAt(j-2) || pattern.charAt(j-2) == '.') && mem[i-1][j]);
				}else {
					mem[i][j] = false;
				}
			}
		}
		return mem[n][m];
	}

}
