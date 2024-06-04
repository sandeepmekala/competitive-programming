package  com.algos.core.li15_dp.revised;

public class Grid_L329_LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		Grid_L329_LongestIncreasingPathInAMatrix obj = new Grid_L329_LongestIncreasingPathInAMatrix();

		int[][] matrix = new int[][]{{3,4,5},{3,2,6},{2,2,1}};
		System.out.println(obj.longestIncreasingPath(matrix));
	}

	// Problem: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
	// Idea: Run dfs from each cell in the direction of increasing path.
	// Store the path lens in a lip matrix so that we don't have to compute dfs if it is already done.
	// Path len for a cell is 1+max of all its neighbors. Find it and store it in lip while recursion exiting.
	public int longestIncreasingPath(int[][] matrix) {
		int globalMax = 0, m = matrix.length, n = matrix[0].length;

		int[][] dp = new int[m][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int max = dfs(i, j, matrix, dp);
				if(max > globalMax)
					globalMax = max;
			}
		}
		
		return globalMax;
	}

	private int dfs(int i, int j, int[][] matrix, int[][] dp) {
		if(dp[i][j] != 0) 
			return dp[i][j];
		
		int max = 0;
		int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for (int[] dir : dirs) {
			int ni = i + dir[0], nj = j + dir[1];
			if (isSafe(i, j, ni, nj, matrix)) {
				int mx = dfs(ni, nj, matrix, dp);
				max = Math.max(max, mx);
			}
		}
		dp[i][j] = 1 + max;
		return dp[i][j];
	}

	private boolean isSafe(int i, int j, int ni, int nj, int[][] matrix) {
		return ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length 
				&& matrix[ni][nj] > matrix[i][j];
	}
}
