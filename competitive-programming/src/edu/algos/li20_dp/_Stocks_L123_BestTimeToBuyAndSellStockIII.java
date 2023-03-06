package edu.algos.li20_dp;

public class _Stocks_L123_BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        _Stocks_L123_BestTimeToBuyAndSellStockIII obj = new _Stocks_L123_BestTimeToBuyAndSellStockIII();

        int[] prices = new int[] {3,3,5,0,0,3,1,4};
		System.out.println(obj.maxProfit(prices));
		System.out.println(obj.maxProfit(prices, 0, 1, 2));
    }

    // Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    // At max 2 transactions
    // Idea: Same as stocksII problem, there is additional dimention of cap is added.
    // Once sell counted as transaction complete. Hence, cap can be reduced for sale transaction.
    // The same can be solved using transaction numbers 0,1,2,3 -> 1buy, 1sell, 2buy, 2sell
    public int maxProfit(int[] prices) {
		int n = prices.length;

		int[][][] profits = new int[n+1][2][3];
		for (int i = n; i >= 0; i--) {
			for (int isBuy = 0; isBuy <= 1; isBuy++) {
				for(int cap = 0; cap<=2; cap++){
                    if(i == n || cap == 0){
                        profits[i][isBuy][cap] = 0; 	// out of market profit is 0
                    }else if (isBuy == 1) { 	// buy
                        int buy = -prices[i] + profits[i + 1][0][cap];
                        int notBuy = 0 + profits[i + 1][1][cap];
                        profits[i][isBuy][cap] = Math.max(buy, notBuy);
                    } else {				// sell
                        int sell = prices[i] + profits[i + 1][1][cap-1];
                        int notSell = 0 + profits[i + 1][0][cap];
                        profits[i][isBuy][cap] = Math.max(sell, notSell);
                    }
                }
			}
		}
		return profits[0][1][2];
	}

	public int maxProfit(int[] prices, int i, int isBuy, int cap) {
		int n = prices.length;
		if (i == n || cap == 0)
			return 0;           // selling once market close and when you are out of transaction, gives sell 0 price
		if (isBuy == 1) {
			int buy = -prices[i] + maxProfit(prices, i + 1, 0, cap);
			int notBuy = 0 + maxProfit(prices, i + 1, 1, cap);
			return Math.max(buy, notBuy);
		} else {
			int sell = prices[i] + maxProfit(prices, i + 1, 1, cap-1);
			int notSell = 0 + maxProfit(prices, i + 1, 0, cap);
			return Math.max(sell, notSell);
		}
	}
}
