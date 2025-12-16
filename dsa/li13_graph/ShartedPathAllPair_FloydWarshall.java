package li13_graph;

import java.util.Arrays;

public class ShartedPathAllPair_FloydWarshall {

	static final int INF = 100;

	public static void main(String[] args) {
		ShartedPathAllPair_FloydWarshall obj = new ShartedPathAllPair_FloydWarshall();
		int[][] adj = new int[4][4];
		adj[0][1] = 3;
		adj[0][2] = 6;
		adj[0][3] = 15;
		adj[1][2] = -2;
		adj[2][3] = 2;
		adj[3][0] = 1;

		int[][] dist = obj.getShartestPaths(adj);
		for(int[] row: dist)
			System.out.println(Arrays.toString(row));

		// Negative cycle
		boolean check = checkNegativeCycles(dist);
		System.out.println(check);
	}

	// Idea: Take a random vertex k and see if the path from i to j via k is shorter.
	// If yes, update the dist[i][j] = dist[i][k]+dist[k][j]
	// j need to be reached via k. Hence, update j's parent as k.
	// It can detect negative weight cycles also.
	// Once the algo ran, if the cost[i][i] goes negative, means algo would have gone through negative cycle and updated the cost[i][i] to negative.
	// Time: O(V^3)
	// Space: O(V^2)
	private int[][] getShartestPaths(int[][] adj) {
		int n = adj.length;

		//each row represents shortest path from that vertex to all other vertices
		int[][] dist = new int[n][n];
		int[][] parent = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == j) {
					dist[i][j] = 0;
					parent[i][j] = -1;
				}else if (adj[i][j] != 0) {
					dist[i][j] = adj[i][j];
					parent[i][j] = i;
				} else {
					dist[i][j] = INF;
					parent[i][j] = -1;
				}

			}
		}

		for (int via = 0; via < n; via++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(dist[i][via] == INF || dist[via][j] == INF)
						continue;

					if(dist[i][via]+dist[via][j] < dist[i][j]) {
						dist[i][j] = dist[i][via]+dist[via][j];
						parent[i][j] = via; //parent[via][j];
					}
				}
			}
		}

		for(int[] row: parent)
			System.out.println(Arrays.toString(row));

		return dist;
	}

	private static boolean checkNegativeCycles(int[][] dist) {
		int n = dist.length;
		for(int i=0; i<n; i++){
			if(dist[i][i] < 0)
				return true;
		}

		return false;
	}
}
