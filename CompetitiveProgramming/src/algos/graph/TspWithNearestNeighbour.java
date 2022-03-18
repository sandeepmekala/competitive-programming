package algos.graph;

import java.util.Stack;

public class TspWithNearestNeighbour {
	
	private int V;
	private int adjacentMatrix[][];
	private boolean[] isVisited;
	
	public TspWithNearestNeighbour(int V){
		this.V = V;
		adjacentMatrix = new int[V][V];
		isVisited = new boolean[V];
	}
	private void addEdge(int from, int to, int weight){
		adjacentMatrix[from][to] = weight;		
	}

	public static void main(String args[]){
		
		TspWithNearestNeighbour graph = new TspWithNearestNeighbour(4);
		
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 0, 3);
		graph.addEdge(1, 2, 4);
		graph.addEdge(2, 1, 5);
		graph.addEdge(2, 3, 1);
		graph.addEdge(3, 2, 10);
		graph.addEdge(3, 0, 4);
		graph.addEdge(0, 3, 1);
		
		graph.tsp(0);
	}
	
	//concept: find next min dist vertex every time and visit
	public void tsp(int startNode){
		Stack<Integer> s = new Stack<Integer>();
		
		s.add(startNode);
		String path = "";
		while(!s.isEmpty()){
			int currentNode = s.pop();
			isVisited[currentNode] = true;
			
			path += " "+currentNode;
			int minInd = -1;
			int minWeight = Integer.MAX_VALUE;
			for(int i=0; i<adjacentMatrix[currentNode].length; i++){
				if((adjacentMatrix[currentNode][i] < minWeight) && !isVisited[i]){
					minInd = i;
					minWeight = adjacentMatrix[currentNode][i];
				}
			}
			
			if(minWeight == Integer.MAX_VALUE){
				break;
			}

			s.add(minInd);
		}
		
		for(int i=0; i<isVisited.length; i++){
			if(!isVisited[i]){
				System.out.println("No path exist to cover all nodes");
				return;
			}
		}
		System.out.println(path+" "+startNode);
	}
}
