package edu.algos.li18_graph_grid.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L1091_ShortestPath_ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        L1091_ShortestPath_ShortestPathInBinaryMatrix obj = new L1091_ShortestPath_ShortestPathInBinaryMatrix();

        //int[][] grid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        int[][] grid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(obj.shortestPathBinaryMatrix(grid));
    }

    // Problem: https://leetcode.com/problems/shortest-path-in-binary-matrix/
    // Idea: Apply dijkstra algo with unit weight edges.
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        dist[0][0] = 1;
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] node = q.remove();
            int r = node[0], c = node[1];
            if(r == m-1 && c == n-1){
                return dist[r][c];
            }
            int[][] directions = new int[][]{{0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};
            for(int[] direction: directions){
                int newr = r+direction[0], newc = c+direction[1];
                if(isSafe(grid, newr, newc)){
                    if(dist[r][c]+1 < dist[newr][newc]){
                        dist[newr][newc] = dist[r][c]+1;
                        q.add(new int[]{newr, newc});
                    }
                }
            }
        }

        return -1;
    }

    private boolean isSafe(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        return i>=0 && i<m && j>=0 && j<n && grid[i][j] == 0;
    }

}
