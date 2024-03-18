package  com.algos.li13_graph.revised;

public class Dfs_L130_SurroundedRegions {

	public static void main(String[] args) {
        Dfs_L130_SurroundedRegions obj = new Dfs_L130_SurroundedRegions();

        char mat[][] = {
        {'X', 'X', 'X', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'O', 'O', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'X', 'O', 'O'}};

        char[][] ans = obj.solve(mat);
        for(int i = 0;i < 5;i++) {
            for(int j = 0;j < 4;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Problem: https://leetcode.com/problems/surrounded-regions/
    // Idea: Just do dfs from all border cells which contains O and mark them as visited
    // Then replace all the O->X which are not visited
    public char[][] solve(char board[][]) {
        int m = board.length, n = board[0].length;

        int vis[][] = new int[m][n]; 
        for(int i = 0;i<m;i++) {
            for(int j = 0 ; j<n;j++) {
                if(i == 0 || j == 0 || i == m-1 || j == n-1) 
                    if(vis[i][j] == 0 && board[i][j] == 'O') 
                        dfs(i, j, vis, board); 
            }
        }
        
        for(int i = 0;i<m;i++) {
            for(int j = 0 ;j<n;j++) {
                if(vis[i][j] == 0 && board[i][j] == 'O') 
                    board[i][j] = 'X'; 
            }
        }
        
        return board;
    }

    private void dfs(int row, int col,int vis[][], char board[][]) {
        if (!isSafe(vis, board, row, col)) 
            return;     

        vis[row][col] = 1; 
        dfs(row+1, col, vis, board);
        dfs(row-1, col, vis, board);
        dfs(row, col+1, vis, board);
        dfs(row, col-1, vis, board);
    }

    private boolean isSafe(int[][] vis, char[][] board, int nrow, int ncol) {
        int m = board.length, n = board[0].length;
        return nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O';
    }
}
