package  com.algos.topics.li13_graph.revised;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.algos.topics.models.Edge;

public class Mst_KruskalsMinimumSpanningTree {

	UnionFind_UnionFind  uf = new UnionFind_UnionFind();

	public static void main(String[] args) {
		Mst_KruskalsMinimumSpanningTree kmst = new Mst_KruskalsMinimumSpanningTree();

		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 1, 10));
		edges.add(new Edge(0, 2, 6));
		edges.add(new Edge(0, 3, 5));
		edges.add(new Edge(1, 3, 15));
		edges.add(new Edge(2, 3, 4));

		int n=4;
		List<Edge> mstEdges = kmst.mst(edges, n);
		int minCost = 0;
		for(Edge mstEdge : mstEdges) {
			System.out.println(mstEdge.src+"->"+mstEdge.dest);
			minCost += mstEdge.weight;
		}

		System.out.println("Min Cost:"+minCost);
	}

	// Idea: Sort the edges and take v-1 min weight edges
	// Use union find to detect the cycle
	// O(ElogE) as E = O(V^2)
	public List<Edge> mst(List<Edge> edges, int n) {
		//O(ElogE)
		Collections.sort(edges);
		uf.makeSet(n);

		//O(E*4*alpha)
		List<Edge> mst = new ArrayList<>();
		for(Edge edge : edges) {					//O(E)
			int srcPar = uf.find(edge.src);			//find will 4*alpha with path compression
			int destPar = uf.find(edge.dest);

			if(srcPar != destPar) {
				mst.add(edge);
				uf.unionByRank(srcPar, destPar);	//O(1)
			}
		}

		return mst;
	}
}
