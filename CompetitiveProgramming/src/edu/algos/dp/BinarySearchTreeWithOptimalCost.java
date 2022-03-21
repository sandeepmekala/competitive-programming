package edu.algos.dp;

public class BinarySearchTreeWithOptimalCost {

	public static void main(String[] args) {
		int[] items = new int[] {10,12,16,21};
		int[] costs = new int[] {4,2,6,3};
		int n = items.length;
		System.out.println(optimalCost(items, costs, n));
	}

	/*
	 * i\j	0	1	2	3
	 * 0	4	8	20	26
	 * 1		2 	10	16
	 * 2			6	12
	 * 3				3
	 * 
	 * */
	private static int optimalCost(int[] items, int[] costs, int n) {
		int mem[][] = new int[n][n];
		for(int l=0; l<n; l++) {
			for(int i=0; i<n-l; i++) {
				int j = i+l;
				System.out.println(l+"=>"+i+":"+j);
				if(i == j) {
					mem[i][j] = costs[i];
				}else {
					int sum = 0;
					for(int k=i; k<=j; k++) {
						sum += costs[k];
					}
					int min = Integer.MAX_VALUE;
					for(int k=i; k<=j; k++) {
						int left = k-1;
						int right = k+1;
						int temp = 0;
						if(left >= i) {
							temp += mem[i][left];
						}
						if(right <= j) {
							temp += mem[right][j];
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
