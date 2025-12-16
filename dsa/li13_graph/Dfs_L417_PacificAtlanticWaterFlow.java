package li13_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dfs_L417_PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		Dfs_L417_PacificAtlanticWaterFlow obj = new Dfs_L417_PacificAtlanticWaterFlow();
		int[][] heights = new int[][]{
			{1,2,2,3,5},
			{3,2,3,4,4},
			{2,4,5,3,1},
			{6,7,1,4,5},
			{5,1,1,2,4}};
		System.out.println(obj.pacificAtlantic(heights));
	}

	// Problem: https://leetcode.com/problems/pacific-atlantic-water-flow/
	// Idea: Do dfs from 4 border row cells.
	// We need to pass the prev cell heigh as arg to recursion to compare with current cell height.
	// Mark all the reachable cells from pasific and atlantic oceans in respective vis matrices.
	// Take the common cells from both the matrices in result as they can reach both the oceans.
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int m = heights.length, n = heights[0].length;
		boolean[][] pvis = new boolean[m][n];	// marks as the feasible cells from two oceans
		boolean[][] avis = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			if(!pvis[i][0])
			    dfs(heights, i, 0, pvis);	// we need to pass the prev cell heigh as arg to recursion to compare with current cell height
			if(!avis[i][n-1])
			    dfs(heights, i, n-1, avis);
		}

		for (int j = 0; j < n; j++) {
			if(!pvis[0][j])
			    dfs(heights, 0, j, pvis);
			if(!avis[m-1][j])
			    dfs(heights, m-1, j, avis);
		}

		List<List<Integer>> ans = new ArrayList<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(pvis[i][j] && avis[i][j]) {
					ans.add(Arrays.asList(i,j));
				}
			}
		}
		return ans;
	}

	private void dfs(int[][] heights, int row, int col, boolean[][] vis) {
		vis[row][col] = true;
		int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] dir : dirs) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
			if (isSafe(heights, nrow, ncol, heights[row][col], vis)) {
				dfs(heights, nrow, ncol, vis);
			}
		}
	}

	private boolean isSafe(int[][] heights, int i, int j, int prevHeight, boolean[][] visited) {
		int m = heights.length, n = heights[0].length;
		return i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && heights[i][j] >= prevHeight;
	}
}
