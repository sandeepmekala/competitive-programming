package  com.algos.core.li13_graph.revised;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPath_L1631_PathWithMinimumEffort {
    public static void main(String[] args) {
        ShortestPath_L1631_PathWithMinimumEffort obj = new ShortestPath_L1631_PathWithMinimumEffort();

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
        pq.add(new int[]{0, 0, 0}); // {effort, row, col}
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int effort = curr[0], row = curr[1], col = curr[2];
            if(row == m-1 && col == n-1)
                return effort;

            int[][] dirs = new int[][]{{0,-1}, {-1, 0}, {0, 1}, {1, 0}};
            for(int[] dir: dirs){
                int nrow = row+dir[0], ncol = col+dir[1];
                if(isSafe(m, n, nrow, ncol)){
                    int neffort = Math.max(effort, Math.abs(heights[nrow][ncol] - heights[row][col]));
                    if(neffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = neffort;
                        pq.add(new int[]{neffort, nrow,ncol});
                    }
                }
            }
        }

        return 0;
    }

    private boolean isSafe(int m, int n, int nrow, int ncol) {
        return nrow>=0 && nrow<m && ncol>=0 && ncol<n;
    }
}
