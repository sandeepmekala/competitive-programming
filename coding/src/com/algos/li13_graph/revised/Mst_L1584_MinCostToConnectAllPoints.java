package  com.algos.li13_graph.revised;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Mst_L1584_MinCostToConnectAllPoints {

	public static void main(String[] args) {
		Mst_L1584_MinCostToConnectAllPoints obj = new Mst_L1584_MinCostToConnectAllPoints();
		int[][] points = new int[][] {{0,0},{2,2},{3,10},{5,2},{7,0}};
		System.out.println(obj.minCostConnectPoints(points));
	}
	
    // Problem: https://leetcode.com/problems/min-cost-to-connect-all-points/
    // Idea: It forms a fully connected graph with edge weights is equal to manhatan distance.
    // Find MST cost in this graph
	public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());		// coordinate index will act as node in graph
        for(int i=0; i<n; i++){     // calculate dist for [i,j] and [j,i]
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
    
    private int primsMst(int n, List<List<int[]>> adj) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((d1, d2)->d1[0]-d2[0]);
		Set<Integer> vis = new HashSet<>();

		int sum = 0;
		pq.add(new int[]{0, 0});	// {dist, node}
		while(!pq.isEmpty()) {
			int curr[] = pq.remove();
			int dis = curr[0], node = curr[1];

			if(vis.contains(node)) 
				continue;

			vis.add(node);
			sum += dis;			// track parent here for capturing mst.
			for (int neigh[]: adj.get(node)) {
				int neighNode = neigh[0], edgeWeight = neigh[1];
				if(!vis.contains(neighNode))
					pq.add(new int[]{edgeWeight, neighNode});
			}
		}

		return sum;
	}

}
