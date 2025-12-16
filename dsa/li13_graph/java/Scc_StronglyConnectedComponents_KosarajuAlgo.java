
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Scc_StronglyConnectedComponents_KosarajuAlgo {

	public static void main(String[] args) {
		Scc_StronglyConnectedComponents_KosarajuAlgo obj = new Scc_StronglyConnectedComponents_KosarajuAlgo();
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 11; i++)
			adj.add(new ArrayList<>());
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(1).add(3);
		adj.get(3).add(4);
		adj.get(4).add(5);
		adj.get(5).add(3);
		adj.get(6).add(5);
		adj.get(6).add(7);
		adj.get(7).add(8);
		adj.get(8).add(9);
		adj.get(9).add(6);
		adj.get(9).add(10);

		List<Set<Integer>> components = obj.getStronglyConnectedComponents(adj);
		System.out.println(components);
	}

    // Idea: Do dfs and populate the topological order stack. We do another dfs in this order.
    // 		Then reverse the egdes in the graph so that second dfs will not go out of strong connected component.
    // 		Do second dfs and store the vertices which form strong connected component when dfs ends.
	// O(V+E)
	public List<Set<Integer>> getStronglyConnectedComponents(List<List<Integer>> adj) {
		int n = adj.size();

		Stack<Integer> st = new Stack<>();
		int[] vis = new int[n];
		for (int i=0; i<n; i++) {
			if(vis[i] != 1) {
				dfs(adj, i, st, vis);   // dfs and populate resStack in reverse topological order
			}
		}

		adj = reverGraph(adj);  //reverse the graph edges

		List<Set<Integer>> components = new ArrayList<>();
		vis = new int[n];
		while(!st.isEmpty()) {
			int node = st.pop();
			Set<Integer> set = new HashSet<>();
			if(vis[node] != 1) {
				dfs2(adj, node, set, vis); // dfs and populate the component set.
				components.add(set);
			}

		}
		return components;
	}

	// O(V+E)
	private List<List<Integer>> reverGraph(List<List<Integer>> adj) {
		int n = adj.size();

		List<List<Integer>> adjT = new ArrayList<>();
		for (int i=0; i<n; i++)
			adjT.add(new ArrayList<>());
		for (int i=0; i<n; i++) {
			for(int nei: adj.get(i)) {
				adjT.get(nei).add(i);
			}
		}
		return adjT;
	}

	// O(V+E)
	private void dfs(List<List<Integer>> adj, int node, Stack<Integer> stack, int[] vis) {
		vis[node] = 1;
		for (int nei: adj.get(node)) {
			if (vis[nei] != 1) {
				dfs(adj, nei, stack, vis);
			}
		}
		stack.add(node);
	}

	// O(V+E)
	private void dfs2(List<List<Integer>> adj, int node, Set<Integer> set, int[] vis) {
		vis[node] = 1;
		set.add(node);
		for (int nei: adj.get(node)) {
			if (vis[nei] != 1) {
				dfs2(adj, nei, set, vis);
			}
		}
	}
}
