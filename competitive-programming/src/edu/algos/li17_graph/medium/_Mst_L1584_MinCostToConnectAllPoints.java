package edu.algos.li17_graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class _Mst_L1584_MinCostToConnectAllPoints {

	public static void main(String[] args) {
		_Mst_L1584_MinCostToConnectAllPoints obj = new _Mst_L1584_MinCostToConnectAllPoints();
		int[][] points = new int[][] {{0,0},{2,2},{3,10},{5,2},{7,0}};
		System.out.println(obj.minCostConnectPoints(points));
	}
	
    // Problem: https://leetcode.com/problems/min-cost-to-connect-all-points/
    // Idea: It forms a fully connected graph with edge weights is equal to manhatan distance.
    // Find MST cost in this graph
	public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for(int i=0; i<n; i++)
            adj.put(i, new ArrayList<>());
        for(int i=0; i<n; i++){     // cal dist for [i,j] and [j,i]
            int x1 = points[i][0], y1 = points[i][1]; 
            for(int j=i+1; j<n; j++){
                int x2 = points[j][0], y2 = points[j][1]; 
                int dist = Math.abs(x1-x2)+Math.abs(y1-y2);
                adj.get(i).add(new int[]{j, dist});
                adj.get(j).add(new int[]{i, dist});
            }
        }
        
        return primsMst(n,adj);
    }
    
    private int primsMst(int n, HashMap<Integer, ArrayList<int[]>> adj) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((d1, d2)->d1[0]-d2[0]);
		HashSet<Integer> visited = new HashSet<Integer>();
		//int[] parent = new int[n];
		int sum = 0;
		
		pq.add(new int[]{0, 0});
		while(!pq.isEmpty()) {
			int top[] = pq.remove();
			int dis = top[0], node = top[1];
			if(visited.contains(node)) 
				continue;

			visited.add(node);
			sum += dis;			// track parent here for capturing mst.
			for (int neigh[]: adj.get(node)) {
				int neighNode = neigh[0], edgeWeight = neigh[1];
				if(!visited.contains(neighNode))
					pq.add(new int[]{edgeWeight, neighNode});
			}
		}

		return sum;
	}

}
