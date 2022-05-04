package edu.algos.dp;

import java.util.Arrays;

public class Algo054_MatchWildcard {

	public static void main(String[] args) {
		Algo054_MatchWildcard obj = new Algo054_MatchWildcard();
		
		String[] texts = new String[]  {	"xaylmz",  "ccddee"};
		String[] patterns = new String[] {	"x?y*z", "*ccddee*"};
		boolean[] results = new boolean[] {	true, true};
		
		for(int i=0; i<texts.length; i++) {
			//int i = 7;
			int n = texts[i].length();
			int m = patterns[i].length();
			System.out.println(i+":"+(obj.match(texts[i], patterns[i], n, m) == results[i]));
		}
	}

	/* concept:
	 * 		* zero or more chars
	 * 		? any one char
	 * 
	 * T[i][j] = {
	 * 		T[i-1][j-1]				if str[i] == pat[j] || pat[j] == '?'
	 * 		T[i][j=1] || T[i-1][j]	if pat[j] == '*'
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
	private boolean match(String string, String pattern, int n, int m) {
		boolean[][] mem = new boolean[n+1][m+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				if(i == 0 && j == 0) {
					mem[i][j] = true;
				}else if(i == 0) {
					if(pattern.charAt(j-1) == '*') {
						mem[i][j] = mem[i][j-1];
					}
				}else if(j == 0 ) {
					mem[i][j] = false;
				}else if(string.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?') {
					mem[i][j] = mem[i-1][j-1];
				}else if(pattern.charAt(j-1) == '*'){
					mem[i][j] = mem[i][j-1]||mem[i-1][j];
				}else {
					mem[i][j] = false;
				}
			}
		}
//		for(int i=0; i<=m; i++) {
//			System.out.print(pattern.charAt(i)+"      ");
//		}
//		System.out.println();
//		for(int i=0; i<=n; i++) {
//			System.out.println(Arrays.toString(mem[i]));
//		}
		return mem[n][m];
	}

}
