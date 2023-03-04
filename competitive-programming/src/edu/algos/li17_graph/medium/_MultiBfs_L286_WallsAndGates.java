package edu.algos.li17_graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _MultiBfs_L286_WallsAndGates {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        _MultiBfs_L286_WallsAndGates obj = new _MultiBfs_L286_WallsAndGates();
        int[][] rooms = new int[][] {
                { INF, -1, 0, INF },
                { INF, INF, INF, -1 },
                { INF, -1, INF, -1 },
                { 0, -1, INF, INF } };
        obj.wallsAndGates(rooms);

        for (int[] row : rooms) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Problem: https://leetcode.com/problems/walls-and-gates/
    // https://www.lintcode.com/problem/663/
    // Idea: Do multi level bfs from all the gates and track dist variable
    // Increase the dist for each level.
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] room = q.remove();
                int row = room[0], col = room[1];
                rooms[row][col] = dist;
                int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
                for (int[] dr : directions) {
                    int nrow = row + dr[0];
                    int ncol = col + dr[1];
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
                            && rooms[nrow][ncol] != -1 && !visited[nrow][ncol]) {
                        visited[nrow][ncol] = true;
                        q.add(new int[] { nrow, ncol });
                    }

                }
            }
            dist++;
        }
    }

}
