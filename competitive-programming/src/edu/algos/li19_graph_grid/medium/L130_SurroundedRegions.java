package edu.algos.li19_graph_grid.medium;

import java.util.Arrays;

public class L130_SurroundedRegions {

	public static void main(String[] args) {
		L130_SurroundedRegions obj = new L130_SurroundedRegions();
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

    // Problem: https://leetcode.com/problems/surrounded-regions/
    // Idea: Just do dfs from all border cells which contains O and change all O to T
    // Then replace all the O->X and T->O
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
                }else if(board[i][j] == 'T'){
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

        return i>=0 && i<m && j>=0 && j<n && board[i][j] == 'O';
    }
}
