package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _ShortestPath_L787_CheapestFlightsWithinKStops {

	public static void main(String[] args) {
		_ShortestPath_L787_CheapestFlightsWithinKStops obj = new _ShortestPath_L787_CheapestFlightsWithinKStops();
		
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


    // The same can be solved using Dijkstra's algorithm also by prioratizing the k over dist
    // This will boils down to applying simple BFS.
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) 
            adj.add(new ArrayList<>()); 
        
        int m = flights.length; 
        for(int i=0; i<m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2])); 
        }
        
        Queue<Tuple> q = new LinkedList<>(); 
        q.add(new Tuple(0, src, 0));

        int[] dist = new int[n]; 
        for(int i = 0;i<n;i++) 
            dist[i] = (int)(1e9); 
        
        dist[src] = 0; 
        while(!q.isEmpty()) {
            Tuple curr = q.remove(); 
            int stops = curr.stops, station = curr.station, cost = curr.cost; 
            
            // We stop the process as soon as the limit for the stops reaches.
            if(stops > k) continue; 
            for(Pair it: adj.get(station)) {
                int neigh = it.station; 
                int edgeWeight = it.cost; 
                
                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edgeWeight < dist[neigh] && stops <= k) {
                    dist[neigh] = cost + edgeWeight; 
                    q.add(new Tuple(stops + 1, neigh, cost + edgeWeight)); 
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1; 
        return dist[dst]; 
    }
}
class Pair{
    int station;
    int cost;
    public Pair(int node,int cost){
        this.station = node;
        this.cost = cost;
    }
}
class Tuple {
    int stops, station, cost; 
    Tuple(int first, int second, int third) {
        this.stops = first; 
        this.station = second;
        this.cost = third; 
    }
}
