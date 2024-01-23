package edu.algos.li20_dp;

public class _Squares_L1139_Largest1BorderedSquare {
	public static void main(String[] args) {
		_Squares_L1139_Largest1BorderedSquare obj = new _Squares_L1139_Largest1BorderedSquare();
		int[][] grid = new int[][] {
			{0,0,0,0,1},
			{1,0,1,1,1},
			{1,0,1,0,1},
			{1,1,1,1,1},
			{0,0,1,1,1}
		};
		//int[][] grid = new int[][]{{1,1,0,0}};
		System.out.println(obj.largest1BorderedSquare(grid));
	}

	/*
	 * Problem: https://leetcode.com/problems/largest-1-bordered-square/
	 * Idea: Store a point in matrix to track the horizontal and vertical distance of 1's that has been seen till now. 
	 * 
	 * */
	public int largest1BorderedSquare(int[][] grid) {
		int m=grid.length, n=grid[0].length;

		int[][] hor = new int[m][n], ver = new int[m][n];
		for (int i=0; i<m; i++) { 
			for (int j=0; j<n; j++) { 
				if (grid[i][j] == 1) { 
					hor[i][j] = (j==0)? 1: hor[i][j-1] + 1;   // auxillary horizontal array
					ver[i][j] = (i==0)? 1: ver[i-1][j] + 1;  // auxillary vertical array
				} 
			} 
		} 
		
		int max = 0;
		for (int i = m-1; i>=0; i--) { 
			for (int j = n-1; j>=0; j--) { 
				int min = Math.min(hor[i][j], ver[i][j]);  // choose smallest of horizontal and vertical value
				while (min > max) { 
					// botton left.v && top right.h
					if (ver[i][j-min+1] >= min &&  hor[i-min+1][j] >= min)  // check if square exists with 'min' length
						max = min;
					min--;
				}
			}
		}
		return max*max; 
	}
}