package edu.algos.li03.hashing;

import java.util.Arrays;
import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {
		ValidSudoku obj = new ValidSudoku();
		String[][] suduko = new String[][] 
				{{"8","3",".",".","7",".",".",".","."}
				,{"6",".",".","1","9","5",".",".","."}
				,{".","9","8",".",".",".",".","6","."}
				,{"8",".",".",".","6",".",".",".","3"}
				,{"4",".",".","8",".","3",".",".","1"}
				,{"7",".",".",".","2",".",".",".","6"}
				,{".","6",".",".",".",".","2","8","."}
				,{".",".",".","4","1","9",".",".","5"}
				,{".",".",".",".","8",".",".","7","9"}};
		System.out.println(obj.isValidSudoku(suduko));
	}

	public boolean isValidSudoku(String[][] board) {

		for (int i = 0; i < board.length; i++) {
			HashSet<String> set = new HashSet<String>();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != ".") {
					if (set.contains(board[i][j])) {
						return false;
					}
					set.add(board[i][j]);
				}
			}
		}

		for (int j = 0; j < board.length; j++) {
			HashSet<String> set = new HashSet<String>();
			for (int i = 0; i < board[j].length; i++) {
				if(board[i][j] != "." ) {
					if (set.contains(board[i][j])) {
						return false;
					}
					set.add(board[i][j]);
				}
			}
		}
		
		HashSet<String>[][] set = new HashSet[3][3];
		for(int i=0; i<set.length; i++) {
			for(int j=0; j<set[i].length; j++) {
				set[i][j] = new HashSet<String>();
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] != "." ) {
					if (set[i/3][j/3].contains(board[i][j])) {
						return false;
					}
					set[i/3][j/3].add(board[i][j]);
				}
			}
		}
		
		return true;
	}
}
