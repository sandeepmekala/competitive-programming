package edu.algos.li20_dp1;

import java.util.Arrays;

public class LoopUntil_A02_LongestBitonicSubsequence {

	public static void main(String[] args) {
		int[] input = new int[] { 2, -1, 4, 3, 5, -1, 3, 2 };
		System.out.println(lbsBottomUp(input, input.length));
	}
	/*	Idea: Build lis arrays from left to right and right to left and sum them
	 *	0	1	2	3	4	5	6	7
	 *	1	1	2	2	3	1	2	2 
	 * 	2	1	3	2	3	1	2	1
	 * 
	 * 	2	1	4	3	5	1	3	2
	 * */
	private static int lbsBottomUp(int[] input, int n) {
		int max = 0;
		int[] lrLis = new int[n];
		int[] rlLis = new int[n];
		
		Arrays.fill(lrLis, 1);
		Arrays.fill(rlLis, 1);
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(input[j] < input[i]) {
					lrLis[i] = Math.max(lrLis[i], lrLis[j]+1);
				}
			}
		}
		for(int i=n-2; i>=0; i--) {
			for(int j=n-1; j>i; j--) {
				if(input[j] < input[i]) { 
					rlLis[i] = Math.max(rlLis[i], rlLis[j]+1);
				}
			}
		}
		for(int i=0; i<n; i++) {
			max = Math.max(max, lrLis[i]+rlLis[i]-1);
		}
		return max;
	}

}
