package edu.algos.li17_graph.hard;

public class Dfs_L329_LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		Dfs_L329_LongestIncreasingPathInAMatrix obj = new Dfs_L329_LongestIncreasingPathInAMatrix();

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
				globalMax = Math.max(globalMax, dfs(i, j, matrix, lip));;
			}
		}
		
		return globalMax;
	}

	private int dfs(int i, int j, int[][] matrix, int[][] lip) {
		if(lip[i][j] != 0) {
			return lip[i][j];
		}
		
		int max = 0;
		int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int[] direction : directions) {
			int r = i + direction[0], c = j + direction[1];
			if (isSafe(i, j, r, c, matrix)) {
				int mx = dfs(r, c, matrix, lip);
				max = Math.max(max, mx);
			}
		}
		lip[i][j] = 1 + max;
		return lip[i][j];
	}

	private boolean isSafe(int i, int j, int r, int c, int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		return r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] > matrix[i][j];
	}
}
