package edu.algos.dp;

public class MaximizeProfitWithKTrasactionBuyOrSell {

	public static void main(String[] args) {
		MaximizeProfitWithKTrasactionBuyOrSell obj = new MaximizeProfitWithKTrasactionBuyOrSell();
		int[] prices = new int[] {2,5,7,1,4,3,1,3};
		int k=3;
		
		System.out.println(obj.maxProfit(prices, prices.length, k));
	}

	/*	
	 * 	T[i][j] = Max {	T[i][j-1]
	 * 					(price(j)-price(m))+T[i-1][m]		m=0,1,....j-1		
	 * 				  }	
	 * 	
	 * 	
	 * 		0	1	2	3	4	5	6	7
	 *	t\d	2	5	7	1	4	3	1	3							 
	 * 	0	0	0	0	0	0	0	0	0
	 * 	1	0	3	5	5	5	5	5	5	
	 * 	2	0	3	5	5	8	8	8	8
	 * 	3	0	3	5	5	8	8	8	10	
	 * 
	 * */
	private int maxProfit(int[] prices, int n, int k) {
		int mem[][] = new int[k+1][n];
		for(int i=0; i<=k; i++) {
			for(int j=0; j<n; j++) {
				if(i == 0 || j == 0) {
					mem[i][j] = 0;
				}else {
					int max = Integer.MIN_VALUE;
					for(int m=0; m<j; m++) {
						max = Math.max(max, prices[j]-prices[m]+mem[i-1][m]);
					}
					mem[i][j] = Math.max(max, mem[i][j-1]);
				}
			}
		}
		return mem[k][n-1];
	}

}
