public class Stocks_L714_BestTimeToBuyAndSellStockWithTransactionFee {

	public static void main(String[] args) {
		Stocks_L714_BestTimeToBuyAndSellStockWithTransactionFee obj = new Stocks_L714_BestTimeToBuyAndSellStockWithTransactionFee();

		int[] prices = new int[] {1,3,2,8,4,9};
		System.out.println(obj.maxProfit(prices, 2));

		System.out.println(obj.maxProfit(prices, 2, 0, 1));
	}

	/*
	 * Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
	 * Unlimited transaction but one at a time. Each transaction costs a constant fee.
	 * Idea: As we have to remember whether we bought previously or not we need to pass extra parameter to recursion.
	 * If we are buying it will contribute -ve to profit as profit = sell - buy. Hence add -ve price if buying.
	 * Transaction fee can be substracted when sell/buy happens.
	 * i/j 	7 1 5 3 6 4
	 * buy 	0 0
	 * sell 0
	 */
	// Time: O(n*2)
    // Space: O(n*2)
	public int maxProfit(int[] prices, int fee) {
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
					int sell = prices[i] - fee + profits[i + 1][1];
					int notSell = 0 + profits[i + 1][0];
					profits[i][isBuy] = Math.max(sell, notSell);
				}
			}
		}
		return profits[0][1];
	}

	public int maxProfit(int[] prices, int fee, int ind, int isBuy) {
		int n = prices.length;
		if (ind == n)
			return 0; // selling once market close gives 0 price
		if (isBuy == 1) {
			int buy = -prices[ind] + maxProfit(prices, fee, ind + 1, 0);
			int notBuy = 0 + maxProfit(prices, fee, ind + 1, 1);
			return Math.max(buy, notBuy);
		} else {
			int sell = prices[ind] - fee + maxProfit(prices, fee, ind + 1, 1);
			int notSell = 0 + maxProfit(prices, fee, ind + 1, 0);
			return Math.max(sell, notSell);
		}
	}

}
