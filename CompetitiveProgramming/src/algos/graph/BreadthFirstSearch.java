package algos.graph;

import java.util.LinkedList;
import java.util.Queue;

import ds.graphs.GraphAdj;

public class BreadthFirstSearch {

	public static void main(String[] args) {
		BreadthFirstSearch obj = new BreadthFirstSearch();
		GraphAdj g = new GraphAdj(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		obj.bfs(g, 0);
	}
	public void bfs(GraphAdj g, int startNode){
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(startNode);
		String path = "";
		while(!q.isEmpty()){
			int currentNode = q.remove();
			if(!g.visited[currentNode]){
				path += " "+currentNode;
				
				for(int i=0; i<g.adj[currentNode].size();i++){
					q.add(g.adj[currentNode].get(i));
				}
			}
			
			g.visited[currentNode] = true;
		}	
		System.out.println(path);
	}

}
