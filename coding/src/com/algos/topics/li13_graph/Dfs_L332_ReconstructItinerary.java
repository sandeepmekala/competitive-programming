package  com.algos.topics.li13_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dfs_L332_ReconstructItinerary {

	public static void main(String[] args) {
		Dfs_L332_ReconstructItinerary obj = new Dfs_L332_ReconstructItinerary();

		String[][] tickets = {
			{ "MUC", "LHR" },
			{ "JFK", "MUC" },
			{ "SFO", "SJC" },
			{ "LHR", "SFO" } };
		List<List<String>> list = new ArrayList<>();
		for(String[] ticket: tickets) {
			list.add(new ArrayList<String>(Arrays.asList(ticket)));
		}
		System.out.println(obj.findItinerary(list));
	}

	// Problem: https://leetcode.com/problems/reconstruct-itinerary/
	// Idea: We need to find path in tree/graph where path contains all edges in order.
	// Since, we need to give preference to arivals in lex order, we need to sort the tickets in that order and build graph adj list in that order.
	// We need to consider each edge only once. Hence edge will be removed from graph once it is considered.
	// If that path doesn't give solution, we backtrack and add that edge back.
	// We can't use vis arrau for nodes as same node can be visited multiple times.
	public List<String> findItinerary(List<List<String>> tickets) {
		Collections.sort(tickets, (a, b)->{
			if(a.get(0).equals(b.get(0))) {
				return a.get(1).compareTo(b.get(1));
			}else {
				return a.get(0).compareTo(b.get(0));
			}
		});

		Map<String, List<String>> adj = new HashMap<>();
		for(List<String> ticket: tickets) {
			String src = ticket.get(0);
			adj.putIfAbsent(src, new ArrayList<>());
			adj.get(src).add(ticket.get(1));
		}

		List<String> ans = new ArrayList<>();
		ans.add("JFK");
		dfs(adj, "JFK", ans, tickets.size());
		return ans;
	}

	private boolean dfs(Map<String, List<String>> adj, String src, List<String> ans, int length) {
		if(ans.size() == length+1)
			return true;

		if(!adj.containsKey(src)) 				// if no outgoing edge from a node and we still didn't reach n+1 nodes above
			return false;

		for(int i=0; i<adj.get(src).size(); i++) {
			String dst = adj.get(src).get(i);
			ans.add(dst);
			adj.get(src).remove(i);
			if(dfs(adj, dst, ans, length))
				return true;

			adj.get(src).add(i, dst);
			ans.remove(ans.size()-1);
		}

		return false;
	}

}
