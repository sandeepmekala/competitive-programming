package ds.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphWithAdjacentList {
	private int V;
	private LinkedList<Integer> adjacentList[];
	private boolean isVisited[];
	
	public GraphWithAdjacentList(int V){
		this.V = V;
		adjacentList = new LinkedList[V];
		isVisited = new boolean[V];
		for(int i=0; i<V; i++){
			adjacentList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int from, int to){
		adjacentList[from].add(to);
	}
	
	public void BFS(int startNode){
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(startNode);
		String path = "";
		while(!q.isEmpty()){
			int currentNode = q.remove();
			if(!isVisited[currentNode]){
				path += " "+currentNode;
				
				for(int i=0; i<adjacentList[currentNode].size();i++){
					q.add(adjacentList[currentNode].get(i));
				}
			}
			
			isVisited[currentNode] = true;
		}	
		System.out.println(path);
	}
	
	public void DFS(int startNode){
		Stack<Integer> s = new Stack<Integer>();
		
		s.add(startNode);
		String path = "";
		while(!s.isEmpty()){
			int currentNode = (int) s.pop();
			if(!isVisited[currentNode]){
				path += " "+currentNode;
				
				for(int i=0; i<adjacentList[currentNode].size();i++){
					s.add(adjacentList[currentNode].get(i));
				}
			}
			
			isVisited[currentNode] = true;
		}	
		System.out.println(path);
	}
	
	public static void main(String[] args) {

		GraphWithAdjacentList graph = new GraphWithAdjacentList(4);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		//graph.BFS(2);
		graph.DFS(2);
		
	}
}
