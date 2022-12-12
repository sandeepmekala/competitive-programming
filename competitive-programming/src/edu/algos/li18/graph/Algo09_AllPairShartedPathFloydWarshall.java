package edu.algos.li18.graph;

import java.util.Arrays;

import edu.algos.li00_model.GraphMatrix;

public class Algo09_AllPairShartedPathFloydWarshall {

	static final int INF = 100;

	public static void main(String[] args) {
		Algo09_AllPairShartedPathFloydWarshall obj = new Algo09_AllPairShartedPathFloydWarshall();
		GraphMatrix g = new GraphMatrix(4);	

		g.addEdge(0, 1, 3);
		g.addEdge(0, 2, 6);
		g.addEdge(0, 3, 15);
		g.addEdge(1, 2, -2);
		g.addEdge(2, 3, 2);
		g.addEdge(3, 0, 1);

		obj.getShartestPaths(g);

	}

	// time: O(V^3)
	private void getShartestPaths(GraphMatrix g) {
		//each row represents shortest path from that vertex to all other vertices
		int[][] dist = new int[g.V][g.V];
		int[][] parent = new int[g.V][g.V];

		//initialize dist and parent matrices
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
