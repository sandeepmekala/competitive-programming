package edu.algos.li20_dp.medium;

public class Grid_L62_UniquePaths {

	public static void main(String[] args) {
		Grid_L62_UniquePaths obj = new Grid_L62_UniquePaths();

		int[][] matrix = new int[4][4] ;
		int m = matrix.length, n = matrix[0].length;
		System.out.println(obj.uniquePaths(m, n));
		System.out.println(obj.uniquePaths2(m, n));
	}

	/* 
	 * Problem: https://leetcode.com/problems/unique-paths/
	 * Idea: As there are only 2 directions to move, you can reach any position from the top or left. 
	 * So total ways to reach any position is ways to reach top + ways to reach left
	 * 
	 * i\j	0	1	2	3
	 * 0	1	1	1	1
	 * 1	1	2	3	4
	 * 2	1	3	6	10
	 * 3	1	4	10	20
	 * 
	 * */
	public int uniquePaths(int m, int n) {
		int[][] ways = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i == 0 || j == 0) {
					ways[i][j] = 1;							//base case
				}else {
					ways[i][j] = ways[i-1][j]+ways[i][j-1];
				}
			}
		}
		return ways[m-1][n-1];
	}

	public int uniquePaths2(int i, int j) {
		if(i == 0 && j == 0)
			return 1;
		if(i < 0 || j < 0)
			return 0;
		int up = uniquePaths(i-1, j);
		int left = uniquePaths(i, j-1);
		return up+left;
	}

}
