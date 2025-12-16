
public class Rectangles_L1139_Largest1BorderedSquare {
	public static void main(String[] args) {
		Rectangles_L1139_Largest1BorderedSquare obj = new Rectangles_L1139_Largest1BorderedSquare();
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

		int[][] hor = new int[m][n];	// store horizontal distance of 1's
		int[][] ver = new int[m][n];	// store vertical distance of 1's
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (grid[i][j] == 1) {
					hor[i][j] = (j==0)? 1: hor[i][j-1] + 1;
					ver[i][j] = (i==0)? 1: ver[i-1][j] + 1;
				}
			}
		}

		int max = 0;
		for (int i = m-1; i>=0; i--) {
			for (int j = n-1; j>=0; j--) {
				int sqaureSize = Math.min(hor[i][j], ver[i][j]);  // choose smallest of horizontal and vertical value
				while (sqaureSize > max) {
					// botton left.v && top right.h
					if (ver[i][j-sqaureSize+1] >= sqaureSize &&  hor[i-sqaureSize+1][j] >= sqaureSize)  // check if square exists with 'min' length
						max = sqaureSize;
					sqaureSize--;
				}
			}
		}
		return max*max;
	}
}
