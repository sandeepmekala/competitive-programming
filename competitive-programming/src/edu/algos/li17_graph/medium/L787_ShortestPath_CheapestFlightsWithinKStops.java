package edu.algos.li17_graph.medium;

import java.util.Arrays;

public class L787_ShortestPath_CheapestFlightsWithinKStops {

	public static void main(String[] args) {
		L787_ShortestPath_CheapestFlightsWithinKStops obj = new L787_ShortestPath_CheapestFlightsWithinKStops();
		
		int n = 4;
		int[][] flights = new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
		int src = 0;
		int dst = 3;
		int k = 1;
		System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
	}

    // Problem: https://leetcode.com/problems/cheapest-flights-within-k-stops/
    // Idea: The idea if running it for only k steps is hard to be implemented in Dikstra. 
    // It is easy to be implemented using Bellman Ford as bellman ford runs for n-1 steps. 
    // We need to run bellman ford layer by layer by relaxing each layer eages in each step. Hence, we use a temp dist array to store the relaxed distances for that layer and will be used as input to next layer relaxation.
    // There will be k+1 edges between source and dest for k stops. Hence, we need to run bellmanford for k+1 time to relation k+1 edges.
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for(int i=0; i<=k; i++){       // for k stop, we need to relax verices, k+1 times. as theare k+1 edges till dest.
            int[] temp = Arrays.copyOf(dist, n);
            for(int[] edge: flights){
                int s = edge[0], d = edge[1], w = edge[2];
                if(dist[s] == INF){
                    continue;
                }
                if(temp[d] > dist[s]+w){
                    temp[d] = dist[s]+w;
                }
            }
            dist = Arrays.copyOf(temp, n);
        }
        
        return dist[dst] == INF?-1:dist[dst];
    }
}
