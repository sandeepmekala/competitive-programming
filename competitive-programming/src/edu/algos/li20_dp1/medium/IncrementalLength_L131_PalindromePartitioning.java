package edu.algos.li20_dp1.medium;

public class IncrementalLength_L131_PalindromePartitioning {

	public static void main(String[] args) {
		IncrementalLength_L131_PalindromePartitioning obj = new IncrementalLength_L131_PalindromePartitioning();
		
		System.out.println(obj.minCut("abcbm"));
	}

	/*
	 * Problem: https://leetcode.com/problems/palindrome-partitioning/
	 * Idea: Same like finding longest polindrome. start l=0,....n
	 * Check if str[i:j] is polindrome, if not, check for every position (k) in the str[i:j] and take the min if that position gives min partition.
	 * 
	 * */
	public int minCut(String s) {
		int n = s.length();		
		int[][] mem = new int[n][n];
		for(int l=0; l<n; l++) {
			for(int i=0; i<n-l; i++) {
				int j = i+l;
				if(isPolindrome(s,i,j)) {
					mem[i][j] = 0;
				}else {
					int min = Integer.MAX_VALUE;
					for(int k=i; k<j; k++) {
						min = Math.min(min, 1+mem[i][k]+mem[k+1][j]);
					}
					mem[i][j] = min;
				}
			}
		}
		return mem[0][n-1];
	}

	private boolean isPolindrome(String str, int i, int j) {
		while(i<j) {
			if(str.charAt(i++) != str.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

}
