package edu.algos.li20_dp;

public class _Stocks_L121_BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		_Stocks_L121_BestTimeToBuyAndSellStock obj = new _Stocks_L121_BestTimeToBuyAndSellStock();
		
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
	// Time: O(n)
    // Space: O(1)
	public int maxProfit(int[] prices) {
        int minPrice = prices[0], n = prices.length;
        int profit = 0;
        for(int i=1; i<n; i++) {
			int cost = prices[i]-minPrice;
        	profit = Math.max(profit, cost);
        	
        	minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }

}
