package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _ShortestPath_L1976_NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        _ShortestPath_L1976_NumberOfWaysToArriveAtDestination obj = new _ShortestPath_L1976_NumberOfWaysToArriveAtDestination();

        int[][] roads = new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        // [[0,1,1],[1,2,4],[0,4,3],[3,2,5],[3,4,1],[3,0,5],[1,3,1]]

        System.out.println(obj.countPaths(7, roads));
    }

    // Problem: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
    // Idea: Apply Dijkstra and track number of ways to arrive at each node.
    // If we arrive at a neigh node with less dist, just take num ways from node
    // If we arrive at a neigh node with same dist, it means we are arriving from different route. Hence, you need to sum the ways of node to neigh node.
    public int countPaths(int n, int[][] roads) {
        HashMap<Integer, ArrayList<int[]>> adjList = new HashMap<Integer, ArrayList<int[]>>();
        for(int i=0; i<n; i++) adjList.put(i, new ArrayList<>());
        for(int[] road: roads){
            adjList.get(road[0]).add(new int[]{road[1], road[2]});
            adjList.get(road[1]).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((d1, d2) -> d1[0]-d2[0]);
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0; ways[0] = 1;
        pq.add(new int[]{0, 0});
        int mod = (int) (1e9+7);
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int nodeDist = curr[0], currNode = curr[1];

            for(int[] neigh: adjList.get(currNode)){
                int neighNode = neigh[0], edgeWeight = neigh[1];
                if(nodeDist+edgeWeight < dist[neighNode]){    // ariving first time
                    ways[neighNode] = ways[currNode];
                    dist[neighNode] = nodeDist+edgeWeight;
                    pq.add(new int[]{nodeDist+edgeWeight, neighNode});
                }else if(nodeDist+edgeWeight == dist[neighNode]){ // different path arriving the neigh node with same min dist. Hence, sum ways.
                    ways[neighNode] = (ways[neighNode] + ways[currNode])%mod;
                }
            }
        }

        return ways[n-1]%mod;
    }
}
