package edu.algos.li20.dp1;

import java.util.Arrays;

public class Dp11LongestIncreasingSequence {

	public static void main(String[] args) {
		Dp11LongestIncreasingSequence obj = new Dp11LongestIncreasingSequence();
		int[] input = new int[] { 2, -1, 4, 3, 5, -1, 3, 2 };
			
		int lisLength = obj.lisBottomUp(input);
		System.out.println(lisLength);
	}

	// Concept: Find lis of all the previous elements starting from left to right,	 then find lis of current element
	// current element lis is the max of all the previous elements lis plus 1
	// O(n^2) as it takes another loop to find the max for current element
	private int lisBottomUp(int[] input) {
		int max = 0;
		int n = input.length;
		
		//tabulation array
		int[] lis = new int[n];
		
		//lis for each element is itself
		Arrays.fill(lis, 1);
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(input[j] < input[i]) {
					lis[i] = Math.max(lis[i], lis[j]+1);
				}
			}
			
			//just track max to return
			if(lis[i] > max) {
				max = lis[i];
			}
		}
		return max;
	}
	
}