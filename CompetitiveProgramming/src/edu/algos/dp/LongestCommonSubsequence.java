package edu.algos.dp;

public class LongestCommonSubsequence {
	
	private static int mid_results[][] = new int[4][5];
	public static void main(String[] args) {

		System.out.println(lcsTopDown("BATD", "ABACD", 4, 5));
		System.out.println(lcsRec("BATD", "ABACD", 4, 5));
	}
	
	// m and n defines the state
	// O(m*n) where m=len(str1) amd n=len(str2);
	private static int lcsTopDown(String p, String q, int m, int n){
		
		if(m>0 && n>0 && mid_results[m-1][n-1] != 0){
			return mid_results[m-1][n-1];
		}
		if(m<=0 || n<=0){
			return 0;
		}else if(p.substring(m-1).equals(q.substring(n-1))){
			return 1 + lcsTopDown(p.substring(0, m-1), q.substring(0, n-1), m-1, n-1);
		}else{
			int temp1 = lcsTopDown(p.substring(0, m-1), q, m-1, n);
			int temp2 = lcsTopDown(p, q.substring(0, n-1), m, n-1);
			mid_results[m-1][n-1] = Math.max(temp1, temp2);
			return Math.max(temp1, temp2);
		}
	}
	
	private static int lcsRec(String str1, String str2, int m, int n){
		
		if(m<=0 || n<=0){
			return 0;
		}else if(str1.substring(m-1).equals(str2.substring(n-1))){
			return 1 + lcsTopDown(str1.substring(0, m-1), str2.substring(0, n-1), m-1, n-1);
		}else{
			int temp1 = lcsTopDown(str1.substring(0, m-1), str2, m-1, n);
			int temp2 = lcsTopDown(str1, str2.substring(0, n-1), m, n-1);
			return Math.max(temp1, temp2);
		}
	}

}
