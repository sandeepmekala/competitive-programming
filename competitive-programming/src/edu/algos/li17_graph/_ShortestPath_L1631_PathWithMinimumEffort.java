package edu.algos.li17_graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _ShortestPath_L1631_PathWithMinimumEffort {
    public static void main(String[] args) {
        _ShortestPath_L1631_PathWithMinimumEffort obj = new _ShortestPath_L1631_PathWithMinimumEffort();

        int[][] heights = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(obj.minimumEffortPath(heights));
    }

    // Problem: https://leetcode.com/problems/path-with-minimum-effort/
    // Idea: Apply Dijkstra with dist as abs effort diff.
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length, n=heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[0]-e2[0]);
        int[][] dist = new int[m][n];
        for(int i=0; i<m; i++) 
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0}); // {dist, row, col}
        while(!pq.isEmpty()){
            int[] top = pq.remove();
            int effort = top[0], row = top[1], col = top[2];
            if(row == m-1 && col == n-1)
                return effort;

            int[][] directions = new int[][]{{0,-1}, {-1, 0}, {0, 1}, {1, 0}};
            for(int direction[]: directions){
                int nrow = row+direction[0], ncol = col+direction[1];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n){
                    int newEffort = Math.max(effort, Math.abs(heights[nrow][ncol] - heights[row][col]));
                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        pq.add(new int[]{newEffort, nrow,ncol});
                    }
                }
            }
        }

        return 0;
    }
}
