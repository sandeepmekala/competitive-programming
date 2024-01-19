package edu.algos.li17_graph;

import java.util.HashSet;
import java.util.Set;

public class _UnionFind_L947_MostStonesRemovedWithSameRowOrColumn {
    private _UnionFind_G01_UnionFind ds = new _UnionFind_G01_UnionFind();
    public static void main (String[] args) {
        int[][] stones = {
            {0, 0}, {0, 2},
            {1, 3}, {3, 1},
            {3, 2}, {4, 3}
        };

        _UnionFind_L947_MostStonesRemovedWithSameRowOrColumn obj = new _UnionFind_L947_MostStonesRemovedWithSameRowOrColumn();
        int ans = obj.removeStones(stones);
        System.out.println("The maximum number of stones we can remove is: " + ans);
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        ds.makeSet(maxRow + maxCol + 1);
        Set<Integer> stoneNodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int row = stones[i][0];
            int col = stones[i][1] + maxRow + 1;
            
            ds.unionByRank(row, col);
            stoneNodes.add(row);
            stoneNodes.add(col);        // these are the nodes in uf where stones are there.
        }

        int count = 0;
        for (Integer node : stoneNodes) {
            if (ds.find(node) == node) {
                count++;
            }
        }
        return n - count;
    }
}
