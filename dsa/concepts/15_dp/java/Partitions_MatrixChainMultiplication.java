
public class Partitions_MatrixChainMultiplication {

	public static void main(String[] args) {
		Partitions_MatrixChainMultiplication obj = new Partitions_MatrixChainMultiplication();

		int[] dimensions = new int[] { 1, 2, 3, 4, 3 };	//(1,2), (2,3), (3,4),....
		int n = dimensions.length;
		System.out.println(obj.operations(dimensions));
		System.out.println(obj.operations2(dimensions, 1, n-1));
		System.out.println(obj.operations3(dimensions));
	}

	//  Problem: Minimum operations to multiple given matrices
	//  Idea: Similar like palindrome partitioning. Check the cost for every position from i to j and take the min.
	//
	//  			(1,2),	(2,3),	(3,4),	(4,3)
	//  i\j	0	1		2		3		4
	//  	0	0	0		0		0		0
	//  	1		0		6		18		30
	//  	2				0		24		72
	//  	3						0		36
	// 	4	 							0
	//
	//
	//  Time: O(n^3)
	//  Similar problem DP 52. Evaluate Boolean Expression to True
	public int operations(int[] dim) {
		int n = dim.length;
		int[][] ops = new int[n][n];
		for(int i=n-1; i>0; i--) {
			for(int j=0; j<n; j++) {
				if(i>=j) continue;		// As i should be less than j

				ops[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<j; k++) {
					int cnt = ops[i][k]+ops[k+1][j]+dim[i-1]*dim[k]*dim[j];
					if(cnt < ops[i][j])
						ops[i][j] = cnt;
				}
			}
		}
		return ops[1][n-1];
	}

	// O(n^3)
	private int operations2(int[] dim, int i, int j) {
		if (i == j)
			return 0;

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int cnt = operations2(dim, i, k) + operations2(dim, k + 1, j)
					+ dim[i - 1] * dim[k] * dim[j];
			if (cnt < min)
				min = cnt;
		}
		return min;
	}

	// Alternative way to solve the problem
	// l keeps the length of the chain
	public int operations3(int[] dimensions) {
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
}
