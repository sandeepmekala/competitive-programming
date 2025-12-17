package concepts.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Graph representation using adjacency list
 */
public class GraphAdjLst {
    public Map<Integer, List<Integer>> adj;
    public int vertices;

    public GraphAdjLst(int vertices) {
        this.vertices = vertices;
        this.adj = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adj.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adj.get(src).add(dest);
    }

    public void addUndirectedEdge(int src, int dest) {
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }

    public List<Integer> getNeighbors(int vertex) {
        return adj.get(vertex);
    }

    public int getVertices() {
        return vertices;
    }

    public Map<Integer, List<Integer>> getAdjList() {
        return adj;
    }

    public boolean hasEdge(int src, int dest) {
        return adj.get(src).contains(dest);
    }
}
