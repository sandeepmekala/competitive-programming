package edu.algos.graph;

import java.util.Stack;

import edu.ds.graph.model.Edge;
import edu.ds.graphs.Graph;
import edu.ds.graphs.UnionFind;

public class Algo04_DetectCycleInUndirectedGraph {

	UnionFind  uf = new UnionFind();
	
	public static void main(String[] args) {
		// cycle can be detected using union find algorithm
		// 0---1
		// | /
		// | /
		// 2
		Algo04_DetectCycleInUndirectedGraph obj = new Algo04_DetectCycleInUndirectedGraph();
		Graph g = new Graph(3, 3);
		g.vertices = new int[] {0,1,2};
		g.edges[0] = new Edge(0, 1);
		g.edges[1] = new Edge(1, 2);
		g.edges[2] = new Edge(2, 0);

		System.out.print("Is Cyclic:");
		System.out.println(obj.isCyclic(g));

		System.out.print("Is Cyclic by union find:");
		System.out.println(obj.isCyclicByUnionFind(g));
	}

	public boolean isCyclic(Graph g) {
		boolean[] visited = new boolean[g.V];
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		while (!stack.isEmpty()) {
			int current = stack.pop();
			visited[current] = true;
			for (Edge edge : g.edges) {
				if (edge.src == current) {
					int child = edge.dest;
					if (visited[child] && child != current) {
						return true;
					} else {
						stack.add(child);
					}
				}
			}
		}
		return false;
	}

	// time = O(V) as in worst case we execute 3v operations of union find which
	// take O(V) time.
	// space = O(V)
	public boolean isCyclicByUnionFind(Graph g) {
		uf.makeSet(g);

		for (Edge edge : g.edges) {
			int srcParent = uf.find(edge.src);
			int destParent = uf.find(edge.dest);

			if (srcParent == destParent) {
				return true;
			}
			uf.union(srcParent, destParent);
		}

		return false;
	}
}