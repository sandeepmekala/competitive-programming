import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.algos.topics.models.GraphAdjLst;

public class Bfs {

	public static void main(String[] args) {
		Bfs obj = new Bfs();
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++)
			adj.add(new ArrayList<>());

		adj.get(0).add(1);
		adj.get(0).add(2);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(2).add(3);
		adj.get(3).add(3);

		System.out.println(obj.bfs(adj, 0));
	}

	// Time: O(V + E)
	// Space: O(V)
	public List<Integer> bfs(List<List<Integer>> adj, int src) {
		int n = adj.size();
		List<Integer> ans = new ArrayList<>();

		Queue<Integer> q = new LinkedList<>();
		int[] vis = new int[n];

		q.add(src);
		vis[src] = 1;
		while (!q.isEmpty()) {
			int cur = q.remove();
			ans.add(cur);
			for (int nei: adj.get(cur)) {
				if (vis[nei] != 1) {
					vis[nei] = 1;
					q.add(nei);
				}
			}
		}

		return ans;
	}
}
