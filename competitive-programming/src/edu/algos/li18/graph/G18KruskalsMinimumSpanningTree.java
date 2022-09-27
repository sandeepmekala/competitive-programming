package edu.algos.li18.graph;

import java.util.ArrayList;
import java.util.Collections;

import edu.algos.li00.model.Edge;

public class G18KruskalsMinimumSpanningTree {
	
	G05UnionFind  uf = new G05UnionFind();

	public static void main(String[] args) {
		G18KruskalsMinimumSpanningTree kmst = new G18KruskalsMinimumSpanningTree();

		ArrayList<Edge> g = new ArrayList<>();
		g.add(new Edge(0, 1, 10));
		g.add(new Edge(0, 2, 6));
		g.add(new Edge(0, 3, 5));
		g.add(new Edge(1, 3, 15));
		g.add(new Edge(2, 3, 4));
		
		ArrayList<Edge> mstEdges = kmst.mst(g);
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
	public ArrayList<Edge> mst(ArrayList<Edge> edges) {
		//O(ElogE)
		Collections.sort(edges);
		
		uf.makeSet(edges);
		
		//O(ElogV)
		ArrayList<Edge> mst = new ArrayList<>();
		for(Edge edge : edges) {					//O(E)
			int srcParent = uf.find(edge.src);		//find will log(V) with path compression
			int destParent = uf.find(edge.dest);
			
			if(srcParent != destParent) {
				mst.add(edge);
				uf.union(srcParent, destParent);	//O(1)
			}
		}
		
		return mst;
	}
}