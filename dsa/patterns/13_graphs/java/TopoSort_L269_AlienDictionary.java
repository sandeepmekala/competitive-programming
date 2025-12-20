import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopoSort_L269_AlienDictionary {

	public static void main(String[] args) {
		TopoSort_L269_AlienDictionary obj = new TopoSort_L269_AlienDictionary();

		String[] words = new String[] {"wrt","wrf","er","ett","rftt"};
		// String[] words = new String[] {"zy","zx"};
		System.out.println(obj.alienOrder(words));
	}

	// Problem: https://www.lintcode.com/problem/892
	// Idea: Words are already sorted lexicographically by the rules of this new language. Hence, we can find the relationship between the chars from adjecent words.
	// Build a relationship graph from adjacent word chars.
	// From this graph reverse topological order is tha answer
	public String alienOrder(String[] words) {
		Map<Character, List<Character>> adj = new HashMap<>();
		for(String word: words) {
			for(char ch: word.toCharArray()) {
				adj.putIfAbsent(ch, new ArrayList<>());
			}
		}

		for(int i=0; i<words.length-1; i++) {
			String w1 = words[i], w2 = words[i+1];
			int min = Math.min(w1.length(), w2.length());
			for(int j=0; j<min; j++) {
				if(w1.charAt(j) != w2.charAt(j)) {
					adj.get(w1.charAt(j)).add(w2.charAt(j));
					break;		// we have to break as we are sure only first chars are in lex order.
				}
			}
		}

		Set<Character> vis = new HashSet<>();
		Set<Character> pathVis = new HashSet<>();
		Stack<Character> st = new Stack<>();
		for(char ch: adj.keySet()) {
			if(!vis.contains(ch)){
				if(!dfs(adj, ch, st, vis, pathVis))
					return "";
			}
		}
		StringBuffer sb = new StringBuffer();
		while(!st.isEmpty()) sb.append(st.pop());
		return sb.toString();
	}

	private boolean dfs(Map<Character, List<Character>> adj, char ch, Stack<Character> st,
			Set<Character> vis,	Set<Character> pathVis) {
		vis.add(ch);
		pathVis.add(ch);
		for(char nei: adj.get(ch)) {
			if(!vis.contains(nei)) {
				if(!dfs(adj, nei, st, vis, pathVis))
					return false;
			}else if(pathVis.contains(nei)) {
				return false;
			}
		}
		pathVis.remove(ch);
		st.add(ch);
		return true;
	}

}
