package edu.algos.bit;

import java.util.Arrays;

public class Algo04_CountingBits {

	public static void main(String[] args) {
		Algo04_CountingBits obj = new Algo04_CountingBits();
		System.out.println(Arrays.toString(obj.countBits(3)));
	}
	/*
	 * 	000
	 * 	001
	 * 	010
	 * 	011
	 * 	100
	 * 	101
	 * 	110
	 * 	111
	 * 
	 * */
	public int[] countBits(int n) {
        int[] dp = new int[n+1];
        
        int offset = 1;
        for(int i=0; i<=n; i++){
            if(i <= 1){
                dp[i] = i;    
            }else{
                if(offset*2 == i){
                    offset = i;
                }
                dp[i] = 1 + dp[i-offset];                
            }
        }
        
        return dp;
    }

}
