package edu.algos.li06.binarysearch;

public class ArrangingCoins {

	public static void main(String[] args) {
		ArrangingCoins obj = new ArrangingCoins();
		
		System.out.println(obj.arrangeCoins(10));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/arranging-coins/
	 * Companies: Amazon, Facebook
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
