package edu.algos.graph.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class G03PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		G03PacificAtlanticWaterFlow obj = new G03PacificAtlanticWaterFlow();
		int[][] heights = new int[][]{
			{1,2,2,3,5},
			{3,2,3,4,4},
			{2,4,5,3,1},
			{6,7,1,4,5},
			{5,1,1,2,4}};
		System.out.println(obj.pacificAtlantic(heights));
	}

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		boolean[][] pvisited = new boolean[m][n];
		boolean[][] avisited = new boolean[m][n];
		boolean[][] po = new boolean[m][n];
		boolean[][] ao = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			dfs(heights, i, 0, heights[i][0], po, pvisited);
			dfs(heights, i, n-1, heights[i][n-1], ao, avisited);
		}
		
		
		for (int j = 0; j < n; j++) {
			dfs(heights, 0, j, heights[0][j], po, pvisited);
			dfs(heights, m-1, j, heights[m-1][j], ao, avisited);
		}

		List<List<Integer>> result = new ArrayList<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(po[i][j] && ao[i][j]) {
					result.add(new ArrayList<Integer>(Arrays.asList(i,j)));
				}
			}
		}
		return result;
	}

	private void dfs(int[][] heights, int i, int j, int prevHeight, boolean[][] ocean, boolean[][] visited) {
		if (isSafe(heights, i, j, prevHeight, ocean, visited)) {
			visited[i][j] = true;
			ocean[i][j] = true;

			dfs(heights, i + 1, j, heights[i][j], ocean, visited);
			dfs(heights, i - 1, j, heights[i][j], ocean, visited);
			dfs(heights, i, j + 1, heights[i][j], ocean, visited);
			dfs(heights, i, j - 1, heights[i][j], ocean, visited);
		}
	}

	private boolean isSafe(int[][] heights, int i, int j, int prevHeight, boolean[][] ocean, boolean[][] visited) {
		int m = heights.length;
		int n = heights[0].length;

		if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && heights[i][j] >= prevHeight) {
			return true;
		}
		return false;
	}
}
