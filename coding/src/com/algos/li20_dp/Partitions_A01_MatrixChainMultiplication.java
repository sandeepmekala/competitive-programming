package  com.algos.li20_dp;

public class Partitions_A01_MatrixChainMultiplication {

	public static void main(String[] args) {
		Partitions_A01_MatrixChainMultiplication obj = new Partitions_A01_MatrixChainMultiplication();
		
		int dimensions[] = new int[] { 1, 2, 3, 4, 3 };	//(1,2), (2,3), (3,4),....
		//int dimensions[] = new int[] { 1, 2, 3};
		int n = dimensions.length;
		System.out.println(obj.operations(dimensions, 1, n-1));
		System.out.println(obj.operations(dimensions));
		System.out.println(obj.operations2(dimensions));
	}

	/*
	 * Problem: Minimum operations to multiple given matrices
	 * Idea: Similar like palindrome partitioning. Check the cost for every position from i to j and take the min.
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
	 * Similar problem DP 52. Evaluate Boolean Expression to True 
	 * 
	 * */
	public int operations(int[] dimensions) {
		int n = dimensions.length;
		int[][] ops = new int[n][n];
		for(int l=1; l<n; l++) {
			for(int i=1; i<n-l; i++) {
				int j = i+l;
				
				ops[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<j; k++) {
					int count = ops[i][k]+ops[k+1][j]+dimensions[i-1]*dimensions[k]*dimensions[j];
					if(count < ops[i][j]) {
						ops[i][j] = count;
					}
				}
			}
		}
		return ops[1][n-1];
	}

	public int operations2(int[] dimensions) {
		int n = dimensions.length;
		int[][] mem = new int[n][n];
		for(int i=n-1; i>0; i--) {
			for(int j=0; j<n; j++) {
				if(i>=j) continue;
				
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
	private int operations(int[] dimensions, int i, int j) {
		if (i == j) 
			return 0;
		
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int count = operations(dimensions, i, k) + operations(dimensions, k + 1, j)
					+ dimensions[i - 1] * dimensions[k] * dimensions[j];
			if (count < min) {
				min = count;
			}
		}
		return min;
	}
}
