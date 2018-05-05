package graphs;

class GraphWithAdjacentMatrixMain {

	public static void main(String[] args) {
		GraphWithAdjacentMatrix graph = new GraphWithAdjacentMatrix(4);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		graph.BFS(2);
		graph.DFS(0);
		
	}
}