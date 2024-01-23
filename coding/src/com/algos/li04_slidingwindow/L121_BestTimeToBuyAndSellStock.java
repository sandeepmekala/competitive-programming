package  com.algos.li04_slidingwindow;

public class L121_BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		L121_BestTimeToBuyAndSellStock obj = new L121_BestTimeToBuyAndSellStock();
		
		System.out.println(obj.maxProfit(new int[] {7,1,5,3,6,4}));
	}
	
    // Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    // Idea: if right side price is more then find profit and track max.
	public int maxProfit(int[] prices) {
        int l = 0, r = 1, profit = 0;
        while(r < prices.length){
            if(prices[r] >= prices[l]){
                profit = Math.max(profit, prices[r]-prices[l]);
                r++;
            }else{
                l++;
            }
        }
        return profit;
    }

}
