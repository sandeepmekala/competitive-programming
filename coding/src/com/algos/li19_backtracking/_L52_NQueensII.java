package  com.algos.li19_backtracking;

public class _L52_NQueensII {
	public static void main(String args[]) {
		_L52_NQueensII nqueen = new _L52_NQueensII();

		System.out.println(nqueen.totalNQueens(4));
	}

	// Problem: https://leetcode.com/problems/n-queens-ii/ 
	// Idea: For each row, recursively check if col gives solution. Else,
	// increment col. If none of the cols give solution, increment row.
	// Time complexity: O(n^n) as we start by placing 4 queens in each row and col
	// 0. Each recursion checks for different col. It will be tree with 4 children
	// and col depth.
	// Space complexity: O(n^2)
	public int totalNQueens(int n) {
		int board[][] = new int[n][n];
		
		return totalNQueens(board, 0);
	}

	private int totalNQueens(int board[][], int col) {
		int n = board.length;
		if (col == n) 
			return 1;

		int count = 0;
		for (int row = 0; row < n; row++) {
			if (isSafe(board, row, col)) {
				board[row][col] = 1;

				count += totalNQueens(board, col + 1);

				board[row][col] = 0; // Backtrack
			}
		}
		
		return count;
	}

	boolean isSafe(int board[][], int curRow, int curCol) {
		int i, j, n = board.length;;

		// left side
		for (i = 0; i < curCol; i++)
			if (board[curRow][i] == 1)
				return false;

		// upper-left diagonal
		for (i = curRow, j = curCol; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		// lower-left diagonal
		for (i = curRow, j = curCol; j >= 0 && i < n; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}
}
