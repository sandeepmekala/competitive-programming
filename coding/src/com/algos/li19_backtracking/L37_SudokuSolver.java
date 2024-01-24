package  com.algos.li19_backtracking;

public class L37_SudokuSolver {
    public static void main(String[] args) {
        L37_SudokuSolver obj = new L37_SudokuSolver();

        char[][] board = new char[][] { 
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        
        obj.solveSudoku(board);
        System.out.println();
    }

    // Problem: https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
    // Time: O(9^n*n)
	// Space: O(n^2)
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == '.'){
                    for(char ch='1'; ch<='9'; ch++){
                        if(isSafe(board, i, j, ch)){
                            board[i][j] = ch;
                            if(solve(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, char ch) {
        for(int i=0; i<board.length; i++){
            if(board[row][i] == ch)
                return false;
            if(board[i][col] == ch)
                return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] == ch)
                return false;
        }
        return true;
    }
}
