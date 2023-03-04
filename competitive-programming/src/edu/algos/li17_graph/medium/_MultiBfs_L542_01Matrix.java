package edu.algos.li17_graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _MultiBfs_L542_01Matrix {
    public static void main(String[] args) {
        int[][] grid = {
                { 0, 1, 1, 0 },
                { 1, 1, 0, 0 },
                { 0, 0, 1, 1 }
        };

        _MultiBfs_L542_01Matrix obj = new _MultiBfs_L542_01Matrix();
        int[][] ans = obj.updateMatrix(grid);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        int[][] visited = new int[m][n];
        int[][] dist = new int[m][n];
        
        Queue<Node> q = new LinkedList<Node>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int dr[] = { -1, 0, +1, 0 };
        int dc[] = { 0, +1, 0, -1 };
        while (!q.isEmpty()) {
            Node node = q.remove();
            int row = node.first, col = node.second, steps = node.third;
            dist[row][col] = steps;
            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                        && visited[nrow][ncol] == 0) {
                    visited[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol, steps + 1));
                }
            }
        }

        return dist;
    }
}

class Node {
    int first;
    int second;
    int third;

    Node(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}