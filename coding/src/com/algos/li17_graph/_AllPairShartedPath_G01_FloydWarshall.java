package  com.algos.li17_graph;

import java.util.Arrays;

import  com.algos.li30_model.GraphMatrix;

public class _AllPairShartedPath_G01_FloydWarshall {

	static final int INF = 100;

	public static void main(String[] args) {
		_AllPairShartedPath_G01_FloydWarshall obj = new _AllPairShartedPath_G01_FloydWarshall();
		GraphMatrix g = new GraphMatrix(4);	

		g.addEdge(0, 1, 3);
		g.addEdge(0, 2, 6);
		g.addEdge(0, 3, 15);
		g.addEdge(1, 2, -2);
		g.addEdge(2, 3, 2);
		g.addEdge(3, 0, 1);

		obj.getShartestPaths(g);

	}

	// Idea: Take a random vertex k and see if the path from i to j via k is shorter.
	// If yes, update the dist[i,j] = dist[i,k]+dist[k,j]
	// j need to be reached via k. Hence, update j's parent as k.
	// It can detect negative weight cycles also. Once the algo ran, if the cost[i][i] goes negative, means algo would have gone through negative cycle and updated the cost[i][i] to negative. Run a for loop 0 to n and check if any the diagonals id negative.
	// time: O(V^3)
	private void getShartestPaths(GraphMatrix g) {
		//each row represents shortest path from that vertex to all other vertices
		int[][] dist = new int[g.V][g.V];
		int[][] parent = new int[g.V][g.V];

		for (int i = 0; i < g.adjMatrix.length; i++) {
			for (int j = 0; j < g.adjMatrix.length; j++) {
				if(i == j && g.adjMatrix[i][j] == 0) {
					dist[i][j] = 0;
					parent[i][j] = -1;
				}else if (g.adjMatrix[i][j] != 0) {
					dist[i][j] = g.adjMatrix[i][j];
					parent[i][j] = i;
				} else {
					dist[i][j] = INF;
					parent[i][j] = -1;
				}
				
			}
		}
		System.out.println("Initialization:");
		print(parent, dist);

		for (int via = 0; via < g.adjMatrix.length; via++) {
			for (int i = 0; i < g.adjMatrix.length; i++) {
				for (int j = 0; j < g.adjMatrix.length; j++) {
					if(dist[i][via] == INF || dist[via][j] == INF) 
						continue;
					
					if(dist[i][via]+dist[via][j] < dist[i][j]) {
						dist[i][j] = dist[i][via]+dist[via][j];
						parent[i][j] = parent[via][j];
					}
				}
			}
		}
		System.out.println("Result:");
		print(parent, dist);
	}
	
	private void print(int[][] parent, int[][] dist) {
		for (int[] arr : parent) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();
		for (int[] arr : dist) {
			System.out.println(Arrays.toString(arr));
		}
	}
}
