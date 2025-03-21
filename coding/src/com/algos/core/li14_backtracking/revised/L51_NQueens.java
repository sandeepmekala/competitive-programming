package  com.algos.core.li14_backtracking.revised;

import java.util.ArrayList;
import java.util.List;

public class L51_NQueens {
	public static void main(String args[]) {
		L51_NQueens nqueen = new L51_NQueens();

		System.out.println(nqueen.solveNQueens(4));
	}

	// Problem: https://leetcode.com/problems/n-queens/
	// Idea: For each row, recursively check if col gives solution. Else,
	// Increment col. If none of the cols give solution, increment row.
	// Time: O(n^n) as we start by placing 4 queens in each row and col 0. 
	// Each recursion checks for different col. It will be tree with 4 children
	// Tree depth is col's
	// Space: O(n^2)
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		int[][] board = new int[n][n];
		
		solveNQueens(board, 0, result);		// 0->col
		return result;
	}

	private void solveNQueens(int[][] board, int col, List<List<String>> result) {
		int n = board.length;
		if (col == n)
			saveResult(board, result);

		for (int row = 0; row < n; row++) {
			if (isSafe(board, row, col)) {
				board[row][col] = 1;

				solveNQueens(board, col + 1, result);

				board[row][col] = 0; // backtrack
			}
		}
	}

	private void saveResult(int[][] board, List<List<String>> result) {
		List<String> list = new ArrayList<String>();
		for(int i=0; i<board.length; i++) {
			String row = "";
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j] == 1) {
					row += "Q";
				}else {
					row += ".";
				}
			}
			list.add(row);
		}
		result.add(list);
	}

	// This checks can be optimized to O(1) using hashing
	// Left: n size array hash with entries for each row
	// Top left diagonal: index = (n-1)-(row-col), 2*n-1 size array hash
	// Bottom left diagonal: index = row+col, 2*n-1 size array hash
	boolean isSafe(int[][] board, int row, int col) {
		int i, j, n = board.length;

		// left side
		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		// top-left diagonal
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		// lower-left diagonal
		for (i = row, j = col; j >= 0 && i < n; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}
}
