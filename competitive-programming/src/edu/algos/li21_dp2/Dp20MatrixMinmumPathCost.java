package edu.algos.li21_dp2;

public class Dp20MatrixMinmumPathCost {

	public static void main(String[] args) {
		Dp20MatrixMinmumPathCost obj = new Dp20MatrixMinmumPathCost();
		
		int[][] costs = new int[][] {
			{1,3,5,8},
			{4,2,1,7},
			{4,3,2,3}
		};
		System.out.println(obj.minmumCost(costs, costs.length, costs[0].length));
	}

	/*
	 * Problem: find the min cost path from [0, 0] to [n, n]
	 * Idea: Use DP as the sum to current position can be defined as sum to previous positions and cost to travel to current position
	 * 
	 * i\j	0	1	2	3	
	 * 	0	1	4	9	17
	 * 	1	5	6	7	14
	 * 	2	9	9	9	12
	 * 
	 * */
	private int minmumCost(int[][] costs, int m, int n) {
		int mem[][] = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i == 0 && j == 0) {
					mem[i][j] = costs[i][j];
				}else if(i == 0){
					mem[i][j] = mem[i][j-1]+costs[i][j];
				}else if(j == 0){
					mem[i][j] = mem[i-1][j]+costs[i][j];
				}else {
					mem[i][j] = costs[i][j] + Math.min(mem[i-1][j], mem[i][j-1]);
				}
			}
		}
		return mem[m-1][n-1];
	}

}
