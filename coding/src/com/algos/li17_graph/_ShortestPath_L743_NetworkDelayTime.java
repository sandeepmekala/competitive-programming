package  com.algos.li17_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class _ShortestPath_L743_NetworkDelayTime {

	public static void main(String[] args) {
		_ShortestPath_L743_NetworkDelayTime obj = new _ShortestPath_L743_NetworkDelayTime();
		
		int[][] times = new int[][]{
            {2,1,1},
            {2,3,1},
            {3,4,1}};
		System.out.println(obj.networkDelayTime(times, 4, 2));
	}

    // Problem: https://leetcode.com/problems/network-delay-time/
    // Idea: We need to find the shartest path to each vertex. Max of all these is the result.
	public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, ArrayList<int[]>> adjlist = new HashMap<>();
        for(int i=1; i<=n; i++)
            adjlist.put(i, new ArrayList<>());
        for(int[] edge: times){
            int s = edge[0], d = edge[1], t = edge[2];
            adjlist.get(s).add(new int[]{t, d});
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        q.add(new int[]{0, k});
        int maxTime = 0;
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int node = curr[1], time = curr[0];
            if(visited.contains(node))
                continue;    

            visited.add(node);
            maxTime = Math.max(maxTime, time);
            for(int[] neigh: adjlist.get(node)){
                int neighNode = neigh[1], edgeTime = neigh[0];
                if(!visited.contains(neighNode)){
                    if(time+edgeTime < dist[neighNode]){
                        dist[neighNode] = time+edgeTime;
                        q.add(new int[]{dist[neighNode], neighNode});
                    }
                }
            }
        }
        
        return visited.size() == n ? maxTime: -1;
    }
}
