package edu.algos.li21.dp2;

public class Dp21LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		Dp21LongestIncreasingPathInAMatrix obj = new Dp21LongestIncreasingPathInAMatrix();

		//int[][] matrix = new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		 int[][] matrix = new int[][]{{3,4,5},{3,2,6},{2,2,1}};
		System.out.println(obj.longestIncreasingPath(matrix));
	}

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
				max = Math.max(max, dfs(r, c, matrix, lip));
			}
		}
		lip[i][j] = 1 + max;
		return lip[i][j];
	}

	private boolean isSafe(int i, int j, int r, int c, int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] > matrix[i][j]) {
			return true;
		}
		return false;
	}
}
