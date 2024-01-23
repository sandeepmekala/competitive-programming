package edu.algos.li20_dp;

public class _Partitions_L131_PalindromePartitioningII {

	public static void main(String[] args) {
		_Partitions_L131_PalindromePartitioningII obj = new _Partitions_L131_PalindromePartitioningII();
		
		String str = "BABABCBADCEDE";
		
		System.out.println(obj.minCut(str));
		System.out.println(obj.minCut(str));
	}

	//Problem: https://leetcode.com/problems/palindrome-partitioning-ii/
	public int minCut(String str) {
		int n = str.length();
		int[] dp = new int[n + 1];
		dp[n] = 0;
		for (int i = n - 1; i >= 0; i--) {
			int minCost = Integer.MAX_VALUE;
			//String[i...j]
			for (int j = i; j < n; j++) {
				if (isPalindrome(str, i, j)) {
					int cost = 1 + dp[j + 1];
					minCost = Math.min(minCost, cost);
				}
			}
			dp[i] = minCost;
		}
		return dp[0] - 1;
	}

	public int minCut2(String str) {
		int n = str.length();
		return minCut2(0, n, str) - 1;
	}

	private int minCut2(int i, int n, String str) {
		//Base case:
		if (i == n) return 0;
	
		int minCost = Integer.MAX_VALUE;
		//String[i...j]
		for (int j = i; j < n; j++) {
			if (isPalindrome(str, i, j)) {
				int cost = 1 + minCut2(j + 1, n, str);
				minCost = Math.min(minCost, cost);
			}
		}
		return minCost;
	}


	// Idea: Same like finding longest polindrome. start l=0,....n
	// Check if str[i:j] is polindrome, if not, check for every position (k) in the str[i:j] and take the min if that position gives min partition. 
	public int minCut3(String s) {
		int n = s.length();		
		int[][] mem = new int[n][n];
		for(int l=0; l<n; l++) {
			for(int i=0; i<n-l; i++) {
				int j = i+l;
				if(isPalindrome(s,i,j)) {
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

	private boolean isPalindrome(String str, int i, int j) {
		while(i<j) {
			if(str.charAt(i++) != str.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

}
