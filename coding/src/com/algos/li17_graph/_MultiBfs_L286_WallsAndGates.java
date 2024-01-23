package  com.algos.li17_graph;

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
                    visited[i][j] = true;
                    q.add(new int[] {i, j, 0});
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] room = q.remove();
                int row = room[0], col = room[1], dist = room[2];
                rooms[row][col] = dist;

                int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
                for (int[] dir : directions) {
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];
                    if (isSafe(rooms, m, n, visited, nrow, ncol)) {
                        visited[nrow][ncol] = true;
                        q.add(new int[] { nrow, ncol,  dist+1});
                    }
                }
            }
        }
    }

    private boolean isSafe(int[][] rooms, int m, int n, boolean[][] visited, int nrow, int ncol) {
        return nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
                && rooms[nrow][ncol] != -1 && !visited[nrow][ncol];
    }

}
