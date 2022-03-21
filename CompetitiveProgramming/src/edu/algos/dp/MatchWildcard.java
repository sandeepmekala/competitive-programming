package edu.algos.dp;

import java.util.Arrays;

public class MatchWildcard {

	public static void main(String[] args) {
		MatchWildcard obj = new MatchWildcard();
//		String string = " xaylmz";
//		String pattern = " x?y*z";
		
		String string = " ccddee";
		String pattern = " *ccddee*";
		
		System.out.println(obj.match(string, pattern, string.length(), pattern.length()));
	}

	/*		* one or more chars
	 * 		? any one char
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
		boolean[][] mem = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i == 0 && j == 0) {
					mem[i][j] = true;
				}else if(i == 0) {
					if(pattern.charAt(j) == '*') {
						mem[i][j] = mem[i][j-1];
					}else {
						mem[i][j] = false;
					}
				}else if(j == 0 ) {
					mem[i][j] = false;
				}else if(string.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
					mem[i][j] = mem[i-1][j-1];
				}else if(pattern.charAt(j) == '*'){
					mem[i][j] = mem[i][j-1]|mem[i-1][j]|mem[i-1][j-1];
				}else {
					mem[i][j] = false;
				}
			}
		}
		for(int i=0; i<m; i++) {
			System.out.print(pattern.charAt(i)+"      ");
		}
		System.out.println();
		for(int i=0; i<n; i++) {
			System.out.println(Arrays.toString(mem[i]));
		}
		return mem[n-1][m-1];
	}

}
