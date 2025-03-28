package  com.algos.core.li13_graph.revised;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath_L1091_ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        ShortestPath_L1091_ShortestPathInBinaryMatrix obj = new ShortestPath_L1091_ShortestPathInBinaryMatrix();

        //int[][] grid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        int[][] grid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(obj.shortestPathBinaryMatrix(grid));
    }

    // Problem: https://leetcode.com/problems/shortest-path-in-binary-matrix/
    // Idea: Apply dijkstra algo with unit weight edges.
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) 
            return -1;

        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int i=0; i<m; i++) 
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        dist[0][0] = 1;
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] node = q.remove();
            int row = node[0], col = node[1];
            if(row == m-1 && col == n-1)
                return dist[row][col];
            
            for(int dr=-1; dr<=1; dr++){
                for(int dc=-1; dc<=1; dc++){
                    int nrow = row+dr, ncol = col+dc;
                    if(isSafe(grid, m, n, nrow, ncol)){
                        if(dist[row][col]+1 < dist[nrow][ncol]){
                            dist[nrow][ncol] = dist[row][col]+1;
                            q.add(new int[]{nrow, ncol});
                        }
                    }
                }
            }
        }

        return -1;
    }

    private boolean isSafe(int[][] grid, int m, int n, int nrow, int ncol) {
        return nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol] == 0;
    }

}
