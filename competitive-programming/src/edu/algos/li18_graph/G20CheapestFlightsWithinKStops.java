package edu.algos.li18_graph;

import java.util.Arrays;

public class G20CheapestFlightsWithinKStops {

	public static void main(String[] args) {
		G20CheapestFlightsWithinKStops obj = new G20CheapestFlightsWithinKStops();
		
		int n = 4;
		int[][] flights = new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
		int src = 0;
		int dst = 3;
		int k = 1;
		System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for(int i=0; i<=k; i++){
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
