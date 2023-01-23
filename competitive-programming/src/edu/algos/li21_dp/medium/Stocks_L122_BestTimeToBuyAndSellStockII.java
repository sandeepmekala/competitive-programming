package edu.algos.li21_dp.medium;

public class Stocks_L122_BestTimeToBuyAndSellStockII {

	public static void main(String[] args) {
		Stocks_L122_BestTimeToBuyAndSellStockII obj = new Stocks_L122_BestTimeToBuyAndSellStockII();

		int[] prices = new int[] {7,1,5,3,6,4};
		System.out.println(obj.maxProfit(prices));

		System.out.println(obj.maxProfit(prices, 0, 1));
	}

	/*
	 * Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	 * Unlimited transaction but one at a time.
	 * Idea: As we have to remember whether we bought previously or not we need to pass extra parameter to recursion.
	 * If we are buying it will contribute -ve to profit as profit = sell - buy. Hence add -ve price if buying.
	 * i/j 	7 1 5 3 6 4
	 * buy 	0 0
	 * sell 0
	 */
	public int maxProfit(int[] prices) {
		int n = prices.length;

		int[][] profits = new int[n+1][2];
		for (int i = n; i >= 0; i--) {
			for (int isBuy = 0; isBuy <= 1; isBuy++) {
				if(i == n){
					profits[i][isBuy] = 0; 	// out of market profit is 0
				}else if (isBuy == 1) { 	// buy
					int buy = -prices[i] + profits[i + 1][0];
					int notBuy = 0 + profits[i + 1][1];
					profits[i][isBuy] = Math.max(buy, notBuy);
				} else {				// sell
					int sell = prices[i] + profits[i + 1][1];
					int notSell = 0 + profits[i + 1][0];
					profits[i][isBuy] = Math.max(sell, notSell);
				}
			}
		}
		return profits[0][1];
	}

	public int maxProfit(int[] prices, int i, int isBuy) {
		int n = prices.length;
		if (i == n)
			return 0; // selling once market close gives 0 price
		if (isBuy == 1) {
			int buy = -prices[i] + maxProfit(prices, i + 1, 0);
			int notBuy = 0 + maxProfit(prices, i + 1, 1);
			return Math.max(buy, notBuy);
		} else {
			int sell = prices[i] + maxProfit(prices, i + 1, 1);
			int notSell = 0 + maxProfit(prices, i + 1, 0);
			return Math.max(sell, notSell);
		}
	}

}
