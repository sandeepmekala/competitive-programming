package com.algos.topics.models;

/**
 * Graph representation using adjacency matrix
 */
public class GraphMatrix {
    public int[][] adjMatrix;
    public int V;

    public GraphMatrix(int vertices) {
        this.V = vertices;
        this.adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int src, int dest, int weight) {
        adjMatrix[src][dest] = weight;
    }

    public void addEdge(int src, int dest) {
        addEdge(src, dest, 1);
    }

    public int getWeight(int src, int dest) {
        return adjMatrix[src][dest];
    }

    public int getVertices() {
        return V;
    }

    public int[][] getMatrix() {
        return adjMatrix;
    }

    public boolean hasEdge(int src, int dest) {
        return adjMatrix[src][dest] != 0;
    }
}
