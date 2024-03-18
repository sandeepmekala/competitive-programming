package  com.algos.li14_backtracking.revised;

import java.util.Arrays;

public class KnightsTour {
	static int n = 8;

	public static void main(String args[]) {
		KnightsTour obj = new KnightsTour();
		obj.solveKT();
	}

	// Problem: With the xMove and yMove moves can we explore all the cells?
	// Idea: explore all moves in parallel, if any move reaches N*N, return true, else return false
	// If any of the recursion returns true, return true to above.	
	// prepare N*N empty solution matrix and pass it to recursive call which update the respective move numbers in solution matrix. if no solution exits, it will backtrack.
	// Time: O(8^n*n) as we start 8 moves in parallel. Each recursion checks for 8 positions. It will be tree with 8 children and 8 depth.
	// Space: O(n^2) where n is number of moves
	private boolean solveKT() {
		int[][] vis = new int[8][8];

		for (int row = 0; row < n; row++)
			Arrays.fill(vis[row], -1);

		int dr[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int dc[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		vis[0][0] = 0;
		if (solveKT(0, 0, 1, vis, dr, dc) == false) {
			System.out.println("Solution does not exist");
			return false;
		} else{
			printSolution(vis);
		}

		return true;
	}

	private boolean solveKT(int row, int col, int move, int vis[][], int dr[], int dc[]) {
		if (move == n * n)
			return true;
			
		for (int i = 0; i < 8; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];
			if (isSafe(nrow, ncol, vis)) {
				vis[nrow][ncol] = move;
				if (solveKT(nrow, ncol, move + 1, vis, dr, dc))
					return true;
			
				vis[nrow][ncol] = -1; // backtracking
			}
		}

		return false;
	}
	
	private boolean isSafe(int nrow, int ncol, int visited[][]) {
		return nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && visited[nrow][ncol] == -1;
	}

	private void printSolution(int sol[][]) {
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++)
				System.out.print(sol[x][y] + " ");
			System.out.println();
		}
	}
}
