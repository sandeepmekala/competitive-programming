package edu.algos.li19_graph_grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G05WallsAndGates {

	public static void main(String[] args) {
		G05WallsAndGates obj = new G05WallsAndGates();
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
            ArrayList<int[]> queued = new ArrayList<>();
            while(!q.isEmpty()){
                queued.add(q.remove());
            }

            int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
            for(int[] room: queued){
                int row = room[0];
                int col = room[1];
                if(isSafe(rooms, row, col, visited)) {
                	rooms[row][col] = dist;
                	visited[row][col] = true;
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
        if(i>=0 && i<m && j>=0 && j<n && (rooms[i][j] == INF || rooms[i][j] == 0) && !visited[i][j]){
            return true;
        }
        return false;
    }

}
