package com.algos.topics.li13_graph.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Basics {
    public static void main(String[] args) {
        Basics obj = new Basics();

        // 1. Initialize adj list from list of edges
        int n = 8, m = 6;
        int[][] edges = new int[][]{
            {0,6,7},
            {0,1,2},
            {1,2,3},
            {1,3,3},
            {6,3,3},
            {3,5,1},
            {6,5,1},
            {2,5,1},
            {0,4,5},
            {4,6,2}};

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int[] edge: edges){
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }

        for(int i=0; i<adj.size(); i++){
            System.out.println(i+" : "+ adj.get(i).toString());
        }
        System.out.println();

        // 2. Giving direct graph as array
        int[][] graph = new int[][]{{1,3},{0,2},{1,3},{0,2}};
        for(int i=0; i<graph.length; i++){
            System.out.println(i+" : "+ Arrays.toString(graph[i]));
        }
    }
}
