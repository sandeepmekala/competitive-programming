package edu.algos.li19_backtracking;

public class _L79_WordSearch {

	public static void main(String[] args) {
		_L79_WordSearch obj = new _L79_WordSearch();
		char[][] board = new char[][]{
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}
		};
		String word = "ABCCED";
		System.out.println(obj.exist(board, word));
	}

	// Problem: https://leetcode.com/problems/word-search/
	// Idea: Do dfs on the grid and check the char at index is matching the board grid char.
	// Pass the index of word in the recursion
	// If ind == word len, the return true.
	public boolean exist(char[][] board, String word) {
		int m = board.length, n = board[0].length;

		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (exist(board, word, i, j, 0, visited) == true) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean exist(char[][] board, String word, int row, int col, int ind, boolean[][] visited) {
		if (ind == word.length()) 
			return true;

		if (!isSafe(board, word, row, col, ind, visited)) 
			return false;

		visited[row][col] = true;

		int dr[] = { -1, 0, +1, 0 };
		int dc[] = { 0, -1, 0, +1 };
		for (int i = 0; i < 4; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];
			// check for valid unvisited land neighbour coordinates
			if (exist(board, word, nrow, ncol, ind + 1, visited) == true)
				return true;
		}

		visited[row][col] = false;		// backtrack
		return false;
	}

	private boolean isSafe(char[][] board, String word, int i, int j, int ind, boolean[][] visited) {
		return i >= 0 && j >= 0 && i < board.length && j < board[i].length 
				&& !visited[i][j] && word.charAt(ind) == board[i][j];
	}
}
