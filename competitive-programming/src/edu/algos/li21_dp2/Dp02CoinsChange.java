
package edu.algos.li21_dp2;

public class Dp02CoinsChange {

	public static void main(String[] args) {
		Dp02CoinsChange obj = new Dp02CoinsChange();
		
		int[] coins = new int[]{5,1,6,8};
		int total = 11;
		System.out.println(obj.minimumCoinsForChangeBottomUp(coins, total));
		
		System.out.println(obj.minimumCoinsForChangeTopDown(coins, 3, total));
	}

	/*
	 * Problem: https://leetcode.com/problems/coin-change/
	 * Idea: Same as knapsack problem. Index i and the amount that is remiain will become parameters.
	 * If total becomes 0, then return 0 so that the min can be calculation. Count of actual number already happened with +1.
	 * If total < 0 or index < 0, then return MAX so that it will be excluded at min calculation.
	 * 
	 * T[i][j] = min{	
	 * 		T[i-1][j],
	 * 		1+T[i][j-coins[i]]
	 *  }
	 * 
	 * 
	 * c\t	0	1	2	3	4	5	6	7	8	9	10	11
	 * 1	0	1	2	3	4	5	6	7	8	9	10	11
	 * 5	0	1	2	3	4	1	2	3	4	5	2	3
	 * 6	0	1	2	3	4	1	1	2	3	4	2	3	
	 * 8	0	1	2	3	4	1	2	2	1	2	2	2  
	 * 
	 */
	private int minimumCoinsForChangeBottomUp(int[] coins, int total) {
		int n = coins.length;
		int[][] mem = new int[n][total+1];
		for(int i=0; i<coins.length; i++) {
			for(int j=1; j<=total; j++) {
				if(i==0) {  
				    if(j%coins[i] == 0){			//if only one coin and it can change the total	
				        mem[i][j] = j/coins[i];    
				    }else {
				    	mem[i][j] = Integer.MAX_VALUE;
				    }
				} else if(coins[i] > j) {
					mem[i][j] = mem[i-1][j];
				} else {
					int min1 = mem[i-1][j];
					int min2 = mem[i][j-coins[i]];		//mem[i]...  means we can select same coin again
					if(min2 != Integer.MAX_VALUE) {
						min2 = 1+min2;
					}
					mem[i][j] = Math.min(min1, min2);		
				}	
			}
		}
		
		if(mem[n-1][total] == Integer.MAX_VALUE){
            return -1;
        }
		return mem[n-1][total];
	}
	
	private int minimumCoinsForChangeTopDown(int[] coins, int index, int total) {
		
		if(total == 0) {
			return 0;
		}
		if(index < 0 || total < 0 ) {
			return Integer.MAX_VALUE;
		}
		if(coins[index] > total) {
			return minimumCoinsForChangeTopDown(coins, index-1, total);
		}else {
			int min1 = minimumCoinsForChangeTopDown(coins, index-1, total);
			int min2 = minimumCoinsForChangeTopDown(coins, index, total-coins[index]);
			if(min2 != Integer.MAX_VALUE) {
				min2 = 1+min2;
			}
			return Math.min(min1, min2);
		}
	}
}
