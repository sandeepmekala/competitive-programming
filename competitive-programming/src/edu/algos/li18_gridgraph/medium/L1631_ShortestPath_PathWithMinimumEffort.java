package edu.algos.li18_gridgraph.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L1631_ShortestPath_PathWithMinimumEffort {
    public static void main(String[] args) {
        L1631_ShortestPath_PathWithMinimumEffort obj = new L1631_ShortestPath_PathWithMinimumEffort();

        int[][] heights = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(obj.minimumEffortPath(heights));
    }

    // Problem: https://leetcode.com/problems/path-with-minimum-effort/
    // Idea: Apply Dijkstra with dist as abs effort diff.
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length, n=heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[0]-e2[0]);
        int[][] dist = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0}); // {dist, row, col}
        while(!pq.isEmpty()){
            int[] top = pq.remove();
            int effort = top[0], row = top[1], col = top[2];
            if(row == m-1 && col == n-1){
                return effort;
            }

            int[][] directions = new int[][]{{0,-1}, {-1, 0}, {0, 1}, {1, 0}};
            for(int direction[]: directions){
                int newr = row+direction[0], newc = col+direction[1];
                if(isSafe(heights, newr, newc)){
                    int newEffort = Math.max(effort, Math.abs(heights[newr][newc] - heights[row][col]));
                    if(newEffort < dist[newr][newc]){
                        dist[newr][newc] = newEffort;
                        pq.add(new int[]{newEffort, newr,newc});
                    }
                }
            }
        }

        return 0;
    }

    private boolean isSafe(int[][] heights, int i, int j) {
        int m=heights.length, n=heights[0].length;
        return i>=0 && i<m && j>=0 && j<n;
    }
}
