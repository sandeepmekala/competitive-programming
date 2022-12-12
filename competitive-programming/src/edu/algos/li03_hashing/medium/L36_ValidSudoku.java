package edu.algos.li03_hashing.medium;

import java.util.HashSet;

public class L36_ValidSudoku {

	public static void main(String[] args) {
		L36_ValidSudoku obj = new L36_ValidSudoku();
		char[][] suduko = new char[][] 
				{{'8','3','.','.','7','.','.','.','.'}
				,{'6','.','.','1','9','5','.','.','.'}
				,{'.','9','8','.','.','.','.','6','.'}
				,{'8','.','.','.','6','.','.','.','3'}
				,{'4','.','.','8','.','3','.','.','1'}
				,{'7','.','.','.','2','.','.','.','6'}
				,{'.','6','.','.','.','.','2','8','.'}
				,{'.','.','.','4','1','9','.','.','5'}
				,{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(obj.isValidSudoku(suduko));
	}

	// Problem: https://leetcode.com/problems/valid-sudoku/
	// Idea: Use Set to find each section has disstinct elements
	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			HashSet<Character> set = new HashSet<Character>();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					if (!set.add(board[i][j])) {
						return false;
					}
				}
			}
		}

		for (int j = 0; j < board.length; j++) {
			HashSet<Character> set = new HashSet<Character>();
			for (int i = 0; i < board[j].length; i++) {
				if(board[i][j] != '.' ) {
					if (!set.add(board[i][j])) {
						return false;
					}
				}
			}
		}
		
		HashSet<Character>[][] set = new HashSet[3][3];
		for(int i=0; i<set.length; i++) {
			for(int j=0; j<set[i].length; j++) {
				set[i][j] = new HashSet<Character>();
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] != '.' ) {
					if (!set[i/3][j/3].add(board[i][j])) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
}
