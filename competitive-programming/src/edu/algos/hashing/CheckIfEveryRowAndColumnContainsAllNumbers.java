package edu.algos.hashing;

import java.util.HashSet;

public class CheckIfEveryRowAndColumnContainsAllNumbers {

	public static void main(String[] args) {
		CheckIfEveryRowAndColumnContainsAllNumbers obj = new CheckIfEveryRowAndColumnContainsAllNumbers();
		System.out.println(obj.checkValid(new int[][] {{1,2,3},{3,1,2},{2,3,1}}));

	}
	
	public boolean checkValid(int[][] board) {
        for (int i = 0; i < board.length; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < board[i].length; j++) {
                set.add(board[i][j]);
			}
            if(set. size() != board.length){
                return false;
            }
		}

		for (int j = 0; j < board.length; j++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < board[j].length; i++) {
                set.add(board[i][j]);
			}
            if(set. size() != board.length){
                return false;
            }
		}
        
        return true;
    }
}
