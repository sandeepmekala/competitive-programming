package edu.algos.graph;

import java.util.Arrays;

import edu.ds.graphs.GraphMatrix;

public class FloydWarshallAllPairShartedPath {

	static final int INF = 100;

	public static void main(String[] args) {
		FloydWarshallAllPairShartedPath obj = new FloydWarshallAllPairShartedPath();
		GraphMatrix g = new GraphMatrix(4);	

		g.addEdge(0, 1, 3);
		g.addEdge(0, 2, 6);
		g.addEdge(0, 3, 15);
		g.addEdge(1, 2, -2);
		g.addEdge(2, 3, 2);
		g.addEdge(3, 0, 1);

		int[][] dist = obj.getShartestPaths(g);
		System.out.println();
		for (int[] arr : dist) {
			System.out.println(Arrays.toString(arr));
		}
	}

	private int[][] getShartestPaths(GraphMatrix g) {
		int[][] dist = new int[g.V][g.V];
		int[][] parent = new int[g.V][g.V];

		for (int i = 0; i < g.adjMatrix.length; i++) {
			for (int j = 0; j < g.adjMatrix.length; j++) {
				if (g.adjMatrix[i][j] != 0 || i == j) {
					dist[i][j] = g.adjMatrix[i][j];
				} else {
					dist[i][j] = INF;
				}
				if (g.adjMatrix[i][j] != 0) {
					parent[i][j] = i;
				} else {
					parent[i][j] = -1;
				}
			}
		}

		for (int k = 0; k < g.adjMatrix.length; k++) {
			for (int i = 0; i < g.adjMatrix.length; i++) {
				for (int j = 0; j < g.adjMatrix.length; j++) {
					if(dist[i][k] == INF || dist[k][j] == INF) {
						continue;
					}
					if(dist[i][j] > dist[i][k]+dist[k][j]) {
						dist[i][j] = dist[i][k]+dist[k][j];
						parent[i][j] = parent[k][j];
					}
				}
			}
		}

		for (int[] arr : parent) {
			System.out.println(Arrays.toString(arr));
		}
		return dist;
	}

}
