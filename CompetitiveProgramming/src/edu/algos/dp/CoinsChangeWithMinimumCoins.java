package edu.algos.dp;

import java.util.Arrays;

public class CoinsChangeWithMinimumCoins {

	public static void main(String[] args) {
		int[] coins = new int[]{1,5,6,8}; //sorted
		int total = 11;
		System.out.println(minimumCoinsForChangeBottomUp(coins, total));
		
		System.out.println(minimumCoinsForChangeTopDown(coins, 3, total));
	}

	/*
	 * c\t	0	1	2	3	4	5	6	7	8	9	10	11
	 * 1	0	1	2	3	4	5	6	7	8	9	10	11
	 * 5	0	1	2	3	4	1	2	3	4	5	2	3
	 * 6	0	1	2	3	4	1	1	2	3	4	2	3	
	 * 8	0	1	2	3	4	1	2	2	1	2	2	2  
	 * 
	 */
	private static int minimumCoinsForChangeBottomUp(int[] coins, int total) {
		int[][] mem = new int[coins.length][total+1];
		for(int i=0; i<coins.length; i++) {
			for(int j=1; j<=total; j++) {
				if(i==0) {  
				    if(j%coins[i] == 0){
				        mem[i][j] = j/coins[i];    
				    }//if only one coin and it can change the total		
				}else {
					mem[i][j] = 1+Math.min(mem[i-1][j], mem[i][valid(j-coins[i])]);
				}	
			}
		}
		return mem[coins.length-1][total];
	}
	
	private static int minimumCoinsForChangeTopDown(int[] coins, int index, int total) {
		
		if(total == 0) {
			return 0;
		}
		if(index < 0 ) {
			return 0;
		}
		if(coins[index] > total) {
			return minimumCoinsForChangeTopDown(coins, index-1, total);
		}else {
			return 1+Math.min(minimumCoinsForChangeTopDown(coins, index-1, total), 
					minimumCoinsForChangeTopDown(coins, index-1, total-coins[index]));
		}
	}
	
	private static int valid(int index) {
		if(index < 0) {
			return 0;
		}else {
			return index;
		}
	}
}
