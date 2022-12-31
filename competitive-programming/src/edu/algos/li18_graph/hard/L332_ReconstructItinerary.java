package edu.algos.li18_graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class L332_ReconstructItinerary {

	public static void main(String[] args) {
		L332_ReconstructItinerary obj = new L332_ReconstructItinerary();

		String[][] tickets = new String[][] { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
		List<List<String>> list = new ArrayList<>();
		for(String[] ticket: tickets) {
			list.add(new ArrayList<String>(Arrays.asList(ticket)));
		}
		System.out.println(obj.findItinerary(list));
	}

	// Problem: https://leetcode.com/problems/reconstruct-itinerary/
	// Idea: We need to find path in tree/graph where path contains all the nodes.
	// Use tree path finding algorithm
	// Since, we need to give preference to arivals in lex order, we need to sort the tickets in that order and build graph adj list in that order.
	public List<String> findItinerary(List<List<String>> tickets) {
		
		Collections.sort(tickets, (a, b)->{
			if(a.get(0).equals(b.get(0))) {
				return a.get(1).compareTo(b.get(1));
			}else {
				return a.get(0).compareTo(b.get(0));
			}			
		});
		
		HashMap<String, ArrayList<String>> adjlist = new HashMap<>();
		for(List<String> ticket: tickets) {
			String src = ticket.get(0);
			adjlist.put(src, new ArrayList<String>());
		}
		for(List<String> ticket: tickets) {
			String src = ticket.get(0);
			adjlist.get(src).add(ticket.get(1));
		}
		
		ArrayList<String> res = new ArrayList<>();
		res.add("JFK");
		dfs(adjlist, "JFK", res, tickets.size());
		
		return res;
	}

	private boolean dfs(HashMap<String, ArrayList<String>> adjlist, String src, ArrayList<String> res, int length) {
		if(res.size() == length+1) {
			return true;
		}
		if(!adjlist.containsKey(src)) {
			return false;
		}
		
		for(int i=0; i<adjlist.get(src).size(); i++) {
			String dst = adjlist.get(src).get(i);
			res.add(dst);
			adjlist.get(src).remove(i);
			if(dfs(adjlist, dst, res, length)) {
				return true;
			}
			adjlist.get(src).add(i, dst);
			res.remove(res.size()-1);
		}
		return false;
	}

}
