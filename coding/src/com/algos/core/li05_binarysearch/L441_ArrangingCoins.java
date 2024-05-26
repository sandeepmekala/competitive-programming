package  com.algos.core.li05_binarysearch;

public class L441_ArrangingCoins {

	public static void main(String[] args) {
		L441_ArrangingCoins obj = new L441_ArrangingCoins();
		
		System.out.println(obj.arrangeCoins(8));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/arranging-coins/
	 * Companies: Amazon, Facebook
     * Idea: To complete n rows fully, you need n*(n+1)/2 coins. Use these number of coins as reference to compare available coints.
     * 
	 * */
	public int arrangeCoins(int n) {    
        long l=1, r=n;
        int res = 1;
        while(l<=r){
            long mid = l+(r-l)/2;
            long coins = mid*(mid+1)/2;
            if(coins <= n){
                res = (int)mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
               
        return res;
    }

}
