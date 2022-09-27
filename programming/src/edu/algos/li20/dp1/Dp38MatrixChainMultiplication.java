package edu.algos.li20.dp1;

public class Dp38MatrixChainMultiplication {

	public static void main(String[] args) {
		Dp38MatrixChainMultiplication obj = new Dp38MatrixChainMultiplication();
		
		int dimensions[] = new int[] { 1, 2, 3, 4, 3 };	//(1,2), (2,3), (3,4),....
		int n = dimensions.length;
		System.out.println(obj.minOperationsCountTopDown(dimensions, 1, n-1));
		System.out.println(obj.minOperationsCountBottomUp(dimensions));
	}

	/*
	 * Concept: Similar like palindrome partitioning. Place check the cost for every position from i to j and take the min.
	 * 
	 * 			(1,2),	(2,3),	(3,4),	(4,3)
	 * i\j	0	1		2		3		4
	 * 	0	0	0		0		0		0				
	 * 	1		0		6		18		30
	 * 	2				0		24		72
	 * 	3						0		36
	 *	4	 							0
	 *
	 *
	 * time: O(n^3)
	 * 
	 * */
	private int minOperationsCountBottomUp(int[] dimensions) {
		int n = dimensions.length;
		int[][] mem = new int[n][n];
		for(int l=2; l<n; l++) {
			for(int i=1; i<n-l+1; i++) {
				int j = i+l-1;
				mem[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<j; k++) {
					int count = mem[i][k]+mem[k+1][j]+dimensions[i-1]*dimensions[k]*dimensions[j];
					if(count < mem[i][j]) {
						mem[i][j] = count;
					}
				}
			}
		}
		return mem[1][n-1];
	}

	// O(n^3)
	private int minOperationsCountTopDown(int[] dimensions, int i, int j) {
		int min = Integer.MAX_VALUE;

		if (i == j) {
			return 0;
		}
		for (int k = i; k < j; k++) {
			int count = minOperationsCountTopDown(dimensions, i, k) + minOperationsCountTopDown(dimensions, k + 1, j)
					+ dimensions[i - 1] * dimensions[k] * dimensions[j];
			if (count < min) {
				min = count;
			}
		}
		return min;
	}
}