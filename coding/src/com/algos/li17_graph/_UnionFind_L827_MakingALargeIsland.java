package edu.algos.li17_graph;

import java.util.HashSet;

public class _UnionFind_L827_MakingALargeIsland {
    private _UnionFind_G01_UnionFind ds = new _UnionFind_G01_UnionFind();
    public static void main (String[] args) {
        int[][] grid = {
            {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
            {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
        };

        _UnionFind_L827_MakingALargeIsland obj = new _UnionFind_L827_MakingALargeIsland();
        int ans = obj.largestIsland(grid);
        System.out.println("The largest group of connected 1s is of size: " + ans);
    }

    public int largestIsland(int grid[][]) {
        int n = grid.length;
        ds.makeSet(n*n);
        // step - 1
        for (int row = 0; row < n ; row++) {
            for (int col = 0; col < n ; col++) {
                if (grid[row][col] == 0) 
                    continue;

                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                for (int i = 0; i < 4; i++) {
                    int nrow = row + dr[i];
                    int ncol = col + dc[i];
                    if (isValid(nrow, ncol, n) && grid[nrow][ncol] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = nrow * n + ncol;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        // step 2
        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) 
                    continue;

                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n)) {
                        if (grid[newr][newc] == 1) {
                            components.add(ds.find(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                for (Integer parent : components) {
                    sizeTotal += ds.size.get(parent);
                }
                max = Math.max(max, sizeTotal + 1);
            }
        }
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            int parent = ds.find(cellNo);
            max = Math.max(max, ds.size.get(parent));
        }
        return max;
    }
    
    private boolean isValid(int newr, int newc, int n) {
        return newr >= 0 && newr < n && newc >= 0 && newc < n;
    }
}
