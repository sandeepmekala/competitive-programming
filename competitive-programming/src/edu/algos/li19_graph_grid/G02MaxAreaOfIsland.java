package edu.algos.li19_graph_grid;

import java.util.HashSet;

public class G02MaxAreaOfIsland {

	public static void main(String[] args) {
		G02MaxAreaOfIsland obj = new G02MaxAreaOfIsland();
		int[][] grid = new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, 0 }, };
		System.out.println(obj.maxAreaOfIsland(grid));
	}

	public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int maxArea = 0;
		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int area = dfs(grid, visited, m, n, i, j);
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		return maxArea;
	}

	private int dfs(int[][] grid, HashSet<String> visited, int m, int n, int i, int j) {
		String pos = i + "," + j;
		if (!isSafe(grid, visited, m, n, i, j)) {
			return 0;
		}
		
		visited.add(pos);
		int area = 1;
		area += dfs(grid, visited, m, n, i - 1, j);
		area += dfs(grid, visited, m, n, i + 1, j);
		area += dfs(grid, visited, m, n, i, j - 1);
		area += dfs(grid, visited, m, n, i, j + 1);

		return area;
	}

	private boolean isSafe(int[][] grid, HashSet<String> visited, int m, int n, int i, int j) {
		String pos = i + "," + j;
		if (i >= 0 && i < m && j >= 0 && j < n && !visited.contains(pos) && grid[i][j] == 1) {
			return true;
		}
		return false;
	}
}
