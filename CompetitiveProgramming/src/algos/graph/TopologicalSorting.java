package algos.graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting {

	public static void main(String[] args) {
		// -> in DAG, for edge (u, v), in topological sorting u comes first then v.
		// - always starts from vertex whose indegree is 0
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		// Function Call
		Stack<Integer> stack = g.topologicalSort();
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}

class Graph {
	private int V;
	private LinkedList<Integer> adj[]; // Adjacency Lists

	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// time O(V+E)
	//space O(V)
	public Stack<Integer> topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		return stack;
	}

	private void topologicalSortUtil(int current, boolean[] visited, Stack<Integer> stack) {
		visited[current] = true;
		for (int i = 0; i < adj[current].size(); i++) {
			int child = adj[current].get(i);
			if (visited[child] == false) {
				topologicalSortUtil(child, visited, stack);
			}
		}
		stack.add(current);
	}
}