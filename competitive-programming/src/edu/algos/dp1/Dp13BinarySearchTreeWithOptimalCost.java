package edu.algos.dp1;

public class Dp13BinarySearchTreeWithOptimalCost {

	public static void main(String[] args) {
		int[] items = new int[] {10,12,16,21};
		int[] costs = new int[] {4,2,6,3};
		int n = items.length;
		System.out.println(optimalCost(items, costs, n));
	}

	/* Problem: Build bst in such a way that total search cost should be minimal
	 * Concept: Find the 
	 * 
	 * i\j	10	12	16	21
	 * 10	4	8	20	26
	 * 12		2 	10	16
	 * 16			6	12
	 * 21				3
	 * 
	 * */
	private static int optimalCost(int[] items, int[] costs, int n) {
		int mem[][] = new int[n][n];
		for(int l=0; l<n; l++) {
			for(int i=0; i<n-l; i++) {
				int j = i+l;
				if(i == j) {
					mem[i][j] = costs[i];
				}else {
					int sum = 0;
					for(int k=i; k<=j; k++) {
						sum += costs[k];
					}
					int min = Integer.MAX_VALUE;
					for(int k=i; k<=j; k++) {
						int temp = 0;
						if(k-1 >= i) {
							temp += mem[i][k-1];
						}
						if(k+1 <= j) {
							temp += mem[k+1][j];
						}
						if(temp < min) {
							min = temp;
						}
					}
					mem[i][j] = sum+min;
				}
			}
		}
		return mem[0][n-1];
	}

}
