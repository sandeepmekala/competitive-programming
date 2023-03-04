package edu.algos.li20_dp.easy;

public class Stocks_L121_BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		Stocks_L121_BestTimeToBuyAndSellStock obj = new Stocks_L121_BestTimeToBuyAndSellStock();
		
		System.out.println(obj.maxProfit(new int[] {7,1,5,3,6,4}));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 * Only one transaction
	 * Idea: Track the min price so far to substract from cur price.
	 *  i/j	7	1	5	3	6	4
	 * 		0	0	4	4	5	5
	 * 
	 * */
	public int maxProfit(int[] prices) {
        int minPrice = (int)1e9, n = prices.length;
        int profit = 0;
        for(int i=1; i<n; i++) {
			int cost = prices[i]-minPrice;
        	profit = Math.max(profit, cost);
        	
        	minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }

}
