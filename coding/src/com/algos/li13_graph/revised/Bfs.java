package  com.algos.li13_graph.revised;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import  com.algos.li30_model.GraphAdjLst;

public class Bfs {

	public static void main(String[] args) {
		Bfs obj = new Bfs();
		GraphAdjLst g = new GraphAdjLst();

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		obj.bfs(g, 0);
	}

	public void bfs2(GraphAdjLst g, int src) {
		
	}
	// Time: O(V + E)
	// Space: O(V)
	public void bfs(GraphAdjLst g, int src) {
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> vis = new HashSet<Integer>();
		
		q.add(src);
		vis.add(src);
		while (!q.isEmpty()) {
			int node = q.remove();
			System.out.println(node);
			for (int neigh: g.adj.get(node)) {
				if (!vis.contains(neigh)) {
					vis.add(neigh);
					q.add(neigh);
				}
			}
		}
	}
}
