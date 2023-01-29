package edu.algos.li18_gridgraph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L286_MultiBfs_WallsAndGates {

	public static void main(String[] args) {
		L286_MultiBfs_WallsAndGates obj = new L286_MultiBfs_WallsAndGates();
		int[][] rooms = new int[][] {
			{2147483647,-1,0,2147483647},
			{2147483647,2147483647,2147483647,-1},
			{2147483647,-1,2147483647,-1},
			{0,-1,2147483647,2147483647}};
		obj.wallsAndGates(rooms);
		
		for(int[] row: rooms) {
			System.out.println(Arrays.toString(row));
		}
	}
    // Problem: https://leetcode.com/problems/walls-and-gates/
    // https://www.lintcode.com/problem/663/
    // Idea: Do multi level bfs from all the gates and track dist variable
    // Increase the dist for each level.
	int INF = Integer.MAX_VALUE;
	public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0; k<size; k++){
                int[] room = q.remove();
                int row = room[0];
                int col = room[1];
                if(isSafe(rooms, row, col, visited)) {
                	rooms[row][col] = dist;
                	visited[row][col] = true;
                    int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
                    for(int[] direction: directions){
                        int i = row+direction[0];
                        int j = col+direction[1];
                        if(isSafe(rooms, i, j, visited)){
                            q.add(new int[]{i, j});
                        }
                    }
                }
            }
            dist++;
        }
    }

    private boolean isSafe(int[][] rooms, int i, int j, boolean[][] visited){
        int m = rooms.length;
        int n = rooms[0].length;
        
        return i>=0 && i<m && j>=0 && j<n && rooms[i][j] != -1 && !visited[i][j]; // we don't need to check as we are moving away from gate and all the sorrounding cells of date are marked as visited.
    }

}
