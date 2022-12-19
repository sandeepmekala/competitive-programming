package edu.algos.li21_dp2;

public class Dp31BestTimeToBuyAndSellStockWithCooldown {

	public static void main(String[] args) {
		Dp31BestTimeToBuyAndSellStockWithCooldown obj = new Dp31BestTimeToBuyAndSellStockWithCooldown();

		int[] prices = new int[] { 1, 2, 3};
		System.out.println(obj.maxProfitTopDown(prices));
	}

	/*
	 * i/state	1	2	3	0	2
	 * buy		0	
	 * sell		0
	 * */
	public int maxProfitTopDown(int[] prices) {
		int[][] mem = new int[prices.length][2];
		return maxProfitTopDown(prices, 0, 1, mem);
	}

	private int maxProfitTopDown(int[] prices, int i, int buy, int[][] mem) {
		int n = prices.length;
		if(i >= n) {
			return 0;
		}
		if(mem[i][buy] != 0) {
			return mem[i][buy];
		}
		
		if(buy == 1) {
			int buyProfit = -prices[i]+maxProfitTopDown(prices, i+1, 0 , mem);
			int coolDownProfit = maxProfitTopDown(prices, i+1, 1, mem);
			mem[i][buy] = Math.max(coolDownProfit, buyProfit);
		}else {
			int sellProfit = prices[i]+maxProfitTopDown(prices, i+2, 1, mem); 
			int coolDownProfit = maxProfitTopDown(prices, i+1, 0, mem);
			mem[i][buy] = Math.max(coolDownProfit, sellProfit);
		}
		return mem[i][buy];
	}	

}
