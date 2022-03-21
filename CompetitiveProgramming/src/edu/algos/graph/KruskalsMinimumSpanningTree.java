package edu.algos.graph;

import java.util.Arrays;

import edu.ds.graph.model.Edge;
import edu.ds.graph.model.Subset;
import edu.ds.graphs.Graph;
import edu.ds.graphs.UnionFind;

public class KruskalsMinimumSpanningTree {
	
	UnionFind  uf = new UnionFind();

	public static void main(String[] args) {
		KruskalsMinimumSpanningTree kmst = new KruskalsMinimumSpanningTree();
		Graph g = new Graph(4, 5);
		
		g.vertices = new int[] {0,1,2,3};
		g.edges[0] = new Edge(0, 1, 10);
		g.edges[1] = new Edge(0, 2, 6);
		g.edges[2] = new Edge(0, 3, 5);
		g.edges[3] = new Edge(1, 3, 15);
		g.edges[4] = new Edge(2, 3, 4);
		
		Edge[] mstEdges = kmst.mst(g);
		int minCost = 0;
		for(Edge mstEdge : mstEdges) {
			System.out.println(mstEdge.src+"->"+mstEdge.dest);
			minCost += mstEdge.weight;
		}
		System.out.println("Min Cost:"+minCost);
	}
	
	// concept: sort the edges and take v-1 min weight edges
	// 		use union find to detect the cycle
	// O(ElogE) as E = O(V^2)
	public Edge[] mst(Graph g) {
		Edge[] mst = new Edge[g.V-1];
		
		//O(ElogE)
		Arrays.sort(g.edges);
		
		Subset[] subsets = new Subset[g.V];
		for(int vertix : g.vertices) {
			subsets[vertix] = new Subset(vertix, vertix, 0);
		}
		
		//O(ElogV)
		int mstInd = 0;
		for(Edge edge : g.edges) {
			int srcParent = uf.find(subsets, edge.src);
			int destParent = uf.find(subsets, edge.dest);
			
			if(srcParent != destParent) {
				mst[mstInd++] = edge;
				uf.union(subsets, srcParent, destParent);
			}
		}
		
		return mst;
	}
}