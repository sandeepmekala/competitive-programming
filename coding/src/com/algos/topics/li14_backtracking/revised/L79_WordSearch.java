package  com.algos.topics.li14_backtracking.revised;

public class L79_WordSearch {

	public static void main(String[] args) {
		L79_WordSearch obj = new L79_WordSearch();
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

		boolean[][] vis = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (exist(board, word, i, j, 0, vis)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean exist(char[][] board, String word, int row, int col, int ind, boolean[][] vis) {
		if (ind == word.length())
			return true;

		if (!isSafe(board, word, row, col, ind, vis))
			return false;

		vis[row][col] = true;

		int[][] dirs = new int[][]{{0,-1}, {-1,0}, {0,1}, {1,0}};
		for(int[] dir: dirs){
			int nrow = row+dir[0], ncol = col+dir[1];
			if (exist(board, word, nrow, ncol, ind + 1, vis))
				return true;
		}

		vis[row][col] = false;		// backtrack
		return false;
	}

	private boolean isSafe(char[][] board, String word, int i, int j, int ind, boolean[][] visited) {
		return i >= 0 && j >= 0 && i < board.length && j < board[i].length
				&& !visited[i][j] && word.charAt(ind) == board[i][j];
	}
}
