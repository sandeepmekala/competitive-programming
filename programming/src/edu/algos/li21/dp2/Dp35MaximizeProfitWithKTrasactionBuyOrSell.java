package edu.algos.li21.dp2;

public class Dp35MaximizeProfitWithKTrasactionBuyOrSell {

	public static void main(String[] args) {
		Dp35MaximizeProfitWithKTrasactionBuyOrSell obj = new Dp35MaximizeProfitWithKTrasactionBuyOrSell();
		int[] prices = new int[] {2,5,7,1,4,3,1,3};
		int k=3;
		
		System.out.println(obj.maxProfit(k, prices));
	}

	/*	
	 * 	T[k][i] = Max {	T[k][i-1] 
	 * 					(price(i)-price(j))+T[k-1][j]		j=0,1,....i-1		
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
	private int maxProfit( int K, int[] prices) {
		int n = prices.length;
		int mem[][] = new int[K+1][n];
		for(int k=0; k<=K; k++) {
			for(int i=0; i<n; i++) {
				if(k == 0 || i == 0) {
					mem[k][i] = 0;
				}else {
					int max = Integer.MIN_VALUE;
					for(int j=0; j<i; j++) {
						max = Math.max(max, (prices[i]-prices[j])+mem[k-1][j]);
					}
					mem[k][i] = Math.max(max, mem[k][i-1]);
				}
			}
		}
		return mem[K][n-1];
	}

}
