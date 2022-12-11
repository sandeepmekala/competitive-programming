package edu.algos.li02.matrix.medium;

public class L419_BattleshipsInABoard {

	public static void main(String[] args) {
		L419_BattleshipsInABoard obj = new L419_BattleshipsInABoard();
		
		char[][] board = new char[][]{
			{'X','.','.','X'},
			{'.','.','.','X'},
			{'.','.','.','X'}};
			
		System.out.println(obj.countBattleships(board));	
	}
	
	/*
	 * Problem: https://leetcode.com/problems/battleships-in-a-board/
	 * Companies: Amazon
     * Idea: If a cell doesn't have previous 'X'(horizontally/ventically) then count it as ship. 
	 * */
	public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if(i>0 && board[i - 1][j] == 'X') continue;
                if(j>0 && board[i][j - 1] == 'X') continue;
                
                count++;
            }
        }
        return count;
    }

}
