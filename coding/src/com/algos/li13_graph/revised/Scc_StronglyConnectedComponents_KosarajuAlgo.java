package  com.algos.li13_graph.revised;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import  com.algos.li30_model.GraphAdjLst;

public class Scc_StronglyConnectedComponents_KosarajuAlgo {

	public static void main(String[] args) {
		Scc_StronglyConnectedComponents_KosarajuAlgo obj = new Scc_StronglyConnectedComponents_KosarajuAlgo();
		GraphAdjLst g = new GraphAdjLst();
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 3);
		g.addEdge(6, 5);
		g.addEdge(6, 7);
		g.addEdge(7, 8);
		g.addEdge(8, 9);
		g.addEdge(9, 6);
		g.addEdge(9, 10);

		List<Set<Integer>> components = obj.getStronglyConnectedComponents(g);
		System.out.println(components);
	}

    // Idea: Do dfs and populate the topological order stack. We do another dfs in this order.
    // 		Then reverse the egdes in the graph so that second dfs will not go out of strong connected component.
    // 		Do second dfs and store the vertices which form strong connected component when dfs ends.
	// O(V+E)
	public List<Set<Integer>> getStronglyConnectedComponents(GraphAdjLst g) {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> vis = new HashSet<>();
		for (int curr: g.adj.keySet()) {
			if(!vis.contains(curr)) {
				dfs(g, curr, stack, vis);   // dfs and populate resStack in reverse topological order
			}
		}
		
		g = reverGraph(g);  //reverse the graph edges
		
		List<Set<Integer>> components = new ArrayList<>();
		vis = new HashSet<>();
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			Set<Integer> set = new HashSet<>();
			if(!vis.contains(curr)) {
				dfs2(g, curr, set, vis); // dfs and populate the component set.
				components.add(set);
			}
			
		}
		return components;
	}

	// O(V+E)
	private GraphAdjLst reverGraph(GraphAdjLst g) {
		GraphAdjLst newG = new GraphAdjLst();	// O(V+E)
		for (int src: g.adj.keySet()) {
			for(int dest: g.adj.get(src)) {
				newG.addEdge(dest, src);
			}
		}
		return newG;
	}

	// O(V+E)
	private void dfs(GraphAdjLst g, int curr, Stack<Integer> stack, Set<Integer> vis) {
		vis.add(curr);
		for (int neigh: g.adj.get(curr)) {
			if (!vis.contains(neigh)) {
				dfs(g, neigh, stack, vis);
			}
		}
		stack.add(curr);
	}
	
	// O(V+E)
	private void dfs2(GraphAdjLst g, int curr, Set<Integer> set, Set<Integer> vis) {
		vis.add(curr);
		set.add(curr);
		for (int neigh: g.adj.get(curr)) {
			if (!vis.contains(neigh)) {
				dfs2(g, neigh, set, vis);
			}
		}
	}
}
