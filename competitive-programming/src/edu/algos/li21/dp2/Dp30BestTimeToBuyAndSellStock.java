package edu.algos.li21.dp2;

public class Dp30BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		Dp30BestTimeToBuyAndSellStock obj = new Dp30BestTimeToBuyAndSellStock();
		
		System.out.println(obj.maxProfit(new int[] {7,1,5,3,6,4}));
	}
	
	/*
	 * i/j	7	1	5	3	6	4
	 * 		0	0	4	4	5	5
	 * 
	 * */
	public int maxProfit(int[] prices) {
        int minPrice = prices[0], n = prices.length;
        int[] profits = new int[n];
        for(int i=1; i<n; i++) {
        	profits[i] = Math.max(profits[i-1], prices[i]-minPrice);
        	
        	minPrice = Math.min(minPrice, prices[i]);
        }
        return profits[n-1];
    }

}
