package  com.algos.topics.li15_dp;

public class Partitions_A05_OptimalCostBinarySearchTree {

	public static void main(String[] args) {
		Partitions_A05_OptimalCostBinarySearchTree obj = new Partitions_A05_OptimalCostBinarySearchTree();

		int[] items = new int[] {10,12,16,21};
		int[] costs = new int[] {4,2,6,3};
		int n = items.length;
		System.out.println(obj.optimalCost(items, costs, n));
	}

	/* Problem: Build bst in such a way that total search cost should be minimal. Root cost will be multiple of level in bottom up order.
	 * Idea: Find the
	 *
	 * i\j	10	12	16	21
	 * 10	4	8	20	26
	 * 12		2 	10	16
	 * 16			6	12
	 * 21				3
	 *
	 * */
	public int optimalCost(int[] items, int[] costs, int n) {
		int mem[][] = new int[n][n];
		for(int l=0; l<n; l++) {
			for(int i=0; i<n-l; i++) {
				int j = i+l;
				if(i == j) {
					mem[i][j] = costs[i];
					continue;
				}

				int sum = 0;
				for(int k=i; k<=j; k++) {
					sum += costs[k];
				}
				int min = Integer.MAX_VALUE;
				for(int k=i; k<=j; k++) {	// every k between i and j becomes root and min cost
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
		return mem[0][n-1];
	}

}
