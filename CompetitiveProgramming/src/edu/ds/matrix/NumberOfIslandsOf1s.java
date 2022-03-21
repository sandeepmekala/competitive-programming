package edu.ds.matrix;

public class NumberOfIslandsOf1s {

	public static void main(String[] args) {
		NumberOfIslandsOf1s obj = new NumberOfIslandsOf1s();
		char[][] grid = new char[][] {
			{'0', '1'},
			{'1', '0'},
			{'1', '1'},
			{'1', '0'},
		};
		System.out.println(obj.numIslands(grid));

	}
	public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isSafe(grid, visited, m, n, i, j)){
                    dfs(grid,visited, m, n, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid,boolean[][] visited, int m, int n, int i, int j){
        if(isSafe(grid, visited, m, n, i, j)){
        	visited[i][j] = true;
        	
            //sides
            dfs(grid, visited, m, n, i-1, j);
            dfs(grid, visited, m, n, i+1, j);
            dfs(grid, visited, m, n, i, j-1);
            dfs(grid, visited, m, n, i, j+1);
            
            //diagonals
            dfs(grid, visited, m, n, i-1, j-1);
            dfs(grid, visited, m, n, i+1, j+1);
            dfs(grid, visited, m, n, i-1, j+1);
            dfs(grid, visited, m, n, i+1, j-1);
        }else{
            return;
        }
    }
    
    private boolean isSafe(char[][] grid, boolean[][] visited, int m, int n, int i, int j){
        if(i>=0 && i<m && j>=0 && j<n && !visited[i][j] && grid[i][j] == '1'){
            return true;
        }
        return false;
    }
}
