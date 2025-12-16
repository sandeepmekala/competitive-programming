package li13_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.algos.topics.models.Edge;
import com.algos.topics.models.GraphAdjLst;

public class DetectCycle_DetectCycleInUndirectedGraph {

	UnionFind_UnionFind uf = new UnionFind_UnionFind();

	public static void main(String[] args) {
		// cycle can be detected using union find algorithm
		// 0---1
		// |  /
		// | /
		// 2
		DetectCycle_DetectCycleInUndirectedGraph obj = new DetectCycle_DetectCycleInUndirectedGraph();
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++)
			adj.add(new ArrayList<>());
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);

		System.out.print("Is Cyclic:");
		System.out.println(obj.isCyclicBfs(adj));

		// Create a GraphAdjLst for union find test
		GraphAdjLst g = new GraphAdjLst(3);
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(1, 2);
		g.addUndirectedEdge(2, 0);

		System.out.print("Is Cyclic by union find:");
		System.out.println(obj.isCyclicByUnionFind(g));
	}

	// BFS
	public boolean isCyclicBfs(List<List<Integer>> adj) {
		int n = adj.size();

		int[] vis = new int[n];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[]{0, -1});
		vis[0] = 1;
		while (!q.isEmpty()) {
			int[] curr = q.remove();
			int node = curr[0], parent = curr[1];
			for (int nei : adj.get(node)) {
				if (vis[nei] != 1) {
					vis[nei] = 1;
					q.add(new int[]{nei, node});
				} else if (nei != parent) { // if visited and not parent
					return true;
				}
			}
		}
		return false;
	}

    public boolean isCycleDfs(List<List<Integer>> adj) {
		int n = adj.size();
		int[] vis = new int[n];
		for (int i = 0; i < n; i++) {
			if (vis[i] == 0) {
				if (dfs(i, -1, vis, adj) == true)
					return true;
			}
		}
		return false;
	}

	private boolean dfs(int node, int parent, int vis[], List<List<Integer>> adj) {
		vis[node] = 1;
		for(int nei : adj.get(node)) {
			if (vis[nei] == 0) {
				if (dfs(nei, node, vis, adj) == true)
					return true;
			}else if (nei != parent)
				return true;
		}
		return false;
	}

	// time = O(V) as in worst case we execute 3v operations of union find which
	// take O(V) time.
	// space = O(V)
	public boolean isCyclicByUnionFind(GraphAdjLst g) {
		uf.makeSet(g.adj.size());
		for (int src : g.adj.keySet()) {
			int srcParent = uf.find(src);
			for(int dest: g.adj.get(src)) {
				int destParent = uf.find(dest);
				if (srcParent == destParent)
					return true;

				uf.unionByRank(srcParent, destParent);
			}
		}

		return false;
	}
}
