package edu.algos.li17.backtracking;

public class KnightsTour {
	static int N = 8;

	public static void main(String args[]) {
		KnightsTour obj = new KnightsTour();
		obj.solveKT();
	}

	// Question: With the xMove and yMove moves can we explore all the cells?
	// Concept: explore all moves in parallel, if any move reaches N*N, return true, else return false
	// If any of the recursion returns true, return true to above.	
	// prepare N*N empty solution matrix and pass it to recursive call which update the respective move numbers in solution matrix. if no solution exits, it will backtrack.
	// Time complexity: O(8^n) as we with 8 moves in parallel. Each recursion checks for 8 positions. It will be tree with 8 children and 8 depth.
	// Space complexity: O(n^2) where n is number of moves
	private boolean solveKT() {
		int sol[][] = new int[8][8];

		for (int x = 0; x < N; x++)
			for (int y = 0; y < N; y++)
				sol[x][y] = -1;

		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		sol[0][0] = 0;
		if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
			System.out.println("Solution does not exist");
			return false;
		} else
			printSolution(sol);

		return true;
	}

	private boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
		int k, next_x, next_y;
		if (movei == N * N)
			return true;

		/*
		 * Try all next moves from the current coordinate x, y
		 */
		for (k = 0; k < 8; k++) {
			next_x = x + xMove[k];
			next_y = y + yMove[k];
			if (isSafe(next_x, next_y, sol)) {
				sol[next_x][next_y] = movei;
				if (solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove))
					return true;
				else
					sol[next_x][next_y] = -1; // backtracking
			}
		}

		return false;
	}
	
	private boolean isSafe(int x, int y, int sol[][]) {
		return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
	}

	private void printSolution(int sol[][]) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++)
				System.out.print(sol[x][y] + " ");
			System.out.println();
		}
	}
}
