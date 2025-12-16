package li13_graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MultiBfs_L286_WallsAndGates {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        MultiBfs_L286_WallsAndGates obj = new MultiBfs_L286_WallsAndGates();
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
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    vis[i][j] = true;
                    q.add(new int[] {i, j, 0});
                }
            }
        }
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int[] room = q.remove();
            int row = room[0], col = room[1], dist = room[2];
            rooms[row][col] = dist;

            for (int[] dir : dirs) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];
                if (isSafe(rooms, m, n, vis, nrow, ncol)) {
                    vis[nrow][ncol] = true;
                    q.add(new int[] { nrow, ncol,  dist+1});
                }
            }
        }
    }

    private boolean isSafe(int[][] rooms, int m, int n, boolean[][] visited, int nrow, int ncol) {
        return nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                && rooms[nrow][ncol] != -1 && !visited[nrow][ncol];
    }

}
