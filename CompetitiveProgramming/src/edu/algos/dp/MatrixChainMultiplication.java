package edu.algos.dp;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		int dimensions[] = new int[] { 1, 2, 3, 4, 3 };	//(1,2), (2,3), (3,4),....
		int n = dimensions.length;
		System.out.println(minOperationsCountTopDown(dimensions, 1, n-1));
		System.out.println(minOperationsCountBottomUp(dimensions));
	}

	/*
	 * 			(1,2),	(2,3),	(3,4),	(4,3)
	 * i\j	0	1		2		3		4
	 * 	0	0	0		0		0		0				
	 * 	1		0		6		18		30
	 * 	2				0		24		72
	 * 	3						0		36
	 *	4	 							0
	 * */
	private static int minOperationsCountBottomUp(int[] dimensions) {
		int n = dimensions.length;
		int[][] mem = new int[n][n];
		for(int l=2; l<n; l++) {
			for(int i=1; i<n-l+1; i++) {
				int j = i+l-1;
				System.out.println(l+"=>"+i+":"+j);
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
	private static int minOperationsCountTopDown(int[] dimensions, int i, int j) {
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
