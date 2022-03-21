package edu.algos.graph;

public class ShortestPathDijkstras {

	public static void main(String[] args) {
		int graph[][] = new int[][] { 
			{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
            
            ShortestPathDijkstras dijkstrasShortestPath = new ShortestPathDijkstras();
            int dist[] = dijkstrasShortestPath.dijkstra(graph, 0);
            dijkstrasShortestPath.print(dist);
	}

	private void print(int[] dist) {
		for(int v=0; v<dist.length; v++) {
			System.out.println(v+":"+dist[v]);
		}
	}

	//concept: same as prims algo except that instead of just check the edge weight we track cumulative sum from root
	// use dist array to track distance each vertices
	// visited array to track explored vertices
	// may be a parent array if you want to print path
	//O(V^2)
	private int[] dijkstra(int[][] graph, int src) {
		int V = graph.length;
		boolean[] visited = new boolean[V];
		int[] dist = new int[V];
		
		for(int v=0; v<V; v++) {
			visited[v] = false;
			dist[v] = Integer.MAX_VALUE;
		}
		
		dist[src] = 0;
		for(int currentv=0; currentv<V; currentv++) {
			int u = getMinDistKey(visited, dist);
			visited[u] = true;
			for(int v=0; v<V; v++) {
				if(graph[u][v] > 0 && visited[v] == false) {
					int newDist  = dist[u]+graph[u][v];
					if(newDist < dist[v]) {
						dist[v] = newDist;
					}
					
				}
			}
		}
		return dist;
	}

	private int getMinDistKey(boolean[] visited, int[] dist) {
		int minDist = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int v=0; v<visited.length; v++) {
			if(visited[v] == false && dist[v] < minDist) {
				minDist = dist[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

}
