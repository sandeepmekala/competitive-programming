package  com.algos.li30_model;

public class GraphMatrix {
	public int V;
	public int[][] adjMatrix;
	public GraphMatrix(int V){
		this.V = V;
		adjMatrix = new int[V][V];
	}
	
	public void addEdge(int src, int dest){
		adjMatrix[src][dest] = 1;
	}
	
	public void addEdge(int src, int dest, int weight){
		adjMatrix[src][dest] = weight;
	}

}
