package edu.algos.li18.graph;

import java.util.HashSet;
import java.util.Stack;

import edu.algos.li00_model.Edge;
import edu.algos.li00_model.GraphAdjLst;

public class G04DetectCycleInUndirectedGraph {

	G05UnionFind uf = new G05UnionFind();

	public static void main(String[] args) {
		// cycle can be detected using union find algorithm
		// 0---1
		// | /
		// | /
		// 2
		G04DetectCycleInUndirectedGraph obj = new G04DetectCycleInUndirectedGraph();
		GraphAdjLst g = new GraphAdjLst();
		g.addEdge(new Edge(0, 1));
		g.addEdge(new Edge(1, 2));
		g.addEdge(new Edge(2, 0));

		System.out.print("Is Cyclic:");
		System.out.println(obj.isCyclic(g));

		System.out.print("Is Cyclic by union find:");
		System.out.println(obj.isCyclicByUnionFind(g));
	}

	public boolean isCyclic(GraphAdjLst g) {
		HashSet<Integer> visited = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		while (!stack.isEmpty()) {
			int current = stack.pop();
			visited.add(current);
			for (int child : g.adjList.get(current)) {
				if (!visited.contains(child) && child != current) {
					return true;
				} else {
					stack.add(child);
				}
			}
		}
		return false;
	}

	// time = O(V) as in worst case we execute 3v operations of union find which
	// take O(V) time.
	// space = O(V)
	public boolean isCyclicByUnionFind(GraphAdjLst g) {
		uf.makeSet(g);

		for (int src : g.adjList.keySet()) {
			int srcParent = uf.find(src);
			for(int dest: g.adjList.get(src)) {
				int destParent = uf.find(dest);

				if (srcParent == destParent) {
					return true;
				}
				uf.union(srcParent, destParent);
			}
		}

		return false;
	}
}