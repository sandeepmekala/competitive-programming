package edu.algos.li17_graph.medium;

import java.util.Arrays;
import java.util.HashSet;

public class Mst_L1584_MinCostToConnectAllPoints {

	public static void main(String[] args) {
		Mst_L1584_MinCostToConnectAllPoints obj = new Mst_L1584_MinCostToConnectAllPoints();
		int[][] points = new int[][] {{0,0},{2,2},{3,10},{5,2},{7,0}};
		System.out.println(obj.minCostConnectPoints(points));
	}
	
    // Problem: https://leetcode.com/problems/min-cost-to-connect-all-points/
    // Idea: It forms a fully connected graph with edge weights is equal to manhatan distance.
    // Find MST cost in this graph
	public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] g = new int[n][n];
        for(int i=0; i<n; i++){     // cal dist for [i,j] and [j,i]
            int x1 = points[i][0], y1 = points[i][1]; 
            for(int j=i+1; j<n; j++){
                int x2 = points[j][0], y2 = points[j][1]; 
                int dist = Math.abs(x1-x2)+Math.abs(y1-y2);
                g[i][j] = dist;
                g[j][i] = dist;
            }
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        HashSet<Integer> visited = new HashSet<>();
        int cost = 0;
        while(visited.size() < n){
            int u = getMin(visited, dist);
            visited.add(u);
            cost += dist[u];
            for(int v=0; v<n; v++){
                if(g[u][v] > 0 && !visited.contains(v) && g[u][v] < dist[v]){
                    dist[v] = g[u][v];
                }
            }
        }
        return cost;
    }
    
    private int getMin(HashSet<Integer> visited, int[] dist){
        int min = Integer.MAX_VALUE;
        int minind = -1;
        for(int i=0; i<dist.length; i++){
            if(!visited.contains(i) && dist[i] < min){
                min = dist[i];
                minind = i;
            }
        }
        return minind;
    }

}
