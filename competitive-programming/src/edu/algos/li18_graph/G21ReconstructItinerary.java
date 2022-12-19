package edu.algos.li18_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class G21ReconstructItinerary {

	public static void main(String[] args) {
		G21ReconstructItinerary obj = new G21ReconstructItinerary();

		String[][] tickets = new String[][] { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
		List<List<String>> list = new ArrayList<>();
		for(String[] ticket: tickets) {
			list.add(new ArrayList<String>(Arrays.asList(ticket)));
		}
		System.out.println(obj.findItinerary(list));
	}

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
		
		ArrayList<String> neighs = adjlist.get(src);
		for(int i=0; i<neighs.size(); i++) {
			String dst = neighs.get(i);
			res.add(dst);
			neighs.remove(i);
			if(dfs(adjlist, dst, res, length)) {
				return true;
			}
			neighs.add(i, dst);
			res.remove(res.size()-1);
		}
		return false;
	}

}
