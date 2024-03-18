package  com.algos.li15_dp.revised;

public class Grid_64_MinimumPathSum {

	public static void main(String[] args) {
		Grid_64_MinimumPathSum obj = new Grid_64_MinimumPathSum();
		
		int[][] grid = new int[][] {
			{1,3,5,8},
			{4,2,1,7},
			{4,3,2,3}
		};
		System.out.println(obj.minPathSum(grid));

		int m=grid.length, n=grid[0].length;
		System.out.println(obj.minPathSum(grid, m-1, n-1));
	}

	/*
	 * Problem: https://leetcode.com/problems/minimum-path-sum/
	 * Idea: Use DP as the sum to current position can be defined as sum to previous positions and cost to travel to current position
	 * 
	 * i\j	0	1	2	3	
	 * 	0	1	4	9	17
	 * 	1	5	6	7	14
	 * 	2	9	9	9	12
	 * 
	 * */
	// Time: O(m*n)
    // Space: O(m*n)
	int INF = Integer.MAX_VALUE;
	public int minPathSum(int[][] grid) {
		int m=grid.length, n=grid[0].length;

		int cost[][] = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i == 0 && j == 0) {
					cost[i][j] = grid[i][j];
				}else {
					int up = INF, left = INF;
                    if(i>0) up = cost[i-1][j];
					if(j>0) left = cost[i][j-1];
					cost[i][j] = grid[i][j] + Math.min(up, left);
				}
			}
		}
		return cost[m-1][n-1];
	}

	public int minPathSum(int[][] grid, int i, int j) {
		if(i==0 && j==0)
			return grid[i][j];
		if(i<0 || j<0)
			return Integer.MAX_VALUE;

		int up = minPathSum(grid, i-1, j);
		int left = minPathSum(grid, i, j-1);
		return grid[i][j]+Math.min(up, left);
	}

}
