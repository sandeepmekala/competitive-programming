	package edu.algos.li21.dp2;

public class Dp08LongestCommonSubsequence {
	
	private static int mid_results[][] = new int[4][5];
	public static void main(String[] args) {
		Dp08LongestCommonSubsequence obj = new Dp08LongestCommonSubsequence();

		System.out.println(obj.lcsBottomUp("BATD", "ABACD", 4, 5));
		System.out.println(obj.lcsTopDown("BATD", "ABACD", 4, 5));
		System.out.println(obj.lcsRec("BATD", "ABACD", 4, 5));
	}
	
	/*
	 * 	i\j	A	B	A	C	D	
	 * 	B	0	1	1	1	1
	 * 	A	1	1	2	2	2
	 * 	T	1	1	2	2	2
	 * 	D	1	1	2	2	3
	 * 
	 * */
	// concept: if char match, add 1 and check for the rest of the substrings excluding that char
	// else, take the max of exclusion of the char1 in str1 and exclusion of char2 in str2
	// m and n defines the state
	// time: O(m*n) where m=len(str1) amd n=len(str2);
	private int lcsBottomUp(String str1, String str2, int m, int n) {
		int mem[][] = new int[m][n];
		for(int i=0; i<str1.length(); i++) {
			for(int j=0; j<str2.length(); j++) {
				if(str1.charAt(i) == str2.charAt(j)) {		//matching
					if(i == 0 || j == 0) {
						mem[i][j] = 1;
					}else {
						mem[i][j] = 1+mem[i-1][j-1];
					}
				}else {									//not matching
					if(i == 0 && j == 0) {
						mem[i][j] = 0;
					}else if(i == 0 ){
						mem[i][j] = mem[i][j-1];
					}else if(j == 0 ){
						mem[i][j] = mem[i-1][j];
					}else {
						mem[i][j] = Math.max(mem[i-1][j], mem[i][j-1]);
					}
				}
			}
		}
		return mem[m-1][n-1];
	}
	
	private int lcsTopDown(String p, String q, int m, int n){
		
		if(m>0 && n>0 && mid_results[m-1][n-1] != 0){
			return mid_results[m-1][n-1];
		}
		if(m<=0 || n<=0){
			return 0;
		}else if(p.charAt(m-1) == (q.charAt(n-1))){
			return 1 + lcsTopDown(p, q, m-1, n-1);
		}else{
			int temp1 = lcsTopDown(p, q, m-1, n);
			int temp2 = lcsTopDown(p, q, m, n-1);
			mid_results[m-1][n-1] = Math.max(temp1, temp2);
			return Math.max(temp1, temp2);
		}
	}
	
	private int lcsRec(String str1, String str2, int m, int n){
		
		if(m<=0 || n<=0){
			return 0;
		}else if(str1.charAt(m-1) == str2.charAt(n-1)){
			return 1 + lcsRec(str1, str2, m-1, n-1);
		}else{
			int temp1 = lcsRec(str1, str2, m-1, n);
			int temp2 = lcsRec(str1, str2, m, n-1);
			return Math.max(temp1, temp2);
		}
	}
}
