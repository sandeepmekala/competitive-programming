package edu.algos.li19_graph_grid;

import java.util.HashSet;

public class G01NumberOfIslands {

	public static void main(String[] args) {
		G01NumberOfIslands obj = new G01NumberOfIslands();
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
        HashSet<String> visited = new HashSet<String>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(grid, m, n, i, j, visited)){
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean dfs(char[][] grid, int m, int n, int i, int j, HashSet<String> visited){
    	String pos = i+","+j;
        if(!isSafe(grid, m, n, i, j, visited)){
        	return false;
        }
        
    	visited.add(pos);
    	
        //sides
        dfs(grid, m, n, i-1, j, visited);
        dfs(grid, m, n, i+1, j, visited);
        dfs(grid, m, n, i, j-1, visited);
        dfs(grid, m, n, i, j+1, visited);
        
        //diagonals
//        dfs(grid, m, n, i-1, j-1, visited);
//        dfs(grid, m, n, i+1, j+1, visited);
//        dfs(grid, m, n, i-1, j+1, visited);
//        dfs(grid, m, n, i+1, j-1, visited);
        
        return true;
    }
    
    private boolean isSafe(char[][] grid, int m, int n, int i, int j, HashSet<String> visited){
    	String pos = i+","+j;
        if(i>=0 && i<m && j>=0 && j<n && !visited.contains(pos) && grid[i][j] == '1'){
            return true;
        }
        return false;
    }
}
