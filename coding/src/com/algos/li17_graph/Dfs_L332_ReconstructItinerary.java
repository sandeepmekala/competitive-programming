package  com.algos.li17_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Dfs_L332_ReconstructItinerary {

	public static void main(String[] args) {
		Dfs_L332_ReconstructItinerary obj = new Dfs_L332_ReconstructItinerary();

		String[][] tickets = new String[][] { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
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
	// TODO
	public List<String> findItinerary(List<List<String>> tickets) {
		
		Collections.sort(tickets, (a, b)->{
			if(a.get(0).equals(b.get(0))) {
				return a.get(1).compareTo(b.get(1));
			}else {
				return a.get(0).compareTo(b.get(0));
			}			
		});
		
		HashMap<String, ArrayList<String>> adj = new HashMap<>();
		for(List<String> ticket: tickets) {
			String src = ticket.get(0);
			adj.put(src, new ArrayList<String>());
		}
		for(List<String> ticket: tickets) {
			String src = ticket.get(0);
			adj.get(src).add(ticket.get(1));
		}
		
		ArrayList<String> res = new ArrayList<>();
		res.add("JFK");
		dfs(adj, "JFK", res, tickets.size());
		
		return res;
	}

	private boolean dfs(HashMap<String, ArrayList<String>> adjlist, String src, ArrayList<String> res, int length) {
		if(res.size() == length+1) 
			return true;
		
		if(!adjlist.containsKey(src)) 
			return false;
		
		for(int i=0; i<adjlist.get(src).size(); i++) {
			String dst = adjlist.get(src).get(i);
			res.add(dst);
			adjlist.get(src).remove(i);
			if(dfs(adjlist, dst, res, length)) 
				return true;
			
			adjlist.get(src).add(i, dst);
			res.remove(res.size()-1);
		}
		return false;
	}

}
