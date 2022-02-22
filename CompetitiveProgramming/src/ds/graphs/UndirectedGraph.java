package ds.graphs;

public class UndirectedGraph {

	public static void main(String[] args) {
		// cycle can be detected using union find algorithm
		//	0---1
		//	|  /
		//	| /	
		//	2
		
		Graph g = new Graph(3, 3);
		
		g.edges[0] = new Edge(0, 1);
		g.edges[1] = new Edge(1, 2);
		g.edges[2] = new Edge(2, 0);
		
		System.out.println("Is Cyclic:");
		System.out.println(g.isCyclic());
	}

}
class Graph{
	private int V, E;
	public Edge[] edges;
	Graph(int v, int e){
		this.V = v;
		this.E = e;

		edges = new Edge[E];
	}
	
	public boolean isCyclic() {
		int[] parent = new int[V];
		
		for(int i=0; i<parent.length; i++) {
			parent[i] = -1;
		}
		
		for(Edge edge: edges) {
			int fromParent = find(parent, edge.from);
			int toParent = find(parent, edge.to);
			
			if(fromParent == toParent) {
				return true;
			}
			union(parent, fromParent, toParent);
		}
		
		return false;
	}

	private void union(int[] parent, int fromParent, int toParent) {
		parent[fromParent] = toParent;
	}

	private int find(int[] parent, int node) {
		if(parent[node] == -1) {
			return node;
		}
		return find(parent, parent[node]);
	}
}
class Edge{
	public int from;
	public int to;
	
	Edge(int from, int to){
		this.from = from;
		this.to = to;
	}
}
