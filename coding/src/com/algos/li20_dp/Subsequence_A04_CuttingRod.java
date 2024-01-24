package  com.algos.li20_dp;

public class Subsequence_A04_CuttingRod {
	public static void main(String[] args) {
		Subsequence_A04_CuttingRod obj = new Subsequence_A04_CuttingRod();
		int[] lens = new int[]{1,2,3,4};
		int[] profits = new int[] {2,5,7,8};
		int length = 5, n = lens.length;
		System.out.println(obj.cuttingRod(lens, profits, n-1, length));
		System.out.println(obj.cuttingRod2(lens, profits, n-1, length));
	}

	/* Problem: Maximize the profit by cutting rods to specific length rods.
	 * Idea: Same as knapsack.
	 *
	 * 	T[i][j] = max{	
	 * 		T[i-1][j]
	 * 		profit(i)+T[i][j-len[i]]
	 *  }
	 * 	
	 * 
	 * 		i\j	0	1	2	3	4	5
	 * 		0	0	0	0	0	0	0
	 * 	2	1	0	2	4	6	8	10	
	 * 	5	2	0	2	5	7	10	12
	 * 	7	3	0	2	5	7	10	12	
	 *	8	4 	0	2	3	4	10	12
	 * 
	 * */
	// Time: O(n*length)
    // Space: O(n*length)
	public int cuttingRod(int[] lens, int[] profits, int n, int length) {
		int[][] mem = new int[n+1][length+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=length; j++) {
				if(i == 0 || j == 0) {
					mem[i][j] = 0;
				}else{
					int notPick = mem[i-1][j];
					int pick = Integer.MIN_VALUE;
					if(lens[i] <=  j)
						pick = profits[i]+mem[i][j-lens[i]];
					mem[i][j] = Math.max(notPick, pick);
				}
			}
		}
		return mem[n][length];
	}

	private int cuttingRod2(int[] lens, int[] profits, int ind, int length) {
		if(ind == 0) {
			if(length % lens[ind] == 0)
				return (length / lens[0])*profits[0];
			return (int) -1e9;
		}else {
			int notPick = 0 + cuttingRod(lens, profits, ind-1, length);
			int pick = Integer.MIN_VALUE;
			if(lens[ind] <= length)
				pick = profits[ind]+cuttingRod(lens, profits, ind, length-lens[ind]);

			return Math.max(notPick, pick);
		}
	}
}
