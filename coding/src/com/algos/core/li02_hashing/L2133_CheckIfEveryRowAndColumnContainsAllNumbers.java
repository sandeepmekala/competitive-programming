package  com.algos.core.li02_hashing;

import java.util.HashSet;
import java.util.Set;

public class L2133_CheckIfEveryRowAndColumnContainsAllNumbers {

	public static void main(String[] args) {
		L2133_CheckIfEveryRowAndColumnContainsAllNumbers obj = new L2133_CheckIfEveryRowAndColumnContainsAllNumbers();
		System.out.println(obj.checkValid(new int[][] {{1,2,3},{3,1,2},{2,3,1}}));

	}
	
	// Problem: https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
	// Idea: Add each row and col elements to HashSet and check if all are unique.
	public boolean checkValid(int[][] board) {
        for (int i = 0; i < board.length; i++) {
			Set<Integer> rowSet = new HashSet<Integer>();
			Set<Integer> colSet = new HashSet<Integer>();
			for (int j = 0; j < board[i].length; j++) {
				if(!rowSet.add(board[i][j]) || !colSet.add(board[j][i]))
                	return false;
			}
		}
        
        return true;
    }
}
