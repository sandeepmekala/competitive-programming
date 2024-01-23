package edu.algos.li20_dp;

public class _OneD_Fib_L746_MinCostClimbingStairs {

	public static void main(String[] args) {
		_OneD_Fib_L746_MinCostClimbingStairs obj = new _OneD_Fib_L746_MinCostClimbingStairs();
		
		int[] cost = new int[] {10,15,20};
		System.out.println(obj.minCostClimbingStairs(cost));
	}

	/* Problem: https://leetcode.com/problems/min-cost-climbing-stairs/
	 * Idea: Every position you can reach from -1 or -2 positions by paying the cost of those positions, plus the cost of reaching those positions.
	 * 
	 * T[i] = Min{
	 *		cost(i-1)+T[i-1],
	 *		cost(i-2)+T[i-2]
	 *	}
	 * 
	 * i	0	1	2	3
	 * c	10	15	20	
	 * 		0	0	10	15	
	 * */
	// Time: O(n)
	// Space: O(n)
	public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] table = new int[n+1];
        for(int i=2; i<=n; i++){
            table[i] = Math.min(cost[i-1]+table[i-1], cost[i-2]+table[i-2]);
        }
        
        return table[n];
    }

}
