package edu.algos.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Algo10_TspWithNearestNeighbour {

	public static void main(String args[]){
		
		Algo10_TspWithNearestNeighbour obj = new Algo10_TspWithNearestNeighbour();
		GraphMatrix g = new GraphMatrix(4);		
		
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
	
	// concept: start from root, find next min dist vertex every time add it stack to visit next
	// if no next min vertex is found, exit
	// if all the vertices are visited, then return path
	public List<Integer> tsp(GraphMatrix g, int start){
		List<Integer> path = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(start);
		while(!stack.isEmpty()){
			int current = stack.pop();
			g.visited[current] = true;			
			path.add(current);
			
			int minInd = -1;
			int minWeight = Integer.MAX_VALUE;
			for(int i=0; i<g.adjMatrix[current].length; i++){
				if((g.adjMatrix[current][i] < minWeight) && !g.visited[i]){
					minInd = i;
					minWeight = g.adjMatrix[current][i];
				}
			}
			
			if(minInd != -1){	// there is a min edge vertex to be visited.
				stack.add(minInd);
			}else {
				break;
			}
		}
		
		for(int i=0; i<g.visited.length; i++){
			if(!g.visited[i]){
				System.out.println("No path exist to cover all nodes");
				return new ArrayList<Integer>();
			}
		}
		path.add(start);
		return path;
	}
}
