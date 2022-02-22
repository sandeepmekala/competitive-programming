package ds.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphWithAdjacentMatrix {
	private int V;
	private boolean[][] adjacentMatrix;
	private boolean[] isVisited;
	GraphWithAdjacentMatrix(int V){
		this.V = V;
		adjacentMatrix = new boolean[V][V];
		isVisited = new boolean[V];
	}
	
	public void addEdge(int from, int to){
		adjacentMatrix[from][to] = true;
	}
	
	public void BFS(int startNode){
		Queue<Integer> q = new LinkedList<>();
		
		q.add(startNode);
		String path = "";
		
		while(!q.isEmpty()){
			int currentNode = q.remove();
			if(!isVisited[currentNode]){
				path += " "+currentNode;
				
				for(int i=0; i<adjacentMatrix[currentNode].length; i++){
					if(adjacentMatrix[currentNode][i]){
						q.add(i);
					}
				}
			}
			isVisited[currentNode] = true;
		}
		
		System.out.println(path);
		
	}
	
	public void DFS(int startNode){
		Stack s = new Stack();
		
		s.add(startNode);
		String path = "";
		
		while(!s.isEmpty()){
			int currentNode = (int) s.pop();
			if(!isVisited[currentNode]){
				path += " "+currentNode;
				
				for(int i=0; i<adjacentMatrix[currentNode].length; i++){
					if(adjacentMatrix[currentNode][i]){
						s.add(i);
					}
				}
			}
			isVisited[currentNode] = true;
		}
		
		System.out.println(path);
		
	}
	
	public static void main(String[] args) {
		GraphWithAdjacentMatrix graph = new GraphWithAdjacentMatrix(4);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		graph.BFS(2);
		graph.DFS(0);
		
	}
}
