package algos.graph;

public class PrimsMinimumSpanningTree {

	public static void main(String[] args) {

		int[][] graph = new int[][] { 
			{ 0, 2, 0, 6, 0 }, 
			{ 2, 0, 3, 8, 5 }, 
			{ 0, 3, 0, 0, 7 }, 
			{ 6, 8, 0, 0, 9 },
			{ 0, 5, 7, 9, 0 } 
			};

		int[] parent = primsMst(graph, 0);
		for (int v = 1; v < parent.length; v++) {
			System.out.println(parent[v] + "->" + v);
		}

	}

	// concept: assign edge weight as value to each vertix and root vertix value is 0
	// start picking each min value vertix and adjust its adjustcent vertices key values 
	// O(V^2) as it loops over vertices twice
	private static int[] primsMst(int[][] graph, int src) {
		int V = graph.length;
		boolean[] visited = new boolean[V];
		int[] dist = new int[V];
		int[] parent = new int[V];

		// assign all the key to max value and set mstset calue to false
		for (int v = 0; v < V; v++) {
			visited[v] = false;
			dist[v] = Integer.MAX_VALUE;
		}
		
		//set the root key value to 0 to pick that first
		dist[src] = 0;
		//each iteration picks one vertex and adjust its neighbor key values
		for (int currentv = 0; currentv < V; currentv++) {
			int u = getDistMinKey(visited, dist);
			visited[u] = true;
			for (int v = 0; v < V; v++) {
				if (graph[u][v] > 0 && visited[v] == false && dist[v] > graph[u][v]) {
					dist[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}
		return parent;
	}

	private static int getDistMinKey(boolean[] visited, int[] dist) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int v = 0; v < visited.length; v++) {
			if (visited[v] == false && dist[v] < min) {
				min = dist[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

}
