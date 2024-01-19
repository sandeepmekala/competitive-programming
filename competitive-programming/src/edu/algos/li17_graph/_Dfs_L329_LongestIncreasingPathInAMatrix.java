package edu.algos.li17_graph;

public class _Dfs_L329_LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		_Dfs_L329_LongestIncreasingPathInAMatrix obj = new _Dfs_L329_LongestIncreasingPathInAMatrix();

		int[][] matrix = new int[][]{{3,4,5},{3,2,6},{2,2,1}};
		System.out.println(obj.longestIncreasingPath(matrix));
	}

	// Problem: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
	// Idea: Run dfs from each cell in the direction of increasing path.
	// Store the path lens in a lip matrix so that we don't have to compute dfs if it is already done.
	// Path len for a cell is 1+max of all its neighbors. Find it and store it in lip while recursion exiting.
	public int longestIncreasingPath(int[][] matrix) {
		int globalMax = 0, m = matrix.length, n = matrix[0].length;

		int[][] lip = new int[m][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int max = dfs(i, j, matrix, lip);
				if(max > globalMax)
					globalMax = max;
			}
		}
		
		return globalMax;
	}

	private int dfs(int row, int col, int[][] matrix, int[][] lip) {
		if(lip[row][col] != 0) 
			return lip[row][col];
		
		int max = 0;
		int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for (int[] dir : directions) {
			int nrow = row + dir[0], ncol = col + dir[1];
			if (isSafe(row, col, nrow, ncol, matrix)) {
				int mx = dfs(nrow, ncol, matrix, lip);
				max = Math.max(max, mx);
			}
		}
		lip[row][col] = 1 + max;
		return lip[row][col];
	}

	private boolean isSafe(int i, int j, int nrow, int ncol, int[][] matrix) {
		return nrow >= 0 && nrow < matrix.length && ncol >= 0 && ncol < matrix[0].length 
				&& matrix[nrow][ncol] > matrix[i][j];
	}
}
