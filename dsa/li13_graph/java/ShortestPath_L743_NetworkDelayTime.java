
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPath_L743_NetworkDelayTime {

	public static void main(String[] args) {
		ShortestPath_L743_NetworkDelayTime obj = new ShortestPath_L743_NetworkDelayTime();

		int[][] times = new int[][]{
            {2,1,1},
            {2,3,1},
            {3,4,1}};
		System.out.println(obj.networkDelayTime(times, 4, 2));
	}

    // Problem: https://leetcode.com/problems/network-delay-time/
    // Idea: We need to find the shartest path to each vertex. Max of all these is the result.
	public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for(int i=1; i<=n; i++)
            adj.put(i, new ArrayList<>());
        for(int[] edge: times){
            int s = edge[0], d = edge[1], t = edge[2];
            adj.get(s).add(new int[]{t, d});
        }

        int[] dist = new int[n+1];      // not needed
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        HashSet<Integer> vis = new HashSet<>();
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        q.add(new int[]{0, k});
        int maxTime = 0;
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int time = curr[0], node = curr[1];
            if(vis.contains(node))
                continue;

            vis.add(node);
            maxTime = Math.max(maxTime, time);
            for(int[] nei: adj.get(node)){
                int neiNode = nei[1], edgeTime = nei[0];
                if(!vis.contains(neiNode)){
                    if(time+edgeTime < dist[neiNode]){
                        dist[neiNode] = time+edgeTime;
                        q.add(new int[]{dist[neiNode], neiNode});
                    }
                }
            }
        }

        return vis.size() == n ? maxTime: -1;
    }
}
