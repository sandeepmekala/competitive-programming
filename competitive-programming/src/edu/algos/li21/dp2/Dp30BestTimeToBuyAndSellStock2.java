package edu.algos.li21.dp2;

import java.util.HashMap;

public class Dp30BestTimeToBuyAndSellStock2 {

	public static void main(String[] args) {
		Dp30BestTimeToBuyAndSellStock2 obj = new Dp30BestTimeToBuyAndSellStock2();
		
		//System.out.println(obj.maxProfitBottomUp(new int[] {7,1,5,3,6,4}));
		//System.out.println(obj.maxProfitTopDown(new int[] {7,1,5,3,6,4}));
	}
	
	/*
	 * i/j	7	1	5	3	6	4
	 * buy	0	0	
	 * sell	0
	 * */
//	public int maxProfitBottomUp(int[] prices) {
//        int minPrice = prices[0], n = prices.length;
//        int[][] profits = new int[n][2];
//        for(int i=1; i<n; i++) {
//        	for(int j=0; j<1; j++) {
//        		if(j == 1) {		//buy
//        			profits[i][1] = Math.max(profits[i-1][0], prices[i]-minPrice);
//        		}else {
//        			
//        		}
//        	}
//        }
//        return profits[n-1][1];
//    }

	
}
