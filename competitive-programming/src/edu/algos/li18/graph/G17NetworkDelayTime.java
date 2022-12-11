package edu.algos.li18.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class G17NetworkDelayTime {

	public static void main(String[] args) {
		G17NetworkDelayTime obj = new G17NetworkDelayTime();
		
		int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
		System.out.println(obj.networkDelayTime(times, 4, 2));
	}

	public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, ArrayList<int[]>> adjlist = new HashMap<>();
        for(int i=1; i<=n; i++){
            adjlist.put(i, new ArrayList<>());
        }
        for(int[] edge: times){
            int s = edge[0], d = edge[1], t = edge[2];
            adjlist.get(s).add(new int[]{t, d});
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->{
            return a[0]-b[0];
        });
        q.add(new int[]{0, k});
        int time = 0;
        while(!q.isEmpty()){
            int[] current = q.remove();
            int src = current[1], st = current[0];
            if(!visited.contains(src)){
                visited.add(src);
                time = Math.max(time, st);
                for(int[] neigh: adjlist.get(src)){
                    int dst = neigh[1], stodt = neigh[0];
                    if(st+stodt < dist[dst]){
                        dist[dst] = st+stodt;
                        q.add(new int[]{dist[dst], dst});
                    }
                }
            }
        }
        
        return visited.size() == n ? time: -1;
    }
}