package edu.algos.li00.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphMatrix {
	public int V;
	public int[][] adjMatrix;
	public boolean[] visited;
	public GraphMatrix(int V){
		this.V = V;
		adjMatrix = new int[V][V];
		visited = new boolean[V];
	}
	
	public void addEdge(int src, int dest){
		adjMatrix[src][dest] = 1;
	}
	
	public void addEdge(int src, int dest, int weight){
		adjMatrix[src][dest] = weight;
	}
	
	
	public void bfs(int startNode){
		Queue<Integer> q = new LinkedList<>();
		
		q.add(startNode);
		String path = "";
		
		while(!q.isEmpty()){
			int currentNode = q.remove();
			if(!visited[currentNode]){
				path += " "+currentNode;
				
				for(int i=0; i<adjMatrix[currentNode].length; i++){
					if(adjMatrix[currentNode][i] == 1){
						q.add(i);
					}
				}
			}
			visited[currentNode] = true;
		}
		
		System.out.println(path);
		
	}
	
	public static void main(String[] args) {
		GraphMatrix g = new GraphMatrix(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		g.bfs(2);
		
	}
}
