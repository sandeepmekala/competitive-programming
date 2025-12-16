package  com.algos.topics.li13_graph.revised;

public class Dfs_L130_SurroundedRegions {

	public static void main(String[] args) {
        Dfs_L130_SurroundedRegions obj = new Dfs_L130_SurroundedRegions();

        char[][] mat = {
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
                        dfs(board, i, j, vis);
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

    private void dfs(char[][] board, int i, int j, int[][] vis) {
        vis[i][j] = 1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (isSafe(board, ni, nj, vis))
                dfs(board, ni, nj, vis);
        }
    }

    private boolean isSafe(char[][] board, int ni, int nj, int[][] vis) {
        int m = board.length, n = board[0].length;
        return ni >= 0 && ni < m && nj >= 0 && nj < n
                && vis[ni][nj] == 0 && board[ni][nj] == 'O';
    }
}
