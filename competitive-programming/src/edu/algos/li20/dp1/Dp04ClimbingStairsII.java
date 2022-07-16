package edu.algos.li20.dp1;

public class Dp04ClimbingStairsII {

	public static void main(String[] args) {
		Dp04ClimbingStairsII obj = new Dp04ClimbingStairsII();
		
		int[] cost = new int[] {10,15,20};
		System.out.println(obj.minCostClimbingStairs(cost));
	}

	/* Problem: From every position, you can go to +1 or +2 by paying that cost. Minimize the cost to reach n+1 position.
	 * Concept: every position you can reach from -1 or -2 positions by paying the cost of those positions, plus the cost of reaching those positions.
	 * 
	 * i	0	1	2	3
	 * c	10	15	20	
	 * 		0	0	10	15	
	 * */
	public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] table = new int[n+1];
        
        for(int i=2; i<n+1; i++){
            table[i] = Math.min(cost[i-1]+table[i-1], cost[i-2]+table[i-2]);
        }
        
        return table[n];
    }

}
