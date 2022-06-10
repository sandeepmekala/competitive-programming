package edu.algos.slidingwindow;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
		
		System.out.println(obj.maxProfit(new int[] {7,1,5,3,6,4}));
	}
	
	public int maxProfit(int[] prices) {
        int low = 0;
        int high = 1;
        int profit = 0;
        while(high<=prices.length-1){
            if(prices[high] < prices[low]){
                low++;
            }else{
                profit = Math.max(profit, prices[high]-prices[low]);
                high++;
            }
        }
        return profit;
    }

}
