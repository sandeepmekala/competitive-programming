package  com.algos.li17_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import  com.algos.li30_model.GraphMatrix;

public class _Tsp_G01_TspWithNearestNeighbour {

	public static void main(String args[]){
		
		_Tsp_G01_TspWithNearestNeighbour obj = new _Tsp_G01_TspWithNearestNeighbour();
		GraphMatrix g = new GraphMatrix(5);		
		
		g.addEdge(0, 1, 2);
		g.addEdge(1, 0, 3);
		g.addEdge(1, 2, 4);
		g.addEdge(2, 1, 5);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 2, 10);
		g.addEdge(3, 0, 4);
		g.addEdge(0, 3, 1);
		
		List<Integer> path = obj.tsp(g, 0);
		System.out.println(path);
	}
	
	// Problem: What is the shortest possible route that visits each city exactly once and returns to the origin city.
	// Idea: Start from root, find next min dist vertex every time add it to stack to visit next
	// If no next min vertex is found, exit
	// If all the vertices are visited, then return path
	public List<Integer> tsp(GraphMatrix g, int start){
		List<Integer> path = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[g.V];
		s.add(start);
		while(!s.isEmpty()){
			int curr = s.pop();
			visited[curr] = true;			
			path.add(curr);
			
			int minInd = -1;
			int minWeight = Integer.MAX_VALUE;
			for(int i=0; i<g.adjMatrix[curr].length; i++){
				if((g.adjMatrix[curr][i] < minWeight) && !visited[i]){
					minInd = i;
					minWeight = g.adjMatrix[curr][i];
				}
			}
			
			if(minInd == -1)	// there is a min edge vertex to be visited.
				break;
				
			s.add(minInd);
		}
		
		for(int i=0; i<visited.length; i++){
			if(!visited[i]){
				System.out.println("No path exist to cover all nodes");
				return new ArrayList<Integer>();
			}
		}
		path.add(start);		// just add root to path to look like complete loop.
		return path;
	}
}
