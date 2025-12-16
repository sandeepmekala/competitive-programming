
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Dfs {

	public static void main(String[] args) {
		Dfs obj = new Dfs();
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++)
			adj.add(new ArrayList<>());

		adj.get(0).add(1);
		adj.get(0).add(2);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(2).add(3);
		adj.get(3).add(3);

		System.out.println(obj.dfs2(adj, 0));
		System.out.println(obj.dfs(adj, 0));
	}

	// Space: O(V)
	// Time: O(V + E)
	// Recursive approach
	private List<Integer> dfs(List<List<Integer>> adj, int src) {
		int n = adj.size();
		List<Integer> ans = new ArrayList<>();
		int[] vis = new int[n];
		dfs(adj, vis, 0, ans);

		return ans;
	}

	private void dfs(List<List<Integer>> adj, int[] vis, int cur, List<Integer> ans) {
		vis[cur] = 1;
		ans.add(cur);
		for (int nei : adj.get(cur)) {
			if (vis[nei] != 1) {
				dfs(adj, vis, nei, ans);
			}
		}
	}

	// Iterative approach
	public List<Integer> dfs2(List<List<Integer>> adj, int src) {
		int n = adj.size();
		List<Integer> ans = new ArrayList<>();

		int[] vis = new int[n];
		Stack<Integer> s = new Stack<>();

		s.add(src);
		vis[src] = 1;
		while (!s.isEmpty()) {
			int node = s.pop();
			ans.add(node);
			for (int nei : adj.get(node)) {
				if (vis[nei] != 1) {
					vis[nei] = 1;
					s.add(nei);
				}
			}
		}

		return ans;
	}

}
