package graphs;

public class GraphWithAdjacentListMain {

	public static void main(String[] args) {

		GraphWithAdjacentList graph = new GraphWithAdjacentList(4);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		//graph.BFS(2);
		graph.DFS(2);
		
	}

}
