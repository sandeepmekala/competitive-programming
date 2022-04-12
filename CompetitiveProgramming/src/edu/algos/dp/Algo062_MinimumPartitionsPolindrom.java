package edu.algos.dp;

public class Algo062_MinimumPartitionsPolindrom {

	public static void main(String[] args) {
		String str = "abcbm";
		System.out.println(minPartitions(str, str.length()));
		
	}

	/*
	 * concept: same like finding longest polindrome. start l=0,....n
	 * check if str[i:j] is polindrome, if not check for every position (k) in the str[i:j] and take the min if that position gives min partition.
	 * 
	 * */
	private static int minPartitions(String str, int n) {
		int[][] mem = new int[n][n];
		for(int l=0; l<n; l++) {
			for(int i=0; i<n-l; i++) {
				int j = i+l;
				System.out.println(l+"=>"+i+":"+j);
				if(isPolindrome(str,i,j)) {
					mem[i][j] = 0;
				}else {
					int min = Integer.MAX_VALUE;
					for(int k=i; k<j; k++) {
						min = Math.min(min, 1+mem[i][k]+mem[k+1][j]);
					}
					mem[i][j] = min;
				}
			}
			System.out.println();
		}
		return mem[0][n-1];
	}

	private static boolean isPolindrome(String str, int i, int j) {
		while(i<j) {
			if(str.charAt(i++) != str.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

}
