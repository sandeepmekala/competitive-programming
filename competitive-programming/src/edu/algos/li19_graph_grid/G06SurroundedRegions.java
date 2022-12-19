package edu.algos.li19_graph_grid;

import java.util.Arrays;

public class G06SurroundedRegions {

	public static void main(String[] args) {
		G06SurroundedRegions obj = new G06SurroundedRegions();
		char[][] board = new char[][] {
			{'X','X','X','X'},
			{'X','O','O','X'},
			{'X','X','O','X'},
			{'X','O','X','X'}};
		obj.solve(board);
		for(char[] row: board) {
			System.out.println(Arrays.toString(row));
		}
	}

	public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        for(int j=0; j<n; j++){
            dfs(board, 0, j);
            dfs(board, m-1, j);
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    private void dfs(char[][] board, int i, int j){
        if(isSafe(board, i, j)){
            board[i][j] = 'T';
            int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
            for(int[] direction: directions){
                int r = i+direction[0];
                int c = j+direction[1];
                if(isSafe(board, r, c)){
                    dfs(board, r, c);                    
                }
            }
        }
    }
    
    private boolean isSafe(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        if(i>=0 && i<m && j>=0 && j<n && board[i][j] == 'O'){
            return true;
        }
        return false;
    }
}
