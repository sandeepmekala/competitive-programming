package edu.algos.li02.matrix;

public class BattleshipsInABoard {

	public static void main(String[] args) {
		BattleshipsInABoard obj = new BattleshipsInABoard();
		
		char[][] board = new char[][]{
			{'X','.','.','X'},
			{'.','.','.','X'},
			{'.','.','.','X'}};
			
		System.out.println(obj.countBattleships(board));	
	}
	
	/*
	 * Problem: https://leetcode.com/problems/battleships-in-a-board/
	 * Companies: Amazon
	 * */
	public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if (i == 0 && j == 0) {
                        count++;
                    } else if (i == 0) {
                        if (j > 0 && board[i][j - 1] != 'X')
                            count++;
                    } else if (j == 0) {
                        if (i > 0 && board[i - 1][j] != 'X')
                            count++;
                    } else {
                        if (board[i - 1][j] != 'X' && board[i][j - 1] != 'X')
                            count++;
                    }
                }
            }
        }

        return count;
    }

}
