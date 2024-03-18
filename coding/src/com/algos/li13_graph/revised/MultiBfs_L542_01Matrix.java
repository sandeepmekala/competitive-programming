package  com.algos.li13_graph.revised;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MultiBfs_L542_01Matrix {
    public static void main(String[] args) {
        int[][] grid = {
                { 0, 1, 1, 0 },
                { 1, 1, 0, 0 },
                { 0, 0, 1, 1 }
        };

        MultiBfs_L542_01Matrix obj = new MultiBfs_L542_01Matrix();
        int[][] ans = obj.updateMatrix(grid);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        int[][] vis = new int[m][n];
        int[][] dist = new int[m][n];
        
        Queue<Node> q = new LinkedList<Node>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            Node node = q.remove();
            int row = node.row, col = node.col, steps = node.steps;
            dist[row][col] = steps;
            
            for(int[] dir: dirs) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];
                if (isSafe(m, n, vis, nrow, ncol)) {
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol, steps + 1));
                }
            }
        }

        return dist;
    }

    private boolean isSafe(int m, int n, int[][] vis, int nrow, int ncol) {
        return nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                && vis[nrow][ncol] == 0;
    }
}

class Node {
    int row;
    int col;
    int steps;

    Node(int _first, int _second, int _third) {
        this.row = _first;
        this.col = _second;
        this.steps = _third;
    }
}