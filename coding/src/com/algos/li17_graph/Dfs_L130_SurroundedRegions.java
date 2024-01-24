package  com.algos.li17_graph;

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

        int visited[][] = new int[m][n]; 
        for(int i = 0;i<m;i++) {
            if(visited[i][0] == 0 && board[i][0] == 'O') 
                dfs(i, 0, visited, board); 
            if(visited[i][n-1] == 0 && board[i][n-1] == 'O') 
                dfs(i, n-1, visited, board); 
        }
        for(int j = 0 ; j<n;j++) {
            if(visited[0][j] == 0 && board[0][j] == 'O') 
                dfs(0, j, visited, board); 
            if(visited[m-1][j] == 0 && board[m-1][j] == 'O') 
                dfs(m-1,j,visited, board); 
        }
        
        for(int i = 0;i<m;i++) {
            for(int j= 0 ;j<n;j++) {
                if(visited[i][j] == 0 && board[i][j] == 'O') 
                    board[i][j] = 'X'; 
            }
        }
        
        return board;
    }

    private void dfs(int row, int col,int visited[][], char board[][]) {
        int m = board.length, n = board[0].length;
        
        visited[row][col] = 1; 
        
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1}; 
        for(int i=0; i<4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if (isSafe(visited, board, m, n, nrow, ncol)) {
                dfs(nrow, ncol, visited, board);
            }
        }
    }

    private boolean isSafe(int[][] visited, char[][] board, int m, int n, int nrow, int ncol) {
        return nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                && visited[nrow][ncol] == 0 && board[nrow][ncol] == 'O';
    }
}
