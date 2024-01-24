package  com.algos.li19_backtracking;

public class G02_KnightsTour {
	static int n = 8;

	public static void main(String args[]) {
		G02_KnightsTour obj = new G02_KnightsTour();
		obj.solveKT();
	}

	// Problem: With the xMove and yMove moves can we explore all the cells?
	// Idea: explore all moves in parallel, if any move reaches N*N, return true, else return false
	// If any of the recursion returns true, return true to above.	
	// prepare N*N empty solution matrix and pass it to recursive call which update the respective move numbers in solution matrix. if no solution exits, it will backtrack.
	// Time: O(8^n*n) as we start 8 moves in parallel. Each recursion checks for 8 positions. It will be tree with 8 children and 8 depth.
	// Space: O(n^2) where n is number of moves
	private boolean solveKT() {
		int visited[][] = new int[8][8];

		for (int row = 0; row < n; row++)
			for (int col = 0; col < n; col++)
				visited[row][col] = -1;

		int dr[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int dc[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		visited[0][0] = 0;
		if (solveKT(0, 0, 1, visited, dr, dc) == false) {
			System.out.println("Solution does not exist");
			return false;
		} else{
			printSolution(visited);
		}

		return true;
	}

	private boolean solveKT(int row, int col, int move, int visited[][], int dr[], int dc[]) {
		if (move == n * n)
			return true;
			
		for (int i = 0; i < 8; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];
			if (isSafe(nrow, ncol, visited)) {
				visited[nrow][ncol] = move;
				if (solveKT(nrow, ncol, move + 1, visited, dr, dc))
					return true;
				else
					visited[nrow][ncol] = -1; // backtracking
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
